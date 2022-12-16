import java.util.ArrayList;
import java.util.Scanner;

public class PruferArbol {
    public static void main(String[] args) {
        // Crea una secuencia de Prüfer
        int[] secuencia = {2, 3, 3, 2, 2};

        // Convierte la secuencia en un árbol
        Arbol arbol = secuenciaPrufer(secuencia);

        // Imprime el árbol
        imprimirArbol(arbol);
    }

    // Método que crea el árbol a partir de una secuencia de Prüfer
    private static Arbol secuenciaPrufer(int[] secuencia) {
        Arbol a = new Arbol();
        ArrayList<Nodo> nodos = a.getListaNodos();
        ArrayList<Arista> aristas= a.getListaAristas();
        // Inicializa la lista de nodos del árbol con todos los nodos de la secuencia de Prüfer
        for (int valor : secuencia) {
            nodos.add(new Nodo(valor));
        }
        a.setListaNodos(nodos);
        // Mientras queden nodos en la lista, sigue los siguientes pasos
        while (!nodos.isEmpty()) {
            // Toma el primer nodo de la lista. Este será el nodo raíz del árbol.
            Nodo nodoRaiz = nodos.get(0);
            // Busca el nodo con menor valor que aún no se haya agregado al árbol y que no se encuentre en la lista de nodos.
            // Este será el nodo hijo del nodo raíz.
            Nodo nodoHijo = null;
            int minValue = Integer.MAX_VALUE;
            for (Nodo nodo : nodos) {
                if (nodo.getValor() < minValue && !nodo.isAgregado()) {
                    minValue = nodo.getValor();
                    nodoHijo = nodo;
                }
            }
            // Crea una arista entre el nodo raíz y el nodo hijo.
            aristas.add(new Arista(nodoRaiz, nodoHijo));
            // Elimina el nodo hijo de la lista de nodos.
            nodos.remove(nodoHijo);
        }
        a.setListaAristas(aristas);
        // Devuelve el árbol completo
        return a;
    }

    private static void imprimirArbol(Arbol a){
        ArrayList<Arista> aristas = a.getListaAristas();
        ArrayList<Nodo> nodos = a.getListaNodos();
        for (Nodo v : nodos) {
            System.out.print(v.getValor() + ": ");
            for (Arista e : aristas) {
                if (e.getDestino().equals(v)) {
                    System.out.print(e.getDestino().getValor() + " ");
                }
            }
            System.out.println();
        }
    }

}
