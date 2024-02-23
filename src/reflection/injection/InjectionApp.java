package reflection.injection;

/*
* Utilizar a Reflection API para injeção de dependências
* Consiste em incluir valores de atributos automaticamente dentro do objeto sem ter que gerenciar esses atributos
* */

public class InjectionApp {

    public static void main(String[] args) {

        Circle circle = Factory.create(Circle.class);
        circle.setRadius(10);
        System.out.println(circle.calculateSurface());
    }
}
