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
     
    }
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        EstructuraDatos ventana = new EstructuraDatos();
        ventana.setVisible(true);
    });
}
}