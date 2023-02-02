/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

package EJERCICIO3;

import java.util.ArrayList;

public class Arbol<T extends Comparable> {

    private EJERCICIO3.Nodo<T> raiz = null;


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
    
    
    //funcion para contar la cantidad de nodos dentro del arbol
    public int cantelementos(EJERCICIO3.Nodo nodo){
       if(nodo == null){
            return 0;
        }
        return 1 + cantelementos(nodo.izq) + cantelementos(nodo.der);
    }
    
    //funcion que nos retorna la raiz del arbol
     public EJERCICIO3.Nodo<T> returnraiz(){
        return raiz;
    }
    
     
    //funcion para imprimir el arbol de forma mas linda por niveles de forma recursiva
    public void imprimir_recursivo(EJERCICIO3.Nodo nodo, String cadena){
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
    
    //funcion que nos retorna la posicion del nodo en el arraylist desde donde empezaremos a acumular
    
    private int returnposicion(int num){
        int posicion = -1;
        int i;
        for(i = 0;i<datos.size();i++){
            int aux = (Integer) datos.get(i);//comparamos el valor entero del dato del arraylist generico
            if( aux == num){
                posicion = i;
                return posicion;//retornamos su posicion
            }
        }
        return posicion;//retornamos por defecto -1 en caso de que no exista el dato pasado por parametro
    }
    
    
    //creamos 2 arraylist auxiliares genericos para guardar en el primero los datos del arbol original
    //y en el segundo los datos del nuevo arbol
    ArrayList<T> datos = new ArrayList<>();
    
    ArrayList<T> datos2 = new ArrayList<>();
    
    
    //la funcion que devuelve el arbol
    public Arbol acc_greater(Arbol arbol){
        
        datos.clear();
        datos2.clear();//limpiamos los arrays
        
        agregararraylist(raiz);//agregamos al primer array los nodos del arbol original
        datos2.add((T) raiz.dato);//agregamos el nodo raiz al segundo array
        int num = 0;
        int i,j;
        int posicion = returnposicion(0);//obtenemos la posicion del primer arraylist
        //donde se encuentra el elemento x pasado por parametro
        
       
        for(i = 0;i< datos.size();i++){//recorremos el primer arraylist
            num = 0;
            num = num + (Integer) datos.get(i);//seleccionamos el elemento en la posicion i
            
            //solo entrara en la condicion en caso de que el valor de la variable i sea igual o mayor a la obtenida
            //en la variable posicion y si el dato no es la raiz
            
            if(i >= posicion && (num != (Integer) raiz.dato)){
                for(j = i+1;j< datos.size();j++){//segundo for donde recorremos desde la siguiente posicion de i
                    //para ir sumando los valores
                    num = num +  (Integer) datos.get(j);
                }
                //agregamos al arraylist el resultado de la suma de las valores en las posiciones posteriores
                datos2.add((T) (Integer) num);
                num = 0;//ponemos en cero el contador
            }else{
                //aqui guardamos los datos menores al parametro pasado siempre y cuando no sean la raiz
                    if((num != (Integer) raiz.dato)){
                        datos2.add((T) (Integer) num);
                        num = 0;
                    }
                }
        }
        

       System.out.println();
       
       Arbol <Integer> newarbol = new Arbol();//creamos el arbol que vamos a retornar
       datos2.forEach((A1) -> {
           newarbol.agregar((Integer) A1);//agregamos los elementos del segundo arraylist a nuestro arbol
        });
       return newarbol;//retornamos el nuevo arbol ya con las claves sumadas
       
    }
    
    
    //funcion para agregar los nodos del arbol original al primer arraylist
     private void agregararraylist(EJERCICIO3.Nodo n_actual) {
        if (n_actual != null) {
            agregararraylist(n_actual.izq);
            datos.add((T) (Integer) n_actual.dato);//agregamos su valor entero
            agregararraylist(n_actual.der);
        }

        
    }
    
    
    
     //funciones del bst original
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
