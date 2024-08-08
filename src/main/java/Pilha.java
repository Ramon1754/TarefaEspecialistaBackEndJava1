public class Pilha {

    public static final int CAPACIDADE_INICIAL = 10;
    public int[] elementos;
    public int topo;

    public Pilha() {
        elementos = new int[CAPACIDADE_INICIAL];
        topo = -1;
    }

    public void empurrar (int valor ) {
        if (topo == elementos.length - 1) {
            redimensionar();
        }
        elementos[++topo] = valor;
    }

    public int desempurrar () throws IllegalAccessException {
        if (estaVazia()) {
            throw new IllegalAccessException("Pilha vazia");
        }
        return elementos[topo--];
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public void redimensionar() {
        int novoTamanho = elementos.length * 2;
        int[] novoArray = new int[novoTamanho];
        System.arraycopy(elementos, 0, novoArray, 0, elementos.length);
        elementos = novoArray;
    }

    public int tamanho() {
        return topo + 1;
    }
}
