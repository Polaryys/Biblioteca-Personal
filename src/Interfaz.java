import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

    public Interfaz() {

        setTitle("Biblioteca Personal");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);
        JLabel label1 = new JLabel("¡Bienvenido a tu biblioteca personal!");
        label1.setFont(new Font("Arial", Font.PLAIN, 28));
        label1.setBounds(300, 20, 600, 40); // Posición y tamaño
        JButton button1 = new JButton("Libros");
        button1.setFont(new Font("Arial", Font.PLAIN, 28));
        button1.setBounds(180, 110, 220, 50); // Posición y tamaño
        JButton button2 = new JButton("Gestión");
        button2.setFont(new Font("Arial", Font.PLAIN, 28));
        button2.setBounds(420, 110, 220, 50); // Posición y tamaño
        JButton button3 = new JButton("Estadísticas");
        button3.setFont(new Font("Arial", Font.PLAIN, 28));
        button3.setBounds(660, 110, 220, 50); // Posición y tamaño
        JButton button4 = new JButton("Salir");
        button4.setFont(new Font("Arial", Font.PLAIN, 18));
        button4.setBounds(920, 620, 100, 30); // Posición y tamaño

        // Acción del botón "Libros"
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EstructuraDatos ventanaLibros = new EstructuraDatos();
                ventanaLibros.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicsFunctions windowgest = new BasicsFunctions();
                windowgest.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Estadísticas status = new Estadísticas();
                status.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Finaliza todo
            }
        });
        add(label1);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interfaz ventana = new Interfaz();
            ventana.setVisible(true);
        });
    }
}