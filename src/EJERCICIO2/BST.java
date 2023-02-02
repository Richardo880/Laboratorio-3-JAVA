/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

package EJERCICIO2;

public class BST{
    /*
     Un ejemplo de uso sencillo de uso de la clase BST
     */
    
    
    public static void main(String[] args) {
        
        //creamos el arbol base y lo imprimimos, en este caso de tipo entero
        Arbol<Integer> a = new Arbol<>();
        
        Integer[] A = {10, 15, 7, 8, 6, 2, 11, 12};
        for (Integer A1 : A) {
            a.agregar(A1);
        }
        
        
        System.out.println("Arbol de tipo Int");
        a.imprimir_recursivo(a.returnraiz(), ""); 
        a.imprimir();
        
        //obtenemos el k-esimo elemento mas pequenho, en caso de que exceda el tamanho de nodos
        //se imprime un mensaje de error
        
        a.elempequenho(3);
        a.elempequenho(1);
         a.elempequenho(4);
        a.elempequenho(2);
        a.elempequenho(8);
        a.elempequenho(9);
        
        
        //creamos un arbol con nodos de tipo string, y lo imprimimos
        Arbol<String> a2 = new Arbol<>();
        
        String[] cadenas = {"Goku","Vegeta","Freezer","Trunks"};
        for (String A1 : cadenas) {
            a2.agregar(A1);
        }
        
        System.out.println("Arbol de tipo String");
        a2.imprimir_recursivo(a2.returnraiz(), "");
        
        a2.imprimir();
        
        //obtenemos el k-esimo elemento mas pequenho, en caso de que exceda el tamanho de nodos
        //se imprime un mensaje de error
        a2.elempequenho(3);
        a2.elempequenho(1);
         a2.elempequenho(4);
        a2.elempequenho(2);
        a2.elempequenho(8);
        a2.elempequenho(9);
        
        
                
        //creamos un arbol con nodos de tipo float, y lo imprimimos
        Arbol<Float> a3 = new Arbol<>();
        
        Float[] flo = {10.5f,2.6f,3.5f,6.4f,12.5f,0.5f};        
        
        for (Float A1 : flo) {
            a3.agregar(A1);
        }
        
        System.out.println("Arbol de tipo Float");
        a3.imprimir_recursivo(a3.returnraiz(), "");
        
        a3.imprimir();
        
        //obtenemos el k-esimo elemento mas pequenho, en caso de que exceda el tamanho de nodos
        //se imprime un mensaje de error
        a3.elempequenho(3);
        a3.elempequenho(1);
        a3.elempequenho(4);
        a3.elempequenho(2);
        a3.elempequenho(8);
        a3.elempequenho(9);
        
       
    }
}