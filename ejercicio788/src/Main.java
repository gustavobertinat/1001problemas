public class Main {
    public static void main(String[] args) {
        ListaEnlazadaOrdenada<Integer> lista = new ListaEnlazadaOrdenada<>();

        lista.insertarOrdenado(5);
        lista.insertarOrdenado(2);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(3);
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(1);

        System.out.println("Lista ordenada:");
        lista.imprimirLista();
        System.out.println("Tamaño de la lista: " + lista.getTamaño());
    }
}

class ListaEnlazadaOrdenada<T extends Comparable<T>> {
    private Nodo cabeza;
    private int tamaño;

    private class Nodo {
        T dato;
        Nodo siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public ListaEnlazadaOrdenada() {
        cabeza = null;
        tamaño = 0;
    }

    public void insertarOrdenado(T dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (cabeza == null || dato.compareTo(cabeza.dato) < 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null && dato.compareTo(actual.siguiente.dato) >= 0) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}