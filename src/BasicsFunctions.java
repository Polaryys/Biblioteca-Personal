import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicsFunctions extends JFrame {

    public BasicsFunctions() {

        setTitle("Gestión");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);

        JLabel label1 = new JLabel("Barra de Busqueda");
        label1.setFont(new Font("Arial", Font.PLAIN, 24));
        label1.setBounds(100, 80, 600, 40); 

        JLabel label2 = new JLabel("Ingreso de Libros");
        label2.setFont(new Font("Arial", Font.PLAIN, 24));
        label2.setBounds(600, 80, 600, 40);

        JTextField campoTexto = new JTextField();
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto.setBounds(100, 130, 300, 40);
        add(campoTexto);

        JTextField campoTexto2 = new JTextField();
        campoTexto2.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto2.setBounds(600, 130, 300, 40);
        add(campoTexto2);

        JTextField campoTexto3 = new JTextField();
        campoTexto3.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto3.setBounds(600, 180, 300, 40);
        add(campoTexto3);

        JTextField campoTexto4 = new JTextField();
        campoTexto4.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto4.setBounds(600, 230, 300, 40);
        add(campoTexto4);

        JTextField campoTexto5 = new JTextField();
        campoTexto5.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTexto5.setBounds(600, 280, 300, 40);
        add(campoTexto5);

        JButton button2 = new JButton("Buscar");
        button2.setFont(new Font("Arial", Font.PLAIN, 24));
        button2.setBounds(100, 180, 100, 30);

        JButton button1 = new JButton("Atrás");
        button1.setFont(new Font("Arial", Font.PLAIN, 18));
        button1.setBounds(20, 30, 100, 30);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaz mainwindow  = new Interfaz();
                mainwindow.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });


        add(button1);
        add(label1);
        add(button2);
        add(label2);
        
    }
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        EstructuraDatos ventana = new EstructuraDatos();
        ventana.setVisible(true);
    });
}
}