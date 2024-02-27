package reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ExGetters3 { // opção genérica com outra classe.

    public static void main(String[] args) {

        Object obj = new Person(); // Foi criado métodos get na classe Person para demonstrar a busca dos métodos

        var theClass = obj.getClass();
        Arrays
                .stream(theClass.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .filter(m -> m.getParameterCount() == 0)
                .forEach(m -> {
                    m.setAccessible(true);
                    try {
                        System.out.println(m.getName() + " => " + m.invoke(obj));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
