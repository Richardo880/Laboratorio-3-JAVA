/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
 */
package EJERCICIO3;

public class BST {

    /*
     Un ejemplo de uso sencillo de uso de la clase BST
     */
    public static void main(String[] args) throws Exception {
        //creamos el arbol base y lo imprimimos
        Arbol<Integer> a = new Arbol<>();

        Integer[] A = {10, 15, 7, 8, 6, 2, 11, 12};
        for (Integer A1 : A) {
            a.agregar(A1);
        }

        System.out.println("\nEl arbol 1 original es: \n");
        a.imprimir_recursivo(a.returnraiz(), "");
        System.out.print("\nNodos ordenados: ");
        a.imprimir();

        //creamos 3 nuevos arboles, pasandoles como parametro los elementos
        //apartir de los cuales va a sumar los vertices
        //la raiz en todos los casos se mantiene constante
        Arbol<Integer> b = new Arbol<>();
        //aqui llamamos a la funcion que nos retorna el arbol nuevo, ya con los vertices sumados e imprimimos 3 casos.
        b = a.acc_greater(a);
        System.out.println("\nEl nuevo arbol 1 es: \n");
        b.imprimir_recursivo(b.returnraiz(), "");
        System.out.print("\nNodos ordenados: ");
        b.imprimir();
        
        
        
        //EJEMPLO NUMERO 2
        Arbol<Integer> arbol = new Arbol<>();

        Integer[] A2 = {10,5,50,1,40,100};
        for (Integer A1 : A2) {
            arbol.agregar(A1);
        }
        
        System.out.println("\nEl arbol 2 original es: \n");
        arbol.imprimir_recursivo(arbol.returnraiz(), "");
        System.out.print("\nNodos ordenados: ");
        arbol.imprimir();
        
        
        Arbol<Integer> c = new Arbol<>();

        c = arbol.acc_greater(arbol);
        System.out.println("\nEl nuevo arbol 2 es: \n");
        c.imprimir_recursivo(c.returnraiz(), "");
        System.out.print("\nNodos ordenados: ");
        c.imprimir();
        
        
        //EJEMPLO NUMERO 3
        Arbol<Integer> arbol2 = new Arbol<>();

        Integer[] A3 = {10, 15, 7, 8, 6, 2, 11, 12};
        for (Integer A1 : A3) {
            arbol2.agregar(A1);
        }
        
        System.out.println("\nEl arbol 3 original es: \n");
        arbol2.imprimir_recursivo(arbol2.returnraiz(), "");
        System.out.print("\nNodos ordenados: ");
        arbol2.imprimir();
        
        
        
        Arbol<Integer> d = new Arbol<>();

        d = a.acc_greater(a);
        System.out.println("\nEl nuevo arbol 3 es: \n");
        d.imprimir_recursivo(d.returnraiz(), "");
        System.out.print("\nNodos ordenados: ");
        d.imprimir();
    }
}
