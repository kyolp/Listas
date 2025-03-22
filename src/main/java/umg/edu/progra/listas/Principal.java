package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        // Lista original
        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);

        System.out.println("Lista original:");
        lista.visualizar();        

        System.out.println("\nOrdenando lista:");
        lista.ordenarAscendente();
        lista.visualizar();

        System.out.println("\nUnir dos listas:");
        Lista lista2 = new Lista();
        lista2.insertarCabezaLista(9);
        lista2.insertarCabezaLista(8);
        lista2.insertarCabezaLista(7);

        Lista listaUnida = lista.unirCon(lista2);
        listaUnida.visualizar();

        System.out.println("\nSeparar pares e impares:");
        Lista pares = new Lista();
        Lista impares = new Lista();

        listaUnida.separarParesImpares(pares, impares);

        System.out.print("Pares: ");
        pares.visualizar();

        System.out.print("Impares: ");
        impares.visualizar();
    }
}

        
        
        /**
		 * Resolver lo que se solicita a continuacion
         * Ejercicio 1: Ordernar la lista de forma ascendente
         * Ejercicio 2: Unir dos listas enlazadas
         * Ejercicio 3: Separa numeros pares e impares en dos listas enlazadas diferentes
         */
        

    


