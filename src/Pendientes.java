import java.util.*;

public class Pendientes {
    private static Queue<String> cola = new LinkedList<>();
    private static List<Listener> listeners = new ArrayList<>();

    public interface Listener {
        void onNuevoPendiente(String pendiente);
    }

    public static void agregarPendiente(String pendiente) {
        cola.offer(pendiente);
        notificarNuevoPendiente(pendiente);
    }

    public static String removerPendiente() {
        return cola.poll(); // Elimina el primero
    }

    public static List<String> getCola() {
        return new ArrayList<>(cola);
    }

    public static void agregarListener(Listener l) {
        listeners.add(l);
    }

    private static void notificarNuevoPendiente(String pendiente) {
        for (Listener l : listeners) {
            l.onNuevoPendiente(pendiente);
        }
    }
}