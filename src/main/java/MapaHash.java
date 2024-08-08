public class MapaHash {
    private static final int TAMANHO = 10;
    private Nodo[] tabela;

    private class Nodo {

        int chave;
        int valor;
        Nodo proximo;

        Nodo(int chave, int valor) {
            this.chave = chave;
            this.valor = valor;
            this.proximo = null;
        }
    }

    public MapaHash() {
        tabela = new Nodo[TAMANHO];
    }

    private int hash(int chave) {

        return chave % TAMANHO;
    }

    public void colocar(int chave, int valor) {

        int indice = hash(chave);
        Nodo novoNodo = new Nodo(chave, valor);
        if (tabela[indice] == null) {
            tabela[indice] = novoNodo;
        } else {
            Nodo atual = tabela[indice];
            while (atual.proximo != null) {
                if (atual.chave == chave) {
                    atual.valor = valor;
                    return;
                }
                atual = atual.proximo;
            }
            if (atual.chave == chave) {
                atual.valor = valor;
            } else {
                atual.proximo = novoNodo;
            }
        }
    }

    public int obter(int chave) {

        int indice = hash(chave);
        Nodo atual = tabela[indice];
        while (atual != null) {
            if (atual.chave == chave) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        throw new IllegalArgumentException("Chave não encontrada");
    }

}
