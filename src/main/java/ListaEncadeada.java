public class ListaEncadeada {
    private Nodo cabeca;
    private int tamanho;

    private class Nodo {
        int valor;
        Nodo proximo;

        Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;

        }
    }

    public ListaEncadeada() {
        cabeca = null;
        tamanho = 0;
    }

    public void adiciona(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (cabeca == null) {
            cabeca = novoNodo;
        } else {
            Nodo atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNodo;
        }
        tamanho++;
    }

    public int remover(int valor) {
        Nodo atual = cabeca;
        Nodo anterior = null;
        while (atual != null) {
            if (atual.valor == valor) {
                if (anterior == null) {
                    cabeca = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                tamanho -- ;
                return valor;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        throw new IllegalArgumentException("Valor não encontrado");
    }

    public boolean contem(int valor) {

        Nodo atual = cabeca;
        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public int tamanho() {
        return tamanho;
    }


}
