package reflection;
/*
* Programa para encontrar métodos getters de um objeto, chamando-os e exibindo os valores de retorno na tela
* professor criou alguns critérios para restringir o cenário proposto pelo exercício
*
*
* */


import java.lang.reflect.InvocationTargetException;
import java.time.LocalTime;
import java.util.Arrays;

public class ExGetters {

    public static void main(String[] args) {

        LocalTime time = LocalTime.now();
        System.out.println(time);

        var theClass = time.getClass(); // 1) acessando a classe via Reflection API

        Arrays // 2) Utilizando stream API
                .stream(theClass.getDeclaredMethods()) // 3) acessando os métodos que fazem parte dessa classe
                .filter(m -> m.getName().startsWith("get")) // 4) filtrando métodos que começam com get
                .filter(m -> m.getParameterCount() == 0) // 5) filtrando para retornar apenas os métodos sem parâmetros (0 é a quantidade de parâmetros)
                .forEach(m -> { // 6) com a lista gerada pelo filter podemos processar cada um dos métodos
                    m.setAccessible(true); // 7) liberando acesso a métodos privados
                    try { // 10) tratando a exceção
                        var obj = m.invoke(time); // 8) invocando método passando o objeto que vai retornar um Object
                        System.out.println(m.getName() + " => " + obj); // 9) formulando a resposta do exercício
                    } catch (IllegalAccessException | InvocationTargetException e) { // 11) agrupando as exceções
                        throw new RuntimeException(e);
                    }
                });
    }
}
