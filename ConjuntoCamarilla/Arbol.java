import java.util.ArrayList;

/**
 * Write a description of class Arbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol
{
    // Lista de aristas del árbol
    private ArrayList<Arista> aristas;
    // Lista de nodos del árbol
    private ArrayList<Nodo> nodos;
    
    public Arbol(){
    this.aristas = new ArrayList<>();
    this.nodos = new ArrayList<>();
    }
    
    public ArrayList<Arista> getListaAristas(){
        return this.aristas;
    }
    
    public void setListaAristas(ArrayList<Arista> a){
        this.aristas = a;
    }
    public void setListaNodos(ArrayList<Nodo> b){
        this.nodos = b;
    }
    public ArrayList<Nodo> getListaNodos(){
        return this.nodos;
    }
    
    public void agregarNodo(Nodo n){
        nodos.add(n);
    }
    public void agregarArista(Arista a){
        aristas.add(a);
    }
}