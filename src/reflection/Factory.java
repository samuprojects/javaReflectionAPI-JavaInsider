package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@SuppressWarnings("ALL")
public class Factory {
    public static Animal newAnimal(String className) throws Exception {
        Class<?> theClass = Class.forName(className);
        var constructor = theClass.getConstructor();
        Animal animal = (Animal) constructor.newInstance(); // instancia primeiro

        //theClass.getMethods(); // traz os métodos existentes em determinada classe
        try {
            Method afterConstrutorMethod = theClass.getMethod("afterConstructor"); // busca o método informado
            afterConstrutorMethod.invoke(animal);
        } catch (NoSuchMethodException e) {
        }

        // a diferença entre getMethods e getDeclaredMethods é que o primeiro busca em toda a hierarquia considerando a herança e o segundo somente o da classe
        Arrays.stream(theClass.getDeclaredMethods())
                .forEach(m -> {
                    if (m.getAnnotation(OnCreated.class) != null) {
                        try {
                            m.setAccessible(true); // permite a Reflection API acessar elementos privados
                            m.invoke(animal);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

        return animal;
    }
}
