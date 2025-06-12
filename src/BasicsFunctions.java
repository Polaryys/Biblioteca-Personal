import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Funcionalidades_Basicas.Libros;
import Funcionalidades_Basicas.Prestamos;

public class BasicsFunctions extends JFrame {
    private ArrayList<Libros> listaLibros = new ArrayList<>();
     private ArrayList<Prestamos> listaPrestamos = new ArrayList<>();
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

         //Libros ya creados
        listaLibros.add(new Libros("Cien años de soledad", "Gabriel García Márquez", "Fantasía", 1967, 8 ));
        listaLibros.add(new Libros("El amor en los tiempos del cólera", "Gabriel García Márquez", "Romance", 1985, 5));
        listaLibros.add(new Libros("1984", "George Orwell", "Distopía", 1949, 10));


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
            @Override
            public void focusGained(FocusEvent e) {
                if (campoTexto.getText().equals("Buscar por título o autor")) {
                    campoTexto.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (campoTexto.getText().isEmpty()) {
                    campoTexto.setText("Buscar por título o autor");
                }
            }
        });

        JButton buttonBuscar = new JButton("Buscar");
        buttonBuscar.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonBuscar.setBounds(100, 170, 100, 30);
        add(buttonBuscar);

        buttonBuscar.addActionListener(e -> {
            String textoBusqueda = campoTexto.getText();
            if (textoBusqueda.isEmpty() || textoBusqueda.equals("Buscar por título o autor")) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un término de búsqueda válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aquí se puede implementar la lógica de búsqueda en la lista de libros
            boolean encontrado = false;
            for (Libros libro : listaLibros) {
                if (libro.getTitulo().equalsIgnoreCase(textoBusqueda) || libro.getAutor().equalsIgnoreCase(textoBusqueda)) {
                    JOptionPane.showMessageDialog(this, "Libro encontrado: " + libro.getTitulo() + " por " + libro.getAutor(), "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "No se encontraron resultados para: " + textoBusqueda, "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void agregarIngresoLibros() {
        JLabel label2 = new JLabel("Ingreso de Libros");
        label2.setFont(new Font("Arial", Font.PLAIN, 24));
        label2.setBounds(640, 50, 600, 40);
        add(label2);

        JTextField campoTitulo = new JTextField();
        campoTitulo.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTitulo.setBounds(640, 100, 300, 40);
        add(campoTitulo);

        JTextField campoAutor = new JTextField();
        campoAutor.setFont(new Font("Arial", Font.PLAIN, 24));
        campoAutor.setBounds(640, 150, 300, 40);
        add(campoAutor);

        JTextField campoGenero = new JTextField();
        campoGenero.setFont(new Font("Arial", Font.PLAIN, 24));
        campoGenero.setBounds(640, 200, 300, 40);
        add(campoGenero);

        JTextField campoAñoPublicacion = new JTextField();
        campoAñoPublicacion.setFont(new Font("Arial", Font.PLAIN, 24));
        campoAñoPublicacion.setBounds(640, 250, 300, 40);
        add(campoAñoPublicacion);

        JTextField campoCantidad = new JTextField();
        campoCantidad.setFont(new Font("Arial", Font.PLAIN, 24));
        campoCantidad.setBounds(640, 300, 300, 40);
        add(campoCantidad);

        JButton buttonCrear = new JButton("Crear");
        buttonCrear.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonCrear.setBounds(640, 350, 100, 30);
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

    if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Libros nuevoLibro = new Libros(titulo, autor, genero, añoPublicacion, cantidad);
    listaLibros.add(nuevoLibro);

    JOptionPane.showMessageDialog(this, "Libro agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    // Limpiar campos
    campoTitulo.setText("");
    campoAutor.setText("");
    campoGenero.setText("");
    campoAñoPublicacion.setText("");
    campoCantidad.setText("");
});
    }

    

    private void agregarPrestamoLibros() {
        JLabel label3 = new JLabel("Préstamo de Libros");
        label3.setFont(new Font("Arial", Font.PLAIN, 22));
        label3.setBounds(60, 275, 600, 40);
        add(label3);

        JTextField campoTitulo = new JTextField();
        campoTitulo.setFont(new Font("Arial", Font.PLAIN, 24));
        campoTitulo.setBounds(60, 325, 275, 40);
        add(campoTitulo);

        JTextField campoAutor = new JTextField();
        campoAutor.setFont(new Font("Arial", Font.PLAIN, 24));
        campoAutor.setBounds(60, 375, 275, 40);
        add(campoAutor);

        JTextField campoCantidad = new JTextField();
        campoCantidad.setFont(new Font("Arial", Font.PLAIN, 24));
        campoCantidad.setBounds(60, 425, 275, 40);
        add(campoCantidad);

        JTextField campoFechaPrestamo = new JTextField();
        campoFechaPrestamo.setFont(new Font("Arial", Font.PLAIN, 24));
        campoFechaPrestamo.setBounds(60, 475, 275, 40);
        add(campoFechaPrestamo);

        JTextField campoFechaDevolucion = new JTextField();
        campoFechaDevolucion.setFont(new Font("Arial", Font.PLAIN, 24));
        campoFechaDevolucion.setBounds(60, 525, 275, 40);
        add(campoFechaDevolucion);

        JButton buttonPrestar = new JButton("Realizar");
        buttonPrestar.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPrestar.setBounds(60, 575, 100, 30);
        add(buttonPrestar);

        

        buttonPrestar.addActionListener (e -> {
    String titulo = campoTitulo.getText();
    String autor = campoAutor.getText();
    int cantidad;
    String fechaPrestamo = campoFechaPrestamo.getText();
    String fechaDevolucion = campoFechaDevolucion.getText();
    try {
        cantidad = Integer.parseInt(campoCantidad.getText().trim());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (titulo.isEmpty() || autor.isEmpty() || fechaPrestamo.isEmpty() || fechaDevolucion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar si el libro existe y hay suficientes ejemplares
    Libros libroEncontrado = null;
    for (Libros libro : listaLibros) {
        if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.getAutor().equalsIgnoreCase(autor)) {
            libroEncontrado = libro;
            break;
        }
    }
    if (libroEncontrado == null) {
        JOptionPane.showMessageDialog(this, "El libro no existe en la biblioteca.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Depuración: mostrar cantidades
    System.out.println("Cantidad disponible: " + libroEncontrado.getCantidad() + ", cantidad solicitada: " + cantidad);

    if (libroEncontrado.getCantidad() < cantidad) {
        JOptionPane.showMessageDialog(this, "No hay suficientes ejemplares disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    libroEncontrado.setCantidad(libroEncontrado.getCantidad() - cantidad);

    Prestamos nuevoPrestamo = new Prestamos(titulo, autor, cantidad, fechaPrestamo, fechaDevolucion);
    listaPrestamos.add(nuevoPrestamo);

    JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    // Limpiar campos
    campoTitulo.setText("");
    campoAutor.setText("");
    campoCantidad.setText("");
    campoFechaPrestamo.setText("");
    campoFechaDevolucion.setText("");
});
    }
   private void agregardevolucion() {
    JLabel label10 = new JLabel("Devolución");
    label10.setFont(new Font("Arial", Font.PLAIN, 24));
    label10.setBounds(500, 350, 600, 40);
    add(label10);

    JTextField campoTitulo = new JTextField("");
    campoTitulo.setFont(new Font("Arial", Font.PLAIN, 24));
    campoTitulo.setBounds(500, 400, 300, 40);
    add(campoTitulo);

    JTextField campoCantidad = new JTextField("");
    campoCantidad.setFont(new Font("Arial", Font.PLAIN, 24));
    campoCantidad.setBounds(500, 450, 300, 40);
    add(campoCantidad);

    JTextField campoFechaPrestamo = new JTextField("");
    campoFechaPrestamo.setFont(new Font("Arial", Font.PLAIN, 24));
    campoFechaPrestamo.setBounds(500, 500, 300, 40);
    add(campoFechaPrestamo);

    JTextField campoFechaDevolucion = new JTextField("");
    campoFechaDevolucion.setFont(new Font("Arial", Font.PLAIN, 24));
    campoFechaDevolucion.setBounds(500, 550, 300, 40);
    add(campoFechaDevolucion);

    JButton buttonDevolver = new JButton("Recibir");
    buttonDevolver.setFont(new Font("Arial", Font.PLAIN, 18));
    buttonDevolver.setBounds(500, 600, 100, 30);
    add(buttonDevolver);

    buttonDevolver.addActionListener(e -> {
        String titulo = campoTitulo.getText();
        int cantidad;
        String fechaPrestamo = campoFechaPrestamo.getText();
        String fechaDevolucionReal = campoFechaDevolucion.getText();
        try {
            cantidad = Integer.parseInt(campoCantidad.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (titulo.isEmpty() || fechaPrestamo.isEmpty() || fechaDevolucionReal.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar el préstamo correspondiente
        Prestamos prestamoEncontrado = null;
        for (Prestamos prestamo : listaPrestamos) {
            if (prestamo.getTituloLibro().equalsIgnoreCase(titulo)
                && prestamo.getFechaPrestamo().equalsIgnoreCase(fechaPrestamo)
                && prestamo.getCantidadPrestada() >= cantidad) {
                prestamoEncontrado = prestamo;
                break;
            }
        }
        if (prestamoEncontrado == null) {
            JOptionPane.showMessageDialog(this, "El préstamo no existe o la cantidad es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar la cantidad del libro
        for (Libros libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.setCantidad(libro.getCantidad() + cantidad);
                break;
            }
        }

        // Actualizar la fecha de devolución real
        prestamoEncontrado.setFechaDevolucionReal(fechaDevolucionReal);

        // Actualizar o eliminar el préstamo
        int nuevaCantidad = prestamoEncontrado.getCantidadPrestada() - cantidad;
        if (nuevaCantidad > 0) {
            prestamoEncontrado.setCantidadPrestada(nuevaCantidad);
            JOptionPane.showMessageDialog(this, "Devolución parcial registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            listaPrestamos.remove(prestamoEncontrado);
            JOptionPane.showMessageDialog(this, "Devolución total registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

        // Limpiar campos
        campoTitulo.setText("");
        campoCantidad.setText("");
        campoFechaPrestamo.setText("");
        campoFechaDevolucion.setText("");
    });
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