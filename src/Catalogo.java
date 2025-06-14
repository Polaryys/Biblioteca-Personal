import java.util.*;

public class Catalogo {
    private static Nodo cabeza = null;

    public static class Nodo {
        String libro;
        Nodo siguiente;

        public Nodo(String libro) {
            this.libro = libro;
            this.siguiente = null;
        }
    }

    public static void agregarLibro(String libro) {
        Nodo nuevo = new Nodo(libro);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public static boolean eliminarLibro(String libro) {
        if (cabeza == null) return false;

        if (cabeza.libro.equals(libro)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.libro.equals(libro)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }

        return false;
    }

    // Obtener todos los libros
    public static List<String> obtenerLibros() {
        List<String> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.libro);
            actual = actual.siguiente;
        }
        return lista;
    }

    // Buscar si existe un libro
    public static boolean contieneLibro(String libro) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.libro.equalsIgnoreCase(libro)) return true;
            actual = actual.siguiente;
        }
        return false;
    }
}