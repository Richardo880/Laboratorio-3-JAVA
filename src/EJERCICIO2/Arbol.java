/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

package EJERCICIO2;
import java.util.ArrayList;

public class Arbol<T extends Comparable> {

    private Nodo<T> raiz = null;


    /* Agregar un dato al arbol */
    public void agregar(T dato) {
        raiz = priv_agregar(raiz, dato);
    }
    
    private Nodo<T> priv_agregar(Nodo<T> n_actual, T dato) {
        if (n_actual == null) {
            return (new Nodo<T>(dato));
        }

        int comparacion = dato.compareTo(n_actual.dato);

        if (comparacion < 0) {
            n_actual.izq = priv_agregar(n_actual.izq, dato);
        } else {
            n_actual.der = priv_agregar(n_actual.der, dato);
        }

        return n_actual;

    }
    
    

    /*
    * Retorna el "nodo" donde se encuentra el primer dato
    * que dice ser igual a parametro dado.
    * La comparacion se realiza via "compareTo()" de la interfaz Comparable.
     */
    public T buscar(T dato) throws Exception{
        Nodo<T> nodo = priv_buscar(raiz, dato);
        if (nodo != null) {
            return nodo.dato;
        } else {
            /* Reemplazar por manejo de excepcion!! */
            //System.out.println("No existe en el arbol!!! " + dato);
            //return null;
            
            throw new Exception(dato + " no existe en el arbol");
        }
    }
    
    private Nodo priv_buscar(Nodo n_actual, T dato) {
        if (n_actual == null) // dato no se encuentra en el arbol
        {
            return null;
        }

        int comparacion = dato.compareTo(n_actual.dato);

        if (comparacion == 0) // dato == n_actual.dato 
        {
            return n_actual;
        } else if (comparacion < 0) // dato < n_actual.dato, puede estar a la izquierda
        {
            return priv_buscar(n_actual.izq, dato);
        } else // dato > n_actual.dato, puede estar a la derecha
        {
            return priv_buscar(n_actual.der, dato);
        }

    }

    /*
    * Imprime el arbol en recorrido infijo o simetrico.
     */
    
    //funcion que nos retorna la raiz del arbol
     public Nodo<T> returnraiz(){
        return raiz;
    }
     
    //funcion para imprimir el arbol de forma mas linda por niveles de forma recursiva
    
    public void imprimir_recursivo(Nodo nodo, String cadena){
        System.out.println(nodo.dato);
        String cadena2;
        cadena2 = cadena;
        
        //para el hijo izquierdo
        if(nodo.izq!= null){
            if(nodo.der!=null){
            System.out.print(" "+cadena+"├"+" ─"+" ─"+" ─"+" ─");
            String simb = "│";
            String aux = "";
            aux = aux + simb;
            aux = aux + '\0';
            cadena2=cadena2+aux;
            cadena2 = cadena2+" ";
            imprimir_recursivo(nodo.izq, cadena2);
            
            
        }else{
            System.out.print(" "+cadena+"└"+" ─"+" ─"+" ─"+" ─");
            cadena2 = cadena2 + " ";
            imprimir_recursivo(nodo.izq, cadena2);
        }
     }
        //para el hijo derecho
        if(nodo.der!=null){
            String cadena3;
            cadena3 = cadena;
            System.out.print(" "+cadena+"└"+" ─"+" ─"+" ─"+" ─");
            cadena3 = cadena3 + " ";
            imprimir_recursivo(nodo.der, cadena3);
        }
    }
    
    public void imprimir() {
        System.out.println();
        priv_imprimir(raiz);
        System.out.println();
    }
    
   
    
    /* Imprime en in-orden */
    private void priv_imprimir(Nodo n_actual) {
        if (n_actual != null) {
            priv_imprimir(n_actual.izq);
            System.out.print(n_actual.dato + " ");
            priv_imprimir(n_actual.der);
        }
    }
    
    //funcion para contar la cantidad de nodos dentro del arbol
    public int cantelementos(Nodo nodo){
       if(nodo == null){
            return 0;
        }
        return 1 + cantelementos(nodo.izq) + cantelementos(nodo.der);
    }
    
    
    
    ArrayList<T> datos = new ArrayList<>(); //arraylist donde guardamos los elementos ordenados
     public void elempequenho(int k) {
        System.out.println();
        
        if(k> cantelementos(raiz)){//mensaje en el caso de que el numero introducido sea mayor al numero de elementos
            System.out.println("\nEl numero introducido es mayor a la cantidad de elementos del arbol");
            System.out.println("El arbol tiene "+cantelementos(raiz)+" elementos");
            System.out.println();
        }else{
            agregararraylist(raiz);//agregamos a nuestro arraylist los elementos de nuestro arbol en la funcion de abajo
            //de forma ordenada
            System.out.print("\nEl "+k+" dato mas pequenho es: "+datos.get(k-1));//imprimimos el k-esimo elemento mas pequenho
            datos.clear();//limpiamos el array para el siguiente caso de prueba.
        }
    }
      
    
    //funcion recursiva para recorrer el arbol binario e ir agregando al arraylist de forma recursiva
    private void agregararraylist(Nodo n_actual) {
        if (n_actual != null) {
            agregararraylist(n_actual.izq);//si hay nodo izquierdo
            
            
            //tenemos 3 condiciones para agregar dependiendo del tipo de dato
            //ya sea de tipo entero, string o flotante, a traves del casteo
            
            if(Integer.class.isInstance(n_actual.dato)){
                datos.add((T) (Integer) n_actual.dato);
            }
            
            if(String.class.isInstance(n_actual.dato)){
               datos.add((T) (String) n_actual.dato);
            }
            
            if(Float.class.isInstance(n_actual.dato)){
               datos.add((T) (Float) n_actual.dato);
            }
            
            agregararraylist(n_actual.der);//si hay nodo derecho
        }

        
    }
    
    
    
    
    
    /*funciones del bst*/
    public int lci() {
        return lci(raiz, 0);
    }

    private int lci(Nodo nodo, int nivel) {
        if (nodo == null) {
            return 0;
        } else {
            return nivel + lci(nodo.izq, nivel + 1) + lci(nodo.der, nivel + 1);
        }
    }
}
