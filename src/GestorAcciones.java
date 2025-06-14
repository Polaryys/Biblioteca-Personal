import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

// Clase global para manejar la pila de acciones
public class GestorAcciones {

    private static Stack<String> pila = new Stack<>();
    private static List<Listener> listeners = new ArrayList<>();

    // Interfaz para notificar cambios
    public interface Listener {
        void onNuevaAccion(String texto);
    }

    // Método para agregar listener
    public static void agregarListener(Listener listener) {
        listeners.add(listener);
    }

    public static void push(String texto) {
        pila.push(texto);

        for (Listener l : listeners) {
            l.onNuevaAccion(texto);
        }
    }

    public static Stack<String> getPila() {
        return pila;
    }
}
