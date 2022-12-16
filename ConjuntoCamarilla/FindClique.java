import java.util.ArrayList;
import java.util.List;

/**
 * Este programa crea un grafo de prueba con 9 Nodos y 9 aristas, 
 * y luego utiliza el método findClique() para encontrar un conjunto camarilla
 * en el grafo. Si se encuentra un conjunto camarilla, el programa devuelve el número
 * del nodo correspondiente en la consola. Si no se encuentra ningún conjunto camarilla,
 * el programa devuelve un mensaje indicando que no se encontró ningún conjunto camarilla en el grafo.
 **/

public class FindClique {
    public static void main(String[] args) {
        // Crea un grafo con 3 conjuntos camarilla de tamaño variable
        Arbol arbol = new Arbol();
        // Creamos 9 Nodos
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        Nodo nodo4 = new Nodo(4);
        Nodo nodo5 = new Nodo(5);
        Nodo nodo6 = new Nodo(6);
        Nodo nodo7 = new Nodo(7);
        Nodo nodo8 = new Nodo(8);
        Nodo nodo9 = new Nodo(9);
        //los agregamos al Arbol
        arbol.agregarNodo(nodo1);
        arbol.agregarNodo(nodo2);
        arbol.agregarNodo(nodo3);
        arbol.agregarNodo(nodo4);
        arbol.agregarNodo(nodo5);
        arbol.agregarNodo(nodo6);
        arbol.agregarNodo(nodo7);
        arbol.agregarNodo(nodo8);
        arbol.agregarNodo(nodo9);
        // Creamos las Aristas para que se forme 3 conjuntos camarilla
        arbol.agregarArista(new Arista(nodo1, nodo2));
        arbol.agregarArista(new Arista(nodo1, nodo3));
        arbol.agregarArista(new Arista(nodo1, nodo4));
        arbol.agregarArista(new Arista(nodo2, nodo5));
        arbol.agregarArista(new Arista(nodo2, nodo6));
        arbol.agregarArista(new Arista(nodo3, nodo7));
        arbol.agregarArista(new Arista(nodo3, nodo8));
        arbol.agregarArista(new Arista(nodo3, nodo4));
        arbol.agregarArista(new Arista(nodo4, nodo9));

        // Encuentra un conjunto camarilla en el grafo
        int clique = getMayorTamanioCamarilla(arbol.getListaNodos() , arbol.getListaAristas());
        if (clique >= 0) {
            System.out.println("El tamaño del conjunto camarilla mas grande es " + clique);
        } else {
            System.out.println("No se encontró ningún conjunto camarilla en el grafo");
        }
        
        System.out.println();
    }

    private static int getMayorTamanioCamarilla(List<Nodo> nodos, List<Arista> aristas) {
        // Se inicializa el tamaño máximo a 0
        int mayorTamanio = 0;
        // Se recorren todos los pares de vértices
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = i + 1; j < nodos.size(); j++) {
                // Se obtienen los vértices i y j
                Nodo v1 = nodos.get(i);
                Nodo v2 = nodos.get(j);
                // Se busca una arista que conecte a los vértices i y j
                Arista arista = null;
                for (Arista a : aristas) {
                    if ((a.getInicio().equals(v1) && a.getDestino().equals(v2)) ||
                    (a.getInicio().equals(v2) && a.getDestino().equals(v1))) {
                        arista = a;
                        break;
                    }
                }
                // Si se encontró una arista que conecte a los vértices i y j, se busca el tamaño máximo de la camarilla
                if (arista != null) {
                    int tamanioCamarilla = getTamanioCamarilla(v1, v2,nodos, aristas);
                    // Si el tamaño de la camarilla es mayor que el tamaño máximo actual, se actualiza el tamaño máximo
                    if (tamanioCamarilla > mayorTamanio) {
                        mayorTamanio = tamanioCamarilla;
                    }
                }
            }
        }
        return mayorTamanio;
    }

    private static int getTamanioCamarilla(Nodo v1, Nodo v2, List<Nodo> nodos, List<Arista> aristas) {
        // Se inicializa el tamaño de la camarilla a 2 (los vértices v1 y v2)
        int tamanioCamarilla = 2;
        // Se recorren todos los vértices
        for (Nodo v : nodos) {
            // Si el vértice v es distinto de v1 y v2 y está conectado con ambos
            if (!v.equals(v1) && !v.equals(v2) && isConnected(v, v1, aristas) && isConnected(v, v2, aristas)) {
                // Se aumenta el tamaño de la camarilla
                tamanioCamarilla++;
            }
        }
        return tamanioCamarilla;
    }

    private static boolean isConnected(Nodo v1, Nodo v2, List<Arista> aristas) {
        // Se recorren todas las aristas
        for (Arista a : aristas) {
            // Si se encuentra una arista que conecte a los vértices v1 y v2
            if ((a.getInicio().equals(v1) && a.getDestino().equals(v2)) ||
            (a.getInicio().equals(v2) && a.getDestino().equals(v1))) {
                // Los vértices están conectados
                return true;
            }
        }
        // Los vértices no están conectados
        return false;
    }
}
