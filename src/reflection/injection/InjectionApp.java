package reflection.injection;

/*
* Utilizar a Reflection API para injeção de dependências
* Consiste em incluir valores de atributos automaticamente dentro do objeto sem ter que gerenciar esses atributos
*
* Professor explicou que esse é um mecanismo de injeção de dependência rudimentar, mas que possui a base do conceito
* que é, por exemplo, a utilização da Reflection API (citou sobre Spring que é bem mais poderoso e faz coisas mais complexas).
* */

public class InjectionApp {

    public static void main(String[] args) {

//        Circle circle = Factory.create(Circle.class);
//        circle.setRadius(10);
//        System.out.println(circle.calculateSurface());

        RandomGenerator gen = Factory.create(RandomGenerator.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(gen.next());
        }
    }
}
