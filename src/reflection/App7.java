package reflection;

/*
* Utilizar a Reflection API para listar os atributos de uma determinada Classe
* exibindo o atributo, o tipo dele e se é público ou não
*
* */

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class App7 {
    public static void main(String[] args) throws IllegalAccessException {
        Person p = new Person(1, "Maria");

        //var theClass = Person.class;

        var theClass = p.getClass();

        for (Field f : theClass.getDeclaredFields()) {
            f.setAccessible(true); // acessar atributo privado
            System.out.println("Nome: " + f.getName());
            System.out.println("Tipo: " + f.getType().getName());
            System.out.println("Público? " + Modifier.isPublic(f.getModifiers()));
            System.out.println("Valor: " + f.get(p)); // para obter o valor do campo específico no objeto
            /* O método getModifiers() retorna um número inteiro
            * Utilizando a classe Modifier é possível codificar esse número acima
            * por meio de vários métodos estáticos disponíveis nessa classe.
            * Esses métodos retornam um boolean, exemplo, isPublic passando como parâmetro o
            * getModifiers(). Também é possível utilizar vários outros dependendo do cenário como:
            * is Abstract, isFinal, isInterface, isNative, isPrivate, isProtected, isStatic, isStrict,
            * isSynchronized, isTransient, isVolatile, ou seja, todos os modificadores do Java.
            * Apesar do cenário de uso nesse momento ser em campos (Fields), podemos utilizar em
            * Construtores, Métodos, Classes, entre outros.*/
            System.out.println();
        }
    }
}
