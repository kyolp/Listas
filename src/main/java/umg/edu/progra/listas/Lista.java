package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    public Lista() {
        primero = null;
    }

    public Nodo leerPrimero() {
        return primero;
    }

    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
    }

    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
    }

    public void eliminar(int entrada) {
        Nodo actual, anterior;
        actual = primero;
        anterior = null;

        while ((actual != null) && (actual.dato != entrada)) {
            anterior = actual;
            actual = actual.enlace;
        }

        if (actual != null) {
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    public void visualizar() {
        Nodo n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
        System.out.println();
    }

    // Método 1: Invertir la lista enlazada
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = primero;
        Nodo siguiente;

        while (actual != null) {
            siguiente = actual.enlace;
            actual.enlace = anterior;
            anterior = actual;
            actual = siguiente;
        }

        primero = anterior;
    }

    // Método 2: Obtener el elemento en la posición n desde el final
    public Integer obtenerDesdeElFinal(int n) {
        Nodo primeroPtr = primero;
        Nodo segundoPtr = primero;

        for (int i = 0; i < n; i++) {
            if (segundoPtr == null) return null;
            segundoPtr = segundoPtr.enlace;
        }

        while (segundoPtr != null && segundoPtr.enlace != null) {
            primeroPtr = primeroPtr.enlace;
            segundoPtr = segundoPtr.enlace;
        }

        return (primeroPtr != null) ? primeroPtr.dato : null;
    }

    // Método 3: Eliminar duplicados
    public void eliminarDuplicados() {
        Nodo actual = primero;

        while (actual != null) {
            Nodo correr = actual;
            while (correr.enlace != null) {
                if (correr.enlace.dato == actual.dato) {
                    correr.enlace = correr.enlace.enlace;
                } else {
                    correr = correr.enlace;
                }
            }
            actual = actual.enlace;
        }
    }

    // Método 4: Obtener el tamaño de la lista
    public int obtenerTamaño() {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.enlace;
        }
        return contador;
    }
    
    // Ordenar lista de forma ascendente (simple sort por selección)
    public void ordenarAscendente() {
    for (Nodo i = primero; i != null; i = i.enlace) {
        for (Nodo j = i.enlace; j != null; j = j.enlace) {
            if (i.dato > j.dato) {
                int temp = i.dato;
                i.dato = j.dato;
                j.dato = temp;
            }
        }
    }
}

// Unir esta lista con otra lista
    public Lista unirCon(Lista otra) {
    Lista nueva = new Lista();
    Nodo actual = this.primero;

    while (actual != null) {
        nueva.insertarCabezaLista(actual.dato);
        actual = actual.enlace;
    }

    actual = otra.primero;
    while (actual != null) {
        nueva.insertarCabezaLista(actual.dato);
        actual = actual.enlace;
    }

    nueva.invertir(); // para conservar el orden
    return nueva;
}

// Separar en listas de pares e impares
    public void separarParesImpares(Lista pares, Lista impares) {
    Nodo actual = this.primero;
    while (actual != null) {
        if (actual.dato % 2 == 0) {
            pares.insertarCabezaLista(actual.dato);
        } else {
            impares.insertarCabezaLista(actual.dato);
        }
        actual = actual.enlace;
    }

    pares.invertir();   // Para mantener orden original
    impares.invertir();
}

}
