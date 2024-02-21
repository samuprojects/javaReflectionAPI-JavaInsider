package reflection;

import java.lang.reflect.Method;

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
            e.printStackTrace();
        }
        return animal; // já coloca no retorno
    }
}
