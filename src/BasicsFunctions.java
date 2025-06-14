import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BasicsFunctions extends JFrame {
    private JTextField campoTituloPrestamo;
    private JTextField campoAutorPrestamo;
    private JTextField campoCantidadPrestamo;
    private JTextField campoFechaPrestamo;
    private JTextField campoFechaDevolucionPrestamo;

    // Campos para la devolución
    private JTextField campoTituloDevolucion;
    private JTextField campoAutorDevolucion; // Nuevo campo para el autor en la devolución
    private JTextField campoCantidadDevolucion;
    private JTextField campoFechaPrestamoDevolucion;
    private JTextField campoFechaDevolucionReal;


    private ArrayList<Libros> listaLibros = new ArrayList<>();
    private ArrayList<Prestamos> listaPrestamos = new ArrayList<>();

    public BasicsFunctions() {
        setTitle("Gestión de Biblioteca");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/Resources/Books.png"));
        setIconImage(icono.getImage());

        // Libros de ejemplo
        listaLibros.add(new Libros("Cien años de soledad", "Gabriel García Márquez", "Novela", 1967, 10));
        listaLibros.add(new Libros("El Principito", "Antoine de Saint-Exupéry", "Fábula", 1943, 7));
        listaLibros.add(new Libros("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela", 1605, 6));

        agregarBarraBusqueda();
        agregarIngresoLibros();
        agregarPrestamoLibros();
        agregardevolucion();
        agregarBotonAtras();
    }

    // Método auxiliar para campos de texto estilizados con placeholder
    private JTextField crearCampoTextoEstilizado(int x, int y, int ancho, int alto, String placeholder) {
        JTextField campoTexto = new JTextField();
        campoTexto.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        campoTexto.setBounds(x, y, ancho, alto);
        campoTexto.setBackground(new Color(255, 255, 255));
        campoTexto.setForeground(Color.GRAY); // Color inicial para el placeholder
        campoTexto.setText(placeholder); // Placeholder inicial
        campoTexto.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(192, 192, 192), 2, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        campoTexto.setCaretColor(new Color(100, 149, 237));

        campoTexto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campoTexto.getText().equals(placeholder)) {
                    campoTexto.setText("");
                    campoTexto.setForeground(new Color(50, 50, 50));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campoTexto.getText().isEmpty()) {
                    campoTexto.setText(placeholder);
                    campoTexto.setForeground(Color.GRAY);
                }
            }
        });
        return campoTexto;
    }

    // Método auxiliar para botones verdes
    private void estilizarBotonVerde(JButton boton) {
        boton.setFont(new Font("Arial", Font.PLAIN, 18));
        boton.setFocusPainted(false);
        boton.setBackground(new Color(0, 128, 0));  // Verde oscuro
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(0, 100, 0));
                boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(0, 128, 0));
                boton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    // Método auxiliar para botones naranjas
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

    private void agregarBarraBusqueda() {
        JLabel label1 = new JLabel("Barra de Búsqueda");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setBounds(100, 70, 600, 40);
        add(label1);

        JTextField campoTexto = crearCampoTextoEstilizado(100, 120, 300, 40, "Buscar por título, autor o genero");
        add(campoTexto);

        JButton buttonBuscar = new JButton("Buscar");
        buttonBuscar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        buttonBuscar.setBounds(100, 170, 100, 30);
        buttonBuscar.setFocusPainted(false);
        buttonBuscar.setBackground(new Color(100, 149, 237));
        buttonBuscar.setForeground(Color.WHITE);
        buttonBuscar.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        buttonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonBuscar.setBackground(new Color(65, 105, 225));
                buttonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonBuscar.setBackground(new Color(100, 149, 237));
                buttonBuscar.setCursor(Cursor.getDefaultCursor());
            }
        });

        add(buttonBuscar);

        buttonBuscar.addActionListener(e -> {
            String consulta = campoTexto.getText().trim().toLowerCase();
            if (consulta.isEmpty() || consulta.equals("buscar por título, autor o genero")) {
                JOptionPane.showMessageDialog(this, "Ingresa un criterio de búsqueda.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            StringBuilder resultados = new StringBuilder();
            for (Libros libro : listaLibros) {
                if (libro.getTitulo().toLowerCase().contains(consulta) ||
                    libro.getAutor().toLowerCase().contains(consulta) ||
                    libro.getGenero().toLowerCase().contains(consulta)) {
                    resultados.append("Título: ").append(libro.getTitulo())
                                  .append(" | Autor: ").append(libro.getAutor())
                                  .append(" | Género: ").append(libro.getGenero())
                                  .append(" | Año: ").append(libro.getAñoPublicacion())
                                  .append(" | Cantidad: ").append(libro.getCantidad())
                                  .append("\n");
                }
            }

            if (resultados.length() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron libros.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, resultados.toString(), "Resultados de búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void agregarIngresoLibros() {
        JLabel label2 = new JLabel("Ingreso de Libros");
        label2.setFont(new Font("Arial", Font.BOLD, 24));
        label2.setBounds(550, 30, 600, 40);
        add(label2);

        JTextField campoTitulo = crearCampoTextoEstilizado(550, 80, 300, 40, "Título");
        add(campoTitulo);

        JTextField campoAutor = crearCampoTextoEstilizado(550, 130, 300, 40, "Autor");
        add(campoAutor);

        JTextField campoGenero = crearCampoTextoEstilizado(550, 180, 300, 40, "Género");
        add(campoGenero);

        JTextField campoAñoPublicacion = crearCampoTextoEstilizado(550, 230, 300, 40, "Año de Publicación");
        add(campoAñoPublicacion);

        JTextField campoCantidad = crearCampoTextoEstilizado(550, 280, 300, 40, "Cantidad");
        add(campoCantidad);

        JButton buttonCrear = new JButton("Crear");
        buttonCrear.setBounds(880, 285, 100, 30);
        estilizarBotonVerde(buttonCrear);
        add(buttonCrear);

        buttonCrear.addActionListener(e -> {
            String titulo = campoTitulo.getText();
            String autor = campoAutor.getText();
            String genero = campoGenero.getText();
            int añoPublicacion;
            int cantidad;
            try {
                añoPublicacion = Integer.parseInt(campoAñoPublicacion.getText());
                cantidad = Integer.parseInt(campoCantidad.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El año y la cantidad deben ser números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que los campos no estén vacíos o con el texto del placeholder
            if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() ||
                titulo.equals("Título") || autor.equals("Autor") || genero.equals("Género") ||
                campoAñoPublicacion.getText().equals("Año de Publicación") || campoCantidad.getText().equals("Cantidad")) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            listaLibros.add(new Libros(titulo, autor, genero, añoPublicacion, cantidad));
            JOptionPane.showMessageDialog(this, "Libro agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            GestorAcciones.push("Se ha ingresado el libro:" + titulo +","+ añoPublicacion);

            campoTitulo.setText("Título");
            campoAutor.setText("Autor");
            campoGenero.setText("Género");
            campoAñoPublicacion.setText("Año de Publicación");
            campoCantidad.setText("Cantidad");
            campoTitulo.setForeground(Color.GRAY);
            campoAutor.setForeground(Color.GRAY);
            campoGenero.setForeground(Color.GRAY);
            campoAñoPublicacion.setForeground(Color.GRAY);
            campoCantidad.setForeground(Color.GRAY);
        });
    }

    // --- SECCIÓN DE PRÉSTAMO DE LIBROS ---
    private void agregarPrestamoLibros() {
        JLabel label3 = new JLabel("Préstamo de Libros");
        label3.setFont(new Font("Arial", Font.BOLD, 24));
        label3.setBounds(100, 300, 600, 40);
        add(label3);

        campoTituloPrestamo = crearCampoTextoEstilizado(100, 350, 275, 40, "Título ");
        add(campoTituloPrestamo);

        campoAutorPrestamo = crearCampoTextoEstilizado(100, 400, 275, 40, "Autor");
        add(campoAutorPrestamo);

        campoCantidadPrestamo = crearCampoTextoEstilizado(100, 450, 275, 40, "Cantidad a prestar");
        add(campoCantidadPrestamo);

        campoFechaPrestamo = crearCampoTextoEstilizado(100, 500, 275, 40, "Fecha de préstamo (DD/MM/AAAA)");
        add(campoFechaPrestamo);

        campoFechaDevolucionPrestamo = crearCampoTextoEstilizado(100, 550, 275, 40, "Fecha de devolución (DD/MM/AAAA)");
        add(campoFechaDevolucionPrestamo);

        JButton buttonPrestar = new JButton("Realizar");
        buttonPrestar.setBounds(100, 600, 100, 30);
        estilizarBotonVerde(buttonPrestar);
        add(buttonPrestar);

        buttonPrestar.addActionListener(e -> {
            String titulo = campoTituloPrestamo.getText();
            String autor = campoAutorPrestamo.getText();
            int cantidad;
            String fechaPrestamo = campoFechaPrestamo.getText();
            String fechaDevolucion = campoFechaDevolucionPrestamo.getText();

            try {
                cantidad = Integer.parseInt(campoCantidadPrestamo.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que los campos no estén vacíos o con el texto del placeholder
            if (titulo.isEmpty() || autor.isEmpty() || fechaPrestamo.isEmpty() || fechaDevolucion.isEmpty() ||
                titulo.equals("Título del libro") || autor.equals("Autor del libro") ||
                fechaPrestamo.equals("Fecha de préstamo (DD/MM/AAAA)") || fechaDevolucion.equals("Fecha de devolución esperada (DD/MM/AAAA)")) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad a prestar debe ser mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Libros libroEncontrado = null;
            String tituloBuscado = titulo.trim().toLowerCase();
            String autorBuscado = autor.trim().toLowerCase();
            for (Libros libro : listaLibros) {
              
                if (libro.getTitulo().trim().toLowerCase().equals(tituloBuscado) &&
                    libro.getAutor().trim().toLowerCase().equals(autorBuscado)) {
                    libroEncontrado = libro;
                    break;
                }
            }

            if (libroEncontrado == null) {
                JOptionPane.showMessageDialog(this, "El libro no existe en la biblioteca o el autor es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (libroEncontrado.getCantidad() < cantidad) {
                JOptionPane.showMessageDialog(this, "No hay suficientes ejemplares disponibles. Cantidad disponible: " + libroEncontrado.getCantidad(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            libroEncontrado.setCantidad(libroEncontrado.getCantidad() - cantidad);

            listaPrestamos.add(new Prestamos(titulo, autor, cantidad, fechaPrestamo, fechaDevolucion));
            JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            GestorAcciones.push("Se ha Prestado el libro:" + titulo);
            Pendientes.agregarPendiente("Pendiente de Entregar libro: "+ titulo + " hasta la fecha "+ fechaPrestamo);
            campoTituloPrestamo.setText("Título");
            campoAutorPrestamo.setText("Autor");
            campoCantidadPrestamo.setText("Cantidad a prestar");
            campoFechaPrestamo.setText("Fecha de préstamo (DD/MM/AAAA)");
            campoFechaDevolucionPrestamo.setText("Fecha de devolución (DD/MM/AAAA)");
            campoTituloPrestamo.setForeground(Color.GRAY);
            campoAutorPrestamo.setForeground(Color.GRAY);
            campoCantidadPrestamo.setForeground(Color.GRAY);
            campoFechaPrestamo.setForeground(Color.GRAY);
            campoFechaDevolucionPrestamo.setForeground(Color.GRAY);
        });
    }

    private void agregardevolucion() {
        JLabel label10 = new JLabel("Devolución de Libros");
        label10.setFont(new Font("Arial", Font.BOLD, 24));
        label10.setBounds(550, 350, 600, 40);
        add(label10);

        campoTituloDevolucion = crearCampoTextoEstilizado(550, 400, 300, 40, "Título a devolver");
        add(campoTituloDevolucion);

        campoAutorDevolucion = crearCampoTextoEstilizado(550, 450, 300, 40, "Autor"); // Nuevo campo para el autor
        add(campoAutorDevolucion);

        campoCantidadDevolucion = crearCampoTextoEstilizado(550, 500, 300, 40, "Cantidad a devolver");
        add(campoCantidadDevolucion);

        campoFechaPrestamoDevolucion = crearCampoTextoEstilizado(550, 550, 300, 40, "Fecha de préstamo (DD/MM/AAAA)");
        add(campoFechaPrestamoDevolucion);

        campoFechaDevolucionReal = crearCampoTextoEstilizado(550, 600, 300, 40, "Fecha real de devolución (DD/MM/AAAA)");
        add(campoFechaDevolucionReal);

        JButton buttonDevolver = new JButton("Recibir");
        buttonDevolver.setBounds(550, 650, 100, 30);
        estilizarBotonVerde(buttonDevolver);
        add(buttonDevolver);

        buttonDevolver.addActionListener(e -> {
            String titulo = campoTituloDevolucion.getText();
            String autor = campoAutorDevolucion.getText(); 
            int cantidad;
            String fechaPrestamo = campoFechaPrestamoDevolucion.getText();
            String fechaDevolucionRealStr = campoFechaDevolucionReal.getText();
            try {
                cantidad = Integer.parseInt(campoCantidadDevolucion.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (titulo.isEmpty() || autor.isEmpty() || fechaPrestamo.isEmpty() || fechaDevolucionRealStr.isEmpty() ||
                titulo.equals("Título del libro a devolver") || autor.equals("Autor del libro a devolver") ||
                fechaPrestamo.equals("Fecha de préstamo (DD/MM/AAAA)") || fechaDevolucionRealStr.equals("Fecha real de devolución (DD/MM/AAAA)")) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad a devolver debe ser mayor a cero", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Prestamos prestamoEncontrado = null;
            for (Prestamos prestamo : listaPrestamos) {
                // Ahora buscar el préstamo usando título, autor y fecha de préstamo
                if (prestamo.getTituloLibro().equalsIgnoreCase(titulo) &&
                    prestamo.getAutor().equalsIgnoreCase(autor) && // Comparar también el autor
                    prestamo.getFechaPrestamo().equalsIgnoreCase(fechaPrestamo) &&
                    prestamo.getCantidadPrestada() >= cantidad) {
                    prestamoEncontrado = prestamo;
                    break;
                }
            }
            if (prestamoEncontrado == null) {
                JOptionPane.showMessageDialog(this, "No se encontró un préstamo con esos datos o la cantidad a devolver es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aumentar la cantidad del libro en la biblioteca
            for (Libros libro : listaLibros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.getAutor().equalsIgnoreCase(autor)) { // Coincidir por título y autor
                    libro.setCantidad(libro.getCantidad() + cantidad);
                    break;
                }
            }

            int nuevaCantidadPrestada = prestamoEncontrado.getCantidadPrestada() - cantidad;
            if (nuevaCantidadPrestada > 0) {
                prestamoEncontrado.setCantidadPrestada(nuevaCantidadPrestada);
                prestamoEncontrado.setFechaDevolucionReal(fechaDevolucionRealStr);
                JOptionPane.showMessageDialog(this, "Devolución parcial registrada correctamente. Cantidad restante prestada: " + nuevaCantidadPrestada, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                listaPrestamos.remove(prestamoEncontrado);
                prestamoEncontrado.setFechaDevolucionReal(fechaDevolucionRealStr); 
                JOptionPane.showMessageDialog(this, "Devolución total registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            GestorAcciones.push("Se ha devuelto el libro:" + titulo);
            campoTituloDevolucion.setText("Título a devolver");
            campoAutorDevolucion.setText("Autor");
            campoCantidadDevolucion.setText("Cantidad a devolver");
            campoFechaPrestamoDevolucion.setText("Fecha de préstamo (DD/MM/AAAA)");
            campoFechaDevolucionReal.setText("Fecha real de devolución (DD/MM/AAAA)");
            campoTituloDevolucion.setForeground(Color.GRAY);
            campoAutorDevolucion.setForeground(Color.GRAY);
            campoCantidadDevolucion.setForeground(Color.GRAY);
            campoFechaPrestamoDevolucion.setForeground(Color.GRAY);
            campoFechaDevolucionReal.setForeground(Color.GRAY);
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