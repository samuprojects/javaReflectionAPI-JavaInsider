package reflection.injection;

/*
* Classe que será utilizada como exemplo para injeção de dependências
* */

@SuppressWarnings("ALL")
public class Circle {

    private double radius;

    private double pi;

    public Circle() {
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculateSurface() {
        return pi * radius * radius;
    }
}
