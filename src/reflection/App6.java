package reflection;

/*
* Utilizando Reflection API para trabalhar com atributos privados
* */

import java.util.Arrays;

public class App6 {

    public static void main(String[] args) {

        Person person = new Person(); // possui atributos privados não é possível passar valores

        var theClass = person.getClass(); // acessando o objeto Class da estrutura da classe retorna um objeto que podemos utilizar

        Arrays // utilizado a StreamAPI para trabalhar com o Array retorno do getDeclaredFields()
                .stream(theClass.getDeclaredFields()) // getDeclaredFields() permite saber quais são os atributos
                .forEach(f -> { // sabendo o nome deles vamos iterar e atribuir valores
                    try{ // try/catch para tratar a exceção dos métodos set
                        f.setAccessible(true); // sem esse contorno à regra dará erro na execução por serem os atributos privados
                        if (f.getName().equals("id")) { // descoberto via Reflection API com o getDeclaredFields()
                            f.set(person, 10); // passando o objeto e atribuindo um valor
                        } else if (f.getName().equals("name")) { // descoberto via Reflection API com o getDeclaredFields()
                            f.set(person, "Pedro"); // passando o objeto e atribuindo um valor
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println(person);
    }
}
