package reflection;

public class App2 {

    public static void main(String[] args) throws Exception {

        // instanciação habitual
        Animal a1 = new Cat();
        a1.speak();

        // instanciação por reflexão (espécie de instanciação indireta utilizando Reflection API)
        var c = Cat.class; // representa classe Cat
        var constructor = c.getConstructor(); // construtor que não recebe parâmetros com objeto que representa esse construtor
        Cat cat = constructor.newInstance(); // com base no construtor criado uma instância de Cat
        cat.speak();
    }
}
