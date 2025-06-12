import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstructuraDatos extends JFrame {

    public EstructuraDatos() {
        setTitle("Libros");
        
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/Resources/Books.png"));
        setIconImage(icono.getImage());
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo general claro

        inicializarComponentes();
        prestamospendientes(); // Carga segunda sección visual
    }
    
    private void inicializarComponentes() {
        JLabel label1 = new JLabel("Últimas acciones");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 26));
        label1.setBounds(100, 80, 600, 40);

        JLabel label2 = crearEtiquetaEstilo(80, 130);
        JLabel label3 = crearEtiquetaEstilo(80, 180);
        JLabel label4 = crearEtiquetaEstilo(80, 230);
        JLabel label5 = crearEtiquetaEstilo(80, 280);

        JButton button1 = new JButton("Atrás");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button1.setBounds(20, 30, 100, 30);
        button1.setFocusPainted(false);
        button1.setBackground(new Color(153, 51, 0)); // Azul suave
        button1.setForeground(Color.WHITE);
        button1.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaz mainwindow = new Interfaz();
                mainwindow.setVisible(true);
                dispose();
            }
        });

        add(button1);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
    }

    private void prestamospendientes() {
        JLabel label1 = new JLabel("Préstamos pendientes");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 26));
        label1.setBounds(600, 80, 600, 40);

        JLabel label2 = crearEtiquetaEstilo(580, 130);
        JLabel label3 = crearEtiquetaEstilo(580, 180);
        JLabel label4 = crearEtiquetaEstilo(580, 230);
        JLabel label5 = crearEtiquetaEstilo(580, 280);

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
    }

    private JLabel crearEtiquetaEstilo(int x, int y) {
        JLabel label = new JLabel(" ");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        label.setBounds(x, y, 450, 40);
        label.setBackground(new Color(224, 224, 224));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 1, true)); // Bordes redondeados
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EstructuraDatos ventana = new EstructuraDatos();
            ventana.setVisible(true);
        });
    }
}