/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

package EJERCICIO3;

public class Nodo<T> {
    
    //definimos la clase nodo de tipo generico
    //con nodos a la izquierda y a la derecha
    T dato = null;
    Nodo<T> izq = null;
    Nodo<T> der = null;

    public Nodo(T dato) {
        this.dato = dato;
    }

}
