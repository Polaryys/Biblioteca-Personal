import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estadísticas extends JFrame {

    public Estadísticas() {
        setTitle("Gestión");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        agregarBotonAtras();
        promedioprestamo();
        masprestamo();
        generroliterario();
    }

    private void agregarBotonAtras() {
        JButton button1 = new JButton("Atrás");
        button1.setFont(new Font("Arial", Font.PLAIN, 18));
        button1.setBounds(20, 30, 100, 30);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaz mainwindow = new Interfaz();
                mainwindow.setVisible(true);
                dispose();
            }
        });

        add(button1);
    }

    private void promedioprestamo() {
        JLabel titulo = new JLabel("Tiempo promedio de préstamo");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(340, 50, 400, 40);
        add(titulo);

        JTextField campo = new JTextField();
        campo.setEditable(false);
        campo.setBackground(Color.LIGHT_GRAY);
        campo.setFont(new Font("Arial", Font.PLAIN, 20));
        campo.setBounds(390, 100, 300, 40);
        add(campo);
    }

    private void masprestamo() {
    JLabel titulo = new JLabel("Libros más prestados");
    titulo.setFont(new Font("Arial", Font.BOLD, 22));
    titulo.setBounds(100, 200, 300, 30);
    add(titulo);

    int x = 100, y = 250;

    JTextField campo1 = new JTextField();
    campo1.setEditable(false);
    campo1.setBackground(Color.LIGHT_GRAY);
    campo1.setFont(new Font("Arial", Font.PLAIN, 18));
    campo1.setBounds(x, y, 250, 35);
    add(campo1);

    JTextField campo2 = new JTextField();
    campo2.setEditable(false);
    campo2.setBackground(Color.LIGHT_GRAY);
    campo2.setFont(new Font("Arial", Font.PLAIN, 18));
    campo2.setBounds(x, y + 40, 250, 35);
    add(campo2);

    JTextField campo3 = new JTextField();
    campo3.setEditable(false);
    campo3.setBackground(Color.LIGHT_GRAY);
    campo3.setFont(new Font("Arial", Font.PLAIN, 18));
    campo3.setBounds(x, y + 80, 250, 35);
    add(campo3);

    JTextField campo4 = new JTextField();
    campo4.setEditable(false);
    campo4.setBackground(Color.LIGHT_GRAY);
    campo4.setFont(new Font("Arial", Font.PLAIN, 18));
    campo4.setBounds(x, y + 120, 250, 35);
    add(campo4);
}

private void generroliterario() {
    JLabel titulo = new JLabel("Preferencias de género literario");
    titulo.setFont(new Font("Arial", Font.BOLD, 22));
    titulo.setBounds(700, 200, 350, 30);
    add(titulo);

    int x = 700, y = 250;

    JTextField campo1 = new JTextField();
    campo1.setEditable(false);
    campo1.setBackground(Color.LIGHT_GRAY);
    campo1.setFont(new Font("Arial", Font.PLAIN, 18));
    campo1.setBounds(x, y, 250, 35);
    add(campo1);

    JTextField campo2 = new JTextField();
    campo2.setEditable(false);
    campo2.setBackground(Color.LIGHT_GRAY);
    campo2.setFont(new Font("Arial", Font.PLAIN, 18));
    campo2.setBounds(x, y + 40, 250, 35);
    add(campo2);

    JTextField campo3 = new JTextField();
    campo3.setEditable(false);
    campo3.setBackground(Color.LIGHT_GRAY);
    campo3.setFont(new Font("Arial", Font.PLAIN, 18));
    campo3.setBounds(x, y + 80, 250, 35);
    add(campo3);

    JTextField campo4 = new JTextField();
    campo4.setEditable(false);
    campo4.setBackground(Color.LIGHT_GRAY);
    campo4.setFont(new Font("Arial", Font.PLAIN, 18));
    campo4.setBounds(x, y + 120, 250, 35);
    add(campo4);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Estadísticas ventana = new Estadísticas();
            ventana.setVisible(true);
        });
    }
}
