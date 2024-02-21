package reflection;

public class App4 {

    public static void main(String[] args) throws Exception {
        Animal animal = Factory.newAnimal("reflection." + args[0]);
        animal.speak();

        // Nessa outra opção, podemos usar o terminal de linha de comando para instanciar os objetos e pode ler de qualquer lugar
        // professor utilizou no terminal os exemplos na saída do projeto (em terminal)
        // java reflection.App4 Cat
        // java reflection.App4 Dog
        // java reflection.App4 Sheep
    }
}
