package reflection;

/*
* Em caso de uma Classe com um método de determinado nome, pode ser chamado assim que o objeto da classe for criado
* E caso não tenha não chama nada. Isso é muito utilizado em alguns frameworks para inicializar um objeto automaticamente
* Depois que um construtor for chamado
*
* */

public class App5 {

    public static void main(String[] args) throws Exception {
        Animal animal = Factory.newAnimal("reflection.Dog");
        animal.speak();
    }
}
