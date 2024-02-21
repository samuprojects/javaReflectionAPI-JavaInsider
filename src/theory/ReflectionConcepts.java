package theory;

@SuppressWarnings("ALL")
public class ReflectionConcepts {

    /*
    *
    * API de Reflexão ou Introspecção
    * Basicamente é você fazer com que o objeto olhe para dentro dele mesmo
    * Conhecendo as próprias estruturas (métodos disponíveis, atributos, construtores, etc, al[ém de poder executar operações com base nesse conhecimento
    * Durante a execução.
    * A classe que representa, do objeto do ponto de vista de Reflexão, todos os objetos do Java é Class
    * Por exemplo se quiser trabalhar com a parte de reflexão da classe String, ao chamar String.class, onde .class é como se fosse um atributo
    * Que todas as classes do Java possuem, que vai te retornar um objeto do tipo Class.
    * Esse objeto do tipo Class é parametrizado por Generics por isso sempre recebe o tipo atribuido no retorno.
    * Quando você tem uma instância desse objeto class basicamente é a porta de entrada para trabalhar com reflexão dessa classe.
    * Se quiser retornar no nome da classe String chama o objeto com getName e se imprimir vai retornar o fully qualified name da classe (observar o código de App1)
    * A mesma coisa pra o nome do pacote ou somente o nome da classe sem o pacote. Pode ainda verificar métodos, inclusive os de Object.
    * Tudo isso em tempo de execução.
    *
    * Existem diversos usos para a Reflexão que serão abordados mais a frente.
    *
    * Outro ponto é que pode ser acessado de um objeto já instanciado chamando o getClass nele.
    * A diferença é que por uma questão interna deve-se atribuir à uma Class de alguma coisa (representado pelo interrogação ?)
    * que estende a classe do objeto (no exemplo a classe String)
    *
    * */
}
