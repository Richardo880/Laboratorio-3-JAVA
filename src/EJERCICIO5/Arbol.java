/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

package EJERCICIO5;

import java.util.concurrent.atomic.AtomicInteger;//importamos el atomic integer

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
    
    
    //funcion que nos retorna la raiz del arbol
     public EJERCICIO5.Nodo<T> returnraiz(){
        return raiz;
    }
    
     
    //funcion para imprimir el arbol de forma mas linda por niveles de forma recursiva
    public void imprimir_recursivo(EJERCICIO5.Nodo nodo, String cadena){
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
    
    // Función para contar subárboles en el BST cuyos nodos se encuentran dentro de un rango dado.
     // Devuelve verdadero si todo el subárbol con raiz en el nodo dado está dentro del rango
    public static boolean SubArboles(Nodo n_actual, int a, int b, AtomicInteger count)
    {
        // caso base
        if (n_actual == null) {
            return true;//no hay ningun subarbol
        }
        
        //hijos derecho e izquierdo
        boolean izquierda = SubArboles(n_actual.izq, a, b, count);
        boolean derecha = SubArboles(n_actual.der, a, b, count);
 
        // incrementa el número de subárboles en 1 y devuelve verdadero si el nodo raíz,
         // los subárboles izquierdo y derecho están dentro del rango
        if (izquierda && derecha && ((Integer)n_actual.dato >= a && (Integer) n_actual.dato <= b))
        {
            count.incrementAndGet();//incrementamos en 1
            return true;
        }
 
        return false;//caso contrario retorna falso
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
