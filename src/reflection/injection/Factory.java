package reflection.injection;

import java.lang.reflect.InvocationTargetException;

/*
* Classe genérica que será utilizada para instanciar objetos
* A utilização de Generics foi escolhida para eliminar a necessidade de casting
*
* */

@SuppressWarnings("ALL")
public class Factory {

    public static <T> T create(Class<T> theClass) {
        try {
            return theClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
