import javax.swing.*;
import java.awt.*;


public class EstructuraDatos extends JFrame implements GestorAcciones.Listener, Pendientes.Listener {

    private JList<String> areaAcciones;
    private DefaultListModel<String> modeloAcciones;
    private JTextArea areaPrestamos;

    public EstructuraDatos() {
        setTitle("Libros");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/Resources/Books.png"));
        setIconImage(icono.getImage());
        getContentPane().setBackground(new Color(245, 245, 245));

        inicializarComponentes();
        prestamospendientes();

        // Suscribirse a las acciones y pendientes globales
        GestorAcciones.agregarListener(this);
        Pendientes.agregarListener(this);


        for (int i = GestorAcciones.getPila().size() - 1; i >= 0; i--) {
            modeloAcciones.addElement(GestorAcciones.getPila().get(i));
        }

        
        for (String pendiente : Pendientes.getCola()) {
            areaPrestamos.append(pendiente + "\n");
        }
    }

    private void inicializarComponentes() {
        JLabel label1 = new JLabel("Últimas acciones");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 26));
        label1.setBounds(100, 80, 600, 40);

        modeloAcciones = new DefaultListModel<>();
        areaAcciones = new JList<>(modeloAcciones);
        areaAcciones.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        areaAcciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        areaAcciones.setFixedCellHeight(30);
        areaAcciones.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 1, true));
        areaAcciones.setBackground(Color.WHITE);
        areaAcciones.setForeground(new Color(50, 50, 50));

        JScrollPane scroll1 = new JScrollPane(areaAcciones);
        scroll1.setBounds(80, 130, 450, 200);

        JButton button1 = new JButton("Atrás");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button1.setBounds(20, 30, 100, 30);
        button1.setFocusPainted(false);
        button1.setBackground(new Color(153, 51, 0));
        button1.setForeground(Color.WHITE);
        button1.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        button1.addActionListener(e -> {
            Interfaz mainwindow = new Interfaz();
            mainwindow.setVisible(true);
            dispose();
        });

        add(button1);
        add(label1);
        add(scroll1);
    }

    private void prestamospendientes() {
        JLabel label1 = new JLabel("Préstamos pendientes");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 26));
        label1.setBounds(600, 80, 600, 40);

        areaPrestamos = crearTextAreaEstilo(580, 130, 450, 200);
        JScrollPane scroll2 = new JScrollPane(areaPrestamos);
        scroll2.setBounds(580, 130, 450, 200);

        JButton entregarBtn = new JButton("Recibir prestamo más antiguo");
        entregarBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        entregarBtn.setBounds(580, 350, 300, 35);
        entregarBtn.setFocusPainted(false);
        entregarBtn.setBackground(new Color(0, 102, 153));
        entregarBtn.setForeground(Color.WHITE);
        entregarBtn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        entregarBtn.addActionListener(e -> {
            String entregado = Pendientes.removerPendiente();
            if (entregado != null) {
                areaPrestamos.setText(""); // Limpiar todo
                for (String pendiente : Pendientes.getCola()) {
                    areaPrestamos.append(pendiente + "\n");
                }
                GestorAcciones.push("Se Proceso: " + entregado);
            } else {
                JOptionPane.showMessageDialog(this, "No hay préstamos pendientes.");
            }
        });

        add(label1);
        add(scroll2);
        add(entregarBtn);
    }

    private JTextArea crearTextAreaEstilo(int x, int y, int width, int height) {
        JTextArea area = new JTextArea();
        area.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 1, true));
        area.setBackground(Color.WHITE);
        area.setForeground(new Color(50, 50, 50));
        return area;
    }

    @Override
    public void onNuevaAccion(String texto) {
        SwingUtilities.invokeLater(() -> modeloAcciones.add(0, texto));
    }

    @Override
    public void onNuevoPendiente(String pendiente) {
        SwingUtilities.invokeLater(() -> areaPrestamos.append(pendiente + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EstructuraDatos ventana = new EstructuraDatos();
            ventana.setVisible(true);

            // Pruebas
            GestorAcciones.push("Se ha ingresado el libro '1984'");
            GestorAcciones.push("Se ha prestado 'El Principito'");
            Pendientes.agregarPendiente("Entregar 'Cien años de soledad'");
            Pendientes.agregarPendiente("Entregar 'Don Quijote'");
        });
    }
}