package reflection;

@SuppressWarnings("ALL")
public class Factory {

    /*
    * Com a reflection API pode ir além e até construir coisas que ainda não existem
    * */

    // ao invés de receber uma classe que representa um Animal vamos receber o nome da classe como String
    public static Animal newAnimal(String className) throws Exception {
        Class<?> theClass = Class.forName(className); // com base no nome da classe vamos transformar num objeto class
        // o Class.forName é um método estático da classe Class que pega o nome de uma classe como String e tenta encontrar
        // dentro do ClassLoader (componente JVM responsável por carregar as classes para memória) essa classe durante a execução,
        // ou seja, ela não precisa existir no processo de compilação.
        // Isso retorna um objeto Class de qualquer coisa
        var constructor = theClass.getConstructor();
        return (Animal) constructor.newInstance();
    }


//    public static Animal newAnimal(Class<? extends Animal> theClass) throws Exception {
//        var constructor = theClass.getConstructor();
//        Animal animal = constructor.newInstance();
//        return animal;
//    }
}
