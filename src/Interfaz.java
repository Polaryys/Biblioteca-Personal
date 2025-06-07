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
        JLabel etiqueta = new JLabel("¡Bienvenido a tu biblioteca personal!");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 28));
        etiqueta.setBounds(300, 100, 600, 40); // Posición y tamaño
        JButton boton = new JButton("¿Listo?");
        boton.setFont(new Font("Arial", Font.PLAIN, 28));
        boton.setBounds(440, 200, 200, 50); // Posición y tamaño

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("¡Hora de iniciar!");
            }
        });

        add(etiqueta);
        add(boton);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interfaz ventana = new Interfaz();
            ventana.setVisible(true);
        });
    }
}