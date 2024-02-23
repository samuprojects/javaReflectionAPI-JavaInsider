package reflection;

@SuppressWarnings("ALL")
public class Person {

    private int id;
    private String name;

    // criado para mostrar os atributos após alteração via Reflection API
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
