import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicsFunctions extends JFrame {

    public BasicsFunctions() {
        setTitle("Gestión");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        agregarBarraBusqueda();
        agregarIngresoLibros();
        agregarPrestamoLibros();
        agregardevolucion();
        agregarBotonAtras();
    }

    private void agregarBarraBusqueda() {
        JLabel label1 = new JLabel("Barra de Busqueda");
        label1.setFont(new Font("Arial", Font.PLAIN, 24));
        label1.setBounds(100, 70, 600, 40);
        add(label1);

        JTextField campoTexto = new JTextField("Buscar por título o autor");
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto.setBounds(100, 120, 300, 40);
        add(campoTexto);
        
        campoTexto.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (campoTexto.getText().equals("Buscar por título o autor")) {
                    campoTexto.setText("");
                }
            }
        });

        JButton button2 = new JButton("Buscar");
        button2.setFont(new Font("Arial", Font.PLAIN, 18));
        button2.setBounds(100, 170, 100, 30);
        add(button2);
    }

    private void agregarIngresoLibros() {
        JLabel label2 = new JLabel("Ingreso de Libros");
        label2.setFont(new Font("Arial", Font.PLAIN, 24));
        label2.setBounds(640, 50, 600, 40);
        add(label2);

        JTextField campoTexto2 = new JTextField();
        campoTexto2.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto2.setBounds(640, 100, 300, 40);
        add(campoTexto2);

        JTextField campoTexto3 = new JTextField();
        campoTexto3.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto3.setBounds(640, 150, 300, 40);
        add(campoTexto3);

        JTextField campoTexto4 = new JTextField();
        campoTexto4.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto4.setBounds(640, 200, 300, 40);
        add(campoTexto4);

        JTextField campoTexto5 = new JTextField();
        campoTexto5.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto5.setBounds(640, 250, 300, 40);
        add(campoTexto5);

        JButton button3 = new JButton("Crear");
        button3.setFont(new Font("Arial", Font.PLAIN, 18));
        button3.setBounds(640, 300, 100, 30);
        add(button3);
    }

    private void agregarPrestamoLibros() {
        JLabel label3 = new JLabel("Préstamo de Libros");
        label3.setFont(new Font("Arial", Font.PLAIN, 22));
        label3.setBounds(60, 275, 600, 40);
        add(label3);

        JTextField campoTexto6 = new JTextField();
        campoTexto6.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto6.setBounds(60, 325, 275, 40);
        add(campoTexto6);

        JTextField campoTexto7 = new JTextField();
        campoTexto7.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto7.setBounds(60, 375, 275, 40);
        add(campoTexto7);

        JTextField campoTexto8 = new JTextField();
        campoTexto8.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto8.setBounds(60, 425, 275, 40);
        add(campoTexto8);

        JTextField campoTexto9 = new JTextField();
        campoTexto9.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto9.setBounds(60, 475, 275, 40);
        add(campoTexto9);

        JButton button4 = new JButton("Realizar");
        button4.setFont(new Font("Arial", Font.PLAIN, 18));
        button4.setBounds(60, 525, 100, 30);
        add(button4);
    }

    private void agregardevolucion() {
        JLabel label10 = new JLabel("Devolución");
        label10.setFont(new Font("Arial", Font.PLAIN, 24));
        label10.setBounds(500, 350, 600, 40);
        add(label10);
        
        JTextField textbox = new JTextField("");
        textbox.setFont(new Font("Arial", Font.PLAIN, 24));
        textbox.setBounds(500, 400, 300, 40);
        add(textbox);
        JTextField textbox1 = new JTextField("");
        textbox1.setFont(new Font("Arial", Font.PLAIN, 24));
        textbox1.setBounds(500, 450, 300, 40);
        add(textbox1);
        JTextField textbox2 = new JTextField("");
        textbox2.setFont(new Font("Arial", Font.PLAIN, 24));
        textbox2.setBounds(500, 500, 300, 40);
        add(textbox2);
        JTextField textbox3 = new JTextField("");
        textbox3.setFont(new Font("Arial", Font.PLAIN, 24));
        textbox3.setBounds(500, 550, 300, 40);
        add(textbox3);

        JButton button = new JButton("Recibir");
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBounds(500, 600, 100, 30);
        add(button);
    }

    private void agregarBotonAtras() {
        JButton button1 = new JButton("Atrás");
        button1.setFont(new Font("Arial", Font.PLAIN, 18));
        button1.setBounds(20, 30, 100, 30);

        button1.addActionListener(e -> {
            Interfaz mainwindow = new Interfaz();
            mainwindow.setVisible(true);
            dispose();
        });

        add(button1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BasicsFunctions ventana = new BasicsFunctions();
            ventana.setVisible(true);
        });
    }
}