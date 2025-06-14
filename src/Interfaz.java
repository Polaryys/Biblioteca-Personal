import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz extends JFrame {

    public Interfaz() {
        setTitle("Biblioteca Personal");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon icono = new ImageIcon(getClass().getResource("/Resources/Books.png"));
        setIconImage(icono.getImage());

        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);

  
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 30);
        Font fuenteBoton = new Font("Segoe UI", Font.PLAIN, 24);
        Font fuenteSalir = new Font("Segoe UI", Font.PLAIN, 18);
        Color colorBoton = new Color(70, 130, 180);
        Color colorBotonHover = colorBoton.darker();

        JLabel label1 = new JLabel("¡Bienvenido a tu biblioteca personal!");
        label1.setFont(fuenteTitulo);
        label1.setForeground(new Color(33, 37, 41));
        label1.setBounds(250, 30, 700, 40);
        add(label1);

        JButton button1 = crearBoton("Libros", fuenteBoton, colorBoton, colorBotonHover, 180, 110);
        JButton button2 = crearBoton("Gestión", fuenteBoton, colorBoton, colorBotonHover, 420, 110);
        JButton button3 = crearBoton("Estadísticas", fuenteBoton, colorBoton, colorBotonHover, 660, 110);
        JButton button4 = crearBoton("Salir", fuenteSalir, new Color(220, 53, 69), new Color(200, 35, 51), 920, 620);
        button4.setSize(100, 30); // Más pequeño

        // Acciones de los botones
        button1.addActionListener(e -> {
            EstructuraDatos ventanaLibros = new EstructuraDatos();
            ventanaLibros.setVisible(true);
            dispose();
        });

        button2.addActionListener(e -> {
            BasicsFunctions windowgest = new BasicsFunctions();
            windowgest.setVisible(true);
            dispose();
        });

        button3.addActionListener(e -> {
            Estadísticas status = new Estadísticas();
            status.setVisible(true);
            dispose();
        });

        button4.addActionListener(e -> System.exit(0));
        Catalogo.agregarLibro("1984 - George Orwell");
        Catalogo.agregarLibro("Cien años de soledad - Gabriel García Márquez");
        Catalogo.agregarLibro("El Principito - Antoine de Saint-Exupéry");
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        JTextArea areaCatalogo = new JTextArea();
    areaCatalogo.setEditable(false);
    areaCatalogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    areaCatalogo.setBackground(Color.WHITE);
    areaCatalogo.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    java.util.List<String> libros = Catalogo.obtenerLibros();
    StringBuilder sb = new StringBuilder("Catálogo de Libros:\n\n");
    for (String libro : libros) {
        sb.append("• ").append(libro).append("\n");
    }
    areaCatalogo.setText(sb.toString());

    JScrollPane scroll = new JScrollPane(areaCatalogo);
    scroll.setBounds(180, 190, 720, 460);
    add(scroll);
    }

    private JButton crearBoton(String texto, Font fuente, Color base, Color hover, int x, int y) {
        JButton boton = new JButton(texto);
        boton.setFont(fuente);
        boton.setBounds(x, y, 220, 50);
        boton.setBackground(base);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(hover);
            }

            public void mouseExited(MouseEvent e) {
                boton.setBackground(base);
            }
        });
        return boton;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interfaz ventana = new Interfaz();
            ventana.setVisible(true);
        });
    }
}