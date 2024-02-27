package reflection.injection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
* Classe genérica que será utilizada para instanciar objetos
* A utilização de Generics foi escolhida para eliminar a necessidade de casting
*
* */

@SuppressWarnings("ALL")
public class Factory {

    public static <T> T create(Class<T> theClass) {
        try {
            T instance = theClass.getConstructor().newInstance();

            for (Field f : theClass.getDeclaredFields()) { // iterando sobre os atributos que fazem parte do objeto a ser trabalhado
                if (!Modifier.isStatic(f.getModifiers())) { // negando a injeção de atributos estáticos
                    f.setAccessible(true); // liberando acesso a atributos privados
                    if (f.getAnnotation(Inject.class) != null) { // verificação de annotation no campo
                        Method injectorMethod = Objects.class.getMethod(f.getName()); // Obtendo do objeto o método que possui o mesmo nome do campo
                        Object valueToInject = injectorMethod.invoke(null); // obtendo o valor do método
                        f.set(instance, valueToInject);
                    }
                }
            }

            return instance; // retornando a instância após checagem da injeção de dependência
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
