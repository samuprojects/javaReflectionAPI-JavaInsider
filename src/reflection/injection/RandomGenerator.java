package reflection.injection;

/*
* Classe criada para exemplificar que a estrutura de injeção está funcionando para qualquer classe.
*
* */

import java.util.Random;

@SuppressWarnings("ALL")
public class RandomGenerator {

    private Random random = new Random();

    @Inject
    private int min;

    @Inject
    private int max;

    public int next() {
        return random.nextInt(min, max + 1); // +1 porque a característica do método nextInt é até o numero sem contabiliza-lo, passa a ser considerado
    }
}
