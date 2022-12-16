public class Nodo{
    int peso ;
    boolean agregado;
    public Nodo(int valor){
        this.peso = valor ;
        this.agregado = false;
    }
    
    public int getValor(){
    return peso;
    }
    
    public boolean isAgregado(){
    return agregado;
    }
    
    public void setIsAgregado(boolean va){
    this.agregado = va;
    }
}