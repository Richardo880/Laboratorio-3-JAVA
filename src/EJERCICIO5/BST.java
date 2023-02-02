/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

package EJERCICIO5;

import static EJERCICIO5.Arbol.SubArboles;//iimportamos el metodo estatico SubArbolesde nuestro BST
import java.util.concurrent.atomic.AtomicInteger;//importamos la libreria del AtomicInteger



public class BST{
    /*
     Un ejemplo de uso sencillo de uso de la clase BST
     */
    public static void main(String[] args) {
        //generamos el arbol y luego lo imprimimos
        Arbol<Integer> a = new Arbol<>();
        
        Integer[] A = {15, 10, 25, 8, 12, 6, 9, 20,30,18,22};
        for (Integer A1 : A) {
            a.agregar(A1);
        }
        
        System.out.print("Elementos del arbol 1");
        a.imprimir();
        a.imprimir_recursivo(a.returnraiz(), "");
        
        //Usamos AtomicInteger ya que Integer se pasa por valor en Java
        //fuente: https://stackoverflow.com/questions/4818699/practical-uses-for-atomicinteger
        
        AtomicInteger contador = new AtomicInteger(0);
 
        // Obtentemos el numero de subarboles y lo imprimimos
        SubArboles(a.returnraiz(), 5, 20, contador);
        System.out.println("El numero total de subarboles del arbol 1 de 5 a 20 es de: " + contador);
        
        
        
        //generamos el arbol 2 y luego lo imprimimos
        Arbol<Integer> b = new Arbol<>();
        
        Integer[] B = {10,5,50,1,40,100};
        for (Integer B1 : B) {
            b.agregar(B1);
        }

        System.out.print("\nElementos del arbol 2");
        b.imprimir();
        b.imprimir_recursivo(b.returnraiz(), "");
        
        //Usamos AtomicInteger ya que Integer se pasa por valor en Java
        AtomicInteger contador2 = new AtomicInteger(0);
 
        // Obtentemos el numero de subarboles y lo imprimimos
        SubArboles(b.returnraiz(), 1, 45, contador2);
        System.out.println("El numero total de subarboles del arbol 2 de 1 a 45 es de: " + contador2);
        
        
        
        
        //generamos el arbol 3 y luego lo imprimimos
        Arbol<Integer> c = new Arbol<>();
        
        Integer[] C = {10, 15, 7, 8, 6, 2, 11, 12};
        for (Integer C1 : C) {
            c.agregar(C1);
        }
        
        System.out.print("\nElementos del arbol 3");
        c.imprimir();
        c.imprimir_recursivo(c.returnraiz(), "");
        
        //Usamos AtomicInteger ya que Integer se pasa por valor en Java
        AtomicInteger contador3 = new AtomicInteger(0);
 
        // Obtentemos el numero de subarboles y lo imprimimos
        SubArboles(c.returnraiz(), 1, 11, contador3);
        System.out.println("El numero total de subarboles del arbol 3 de 1 a 11 es de: " + contador3);
    }
}