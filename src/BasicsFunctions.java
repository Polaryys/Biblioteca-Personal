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
        ImageIcon icono = new ImageIcon(getClass().getResource("/Resources/Books.png"));
        setIconImage(icono.getImage());
        agregarBarraBusqueda();
        agregarIngresoLibros();
        agregarPrestamoLibros();
        agregardevolucion();
        agregarBotonAtras();
    }

  
    private JTextField crearCampoTextoEstilizado(int x, int y, int ancho, int alto) {
        JTextField campoTexto = new JTextField();
        campoTexto.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        campoTexto.setBounds(x, y, ancho, alto);
        campoTexto.setBackground(new Color(255, 255, 255));
        campoTexto.setForeground(new Color(50, 50, 50));
        campoTexto.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(192, 192, 192), 2, true),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        campoTexto.setCaretColor(new Color(100, 149, 237));
        return campoTexto;
    }

    private void estilizarBotonVerde(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        boton.setFocusPainted(false);
        boton.setBackground(new Color(0, 128, 0));  // Verde oscuro
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(0, 100, 0)); // Verde más oscuro al pasar mouse
                boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(0, 128, 0)); // Verde oscuro al salir mouse
                boton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    private void agregarBarraBusqueda() {
        JLabel label1 = new JLabel("Barra de Búsqueda");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setBounds(100, 70, 600, 40);
        add(label1);

        // Usamos crearCampoTextoEstilizado para el JTextField, con posición y tamaño
        JTextField campoTexto = crearCampoTextoEstilizado(100, 120, 300, 40);

        campoTexto.setText("Buscar por título o autor");
        campoTexto.setForeground(Color.GRAY); // Color gris para el placeholder

        // Listener para que al enfocar se borre el texto placeholder
        campoTexto.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (campoTexto.getText().equals("Buscar por título o autor")) {
                    campoTexto.setText("");
                    campoTexto.setForeground(new Color(50, 50, 50)); // texto normal
                }
            }
            public void focusLost(FocusEvent e) {
                if (campoTexto.getText().isEmpty()) {
                    campoTexto.setForeground(Color.GRAY);
                    campoTexto.setText("Buscar por título o autor");
                }
            }
        });

        add(campoTexto);

        JButton button2 = new JButton("Buscar");
        button2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button2.setBounds(100, 170, 100, 30);
        button2.setFocusPainted(false);
        button2.setBackground(new Color(100, 149, 237)); // Azul suave normal
        button2.setForeground(Color.WHITE);
        button2.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button2.setBackground(new Color(65, 105, 225)); // Azul más oscuro al pasar mouse
                button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button2.setBackground(new Color(100, 149, 237)); // Azul suave al salir mouse
                button2.setCursor(Cursor.getDefaultCursor());
            }
        });

        add(button2);
    }

    private void agregarIngresoLibros() {
        JLabel label2 = new JLabel("Ingreso de Libros");
        label2.setFont(new Font("Arial", Font.BOLD, 24));
        label2.setBounds(550, 30, 600, 40);
        add(label2);

        JTextField campoTitulo = crearCampoTextoEstilizado(550, 80, 300, 40);
        add(campoTitulo);

        JTextField campoAutor = crearCampoTextoEstilizado(550, 130, 300, 40);
        add(campoAutor);

        JTextField campoGenero = crearCampoTextoEstilizado(550, 180, 300, 40);
        add(campoGenero);

        JTextField campoAñoPublicacion = crearCampoTextoEstilizado(550, 230, 300, 40);
        add(campoAñoPublicacion);

        JTextField campoCantidad = crearCampoTextoEstilizado(550, 280, 300, 40);
        add(campoCantidad);

        JButton buttonCrear = new JButton("Crear");
        buttonCrear.setBounds(880, 285, 100, 30);
        estilizarBotonVerde(buttonCrear);
        add(buttonCrear);
    }

    private void agregarPrestamoLibros() {
        JLabel label3 = new JLabel("Préstamo de Libros");
        label3.setFont(new Font("Arial", Font.BOLD, 24));
        label3.setBounds(100, 300, 600, 40);
        add(label3);

        JTextField campoTitulo = crearCampoTextoEstilizado(100, 350, 275, 40);
        add(campoTitulo);

        JTextField campoAutor = crearCampoTextoEstilizado(100, 400, 275, 40);
        add(campoAutor);

        JTextField campoCantidad = crearCampoTextoEstilizado(100, 450, 275, 40);
        add(campoCantidad);

        JTextField campoFechaPrestamo = crearCampoTextoEstilizado(100, 500, 275, 40);
        add(campoFechaPrestamo);

        JTextField campoFechaDevolucion = crearCampoTextoEstilizado(100, 550, 275, 40);
        add(campoFechaDevolucion);

        JButton buttonPrestar = new JButton("Realizar");
        buttonPrestar.setBounds(100, 600, 100, 30);
        estilizarBotonVerde(buttonPrestar);
        add(buttonPrestar);
    }

    private void agregardevolucion() {
        JLabel label10 = new JLabel("Devolución");
        label10.setFont(new Font("Arial", Font.BOLD, 24));
        label10.setBounds(550, 350, 600, 40);
        add(label10);

        JTextField campoTitulo = crearCampoTextoEstilizado(550, 400, 300, 40);
        add(campoTitulo);

        JTextField campoCantidad = crearCampoTextoEstilizado(550, 450, 300, 40);
        add(campoCantidad);

        JTextField campoFechaPrestamo = crearCampoTextoEstilizado(550, 500, 300, 40);
        add(campoFechaPrestamo);

        JTextField campoFechaDevolucion = crearCampoTextoEstilizado(550, 550, 300, 40);
        add(campoFechaDevolucion);

        JButton buttonDevolver = new JButton("Recibir");
        buttonDevolver.setBounds(550, 600, 100, 30);
        estilizarBotonVerde(buttonDevolver);
        add(buttonDevolver);
    }

private void estilizarBotonNaranja(JButton boton) {
    boton.setFont(new Font("Arial", Font.PLAIN, 18));
    boton.setFocusPainted(false);
    boton.setBackground(new Color(204, 85, 0));  
    boton.setForeground(Color.WHITE);
    boton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

    boton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            boton.setBackground(new Color(153, 51, 0));  
            boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            boton.setBackground(new Color(204, 85, 0));  
            boton.setCursor(Cursor.getDefaultCursor());
        }
    });
}

private void agregarBotonAtras() {
    JButton button1 = new JButton("Atrás");
    button1.setBounds(20, 30, 100, 30);
    estilizarBotonNaranja(button1);

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