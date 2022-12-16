
/**
 * Extension de la clase 
 */
public class Arista {
    Nodo inicio;
    Nodo destino ; 
    public Arista(Nodo nodoRaiz, Nodo nodoHijo){
        this.inicio = nodoRaiz;
        this.destino= nodoHijo;
    }
    public Nodo getInicio(){
    return this.inicio;
    }
    public Nodo getDestino(){
    return this.destino;
    }
    public void setInicio(Nodo a){
    inicio = a;
    }
    public void setDestino(Nodo b){
    destino = b;
    }
}