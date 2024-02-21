package reflection;

/*
* Criação de método capaz de instanciar qualquer tipo de Animal
* Encapsular isso no conceito conhecido como Factory (que é um padrão de projeto,
* um design pattern muito conhecido com objetivo de ser uma fonte para criação de objetos).
*
* */
public class App3 {

    public static void main(String[] args) throws Exception {

        Animal cat = Factory.newAnimal("reflection.Cat");
        cat.speak();

        Animal dog = Factory.newAnimal("reflection.Dog");
        dog.speak();

        Animal sheep = Factory.newAnimal("reflection.Sheep");
        sheep.speak();
    }
}
