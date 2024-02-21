package reflection;

/*
* Usando a mesma lógica do exemplo anterior, chamando um método automaticamente, se for declarado,
* e ao invés de depender de um nome específico de um método, vamos chamar métodos que possuem
* essa annotation de exemplo
*
* */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnCreated {
}
