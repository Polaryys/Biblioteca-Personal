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
        
        JLabel label1 = new JLabel("Últimas acciones");
        label1.setFont(new Font("Arial", Font.PLAIN, 24));
        label1.setBounds(100, 80, 600, 40); // Posición y tamaño

        JLabel label2 = new JLabel();
        label2.setFont(new Font("Arial", Font.PLAIN, 24));
        label2.setBounds(100, 130, 300, 40);
        label2.setBackground(Color.LIGHT_GRAY);
        label2.setOpaque(true);

        JLabel label3 = new JLabel();
        label3.setFont(new Font("Arial", Font.PLAIN, 24));
        label3.setBounds(100, 180, 300, 40);
        label3.setBackground(Color.LIGHT_GRAY);
        label3.setOpaque(true);

        JLabel label4 = new JLabel();
        label4.setFont(new Font("Arial", Font.PLAIN, 24));
        label4.setBounds(100, 230, 300, 40);
        label4.setBackground(Color.LIGHT_GRAY);
        label4.setOpaque(true);
        
        JButton button1 = new JButton("Atrás");
        button1.setFont(new Font("Arial", Font.PLAIN, 18));
        button1.setBounds(20, 30, 100, 30); // Posición y tamaño

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
        add(label2);
        add(label3);
        add(label4);
    }
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        EstructuraDatos ventana = new EstructuraDatos();
        ventana.setVisible(true);
    });
}
}