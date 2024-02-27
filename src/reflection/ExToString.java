package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.Modifier;
import java.util.Date;

/*
 * Escrever método para converter objeto em uma representação em String.
 * Além disso, exibir nome da classe, atributos e seus valores.
 * A busca das informações deve utilizar Reflection API
 *
 * */
public class ExToString {

    public static void main(String[] args) {
        System.out.println(toString(new Date()));
        System.out.println(toString((new Person(10, "Carlos"))));
    }

    private static String toString(Object obj) {
        Class<?> theClass= obj.getClass();

        StringBuilder sb = new StringBuilder();
        String className = theClass.getSimpleName();
        sb.append("Class: ").append(className).append("\n");

            for (Field f : theClass.getDeclaredFields()) {
                if (!Modifier.isStatic(f.getModifiers())) { // não traz os métodos estáticos
                    String name = f.getName();
                    try {
                        f.setAccessible(true);
                        sb.append("\t").append(name).append(": ").append(f.get(obj)).append("\n");
                    } catch (InaccessibleObjectException | IllegalAccessException e) {
                        sb.append("\t").append(name).append(": <undefined>\n"); // tabulação também quando não encontra
                    }
                }
            }

        return sb.toString();
    }
}
