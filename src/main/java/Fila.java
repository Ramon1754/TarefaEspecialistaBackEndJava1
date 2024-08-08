public class Fila {
    private static final int CAPACIDADE_INICIAL = 10;
    private int[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fila() {
        elementos = new int[CAPACIDADE_INICIAL];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public void enfileirar(int valor) {
        if (tamanho == elementos.length) {
            redimensionar();
        }
        elementos[fim] = valor;
        fim = (fim + 1) % elementos.length;
        tamanho++;
    }

    public int desenfileirar() {
        if (estaVazia()) {
             throw new IllegalStateException("Fila vazia");
        }
        int valor = elementos[inicio];

        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return valor;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    private void redimensionar() {
        int novoTamanho = elementos.length * 2;
        int[] novoArrray = new int[novoTamanho];
        for (int i = 0; i < elementos.length; i++) {
            novoArrray[i] = elementos[(inicio + i) % elementos.length];
        }
        elementos = novoArrray;
        inicio = 0;
        fim = tamanho;
    }

    public int tamanho() {
        return tamanho;
    }


}
