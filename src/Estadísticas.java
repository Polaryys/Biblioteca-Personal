import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.stream.Collectors;
//Cambios
public class Estadísticas extends JFrame {
    public Estadísticas() {
             this.listaPrestamos = listaPrestamos;
              this.listaLibros = listaLibros;

        setTitle("Gestión");
        setSize(1080, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo claro

        ImageIcon icono = new ImageIcon(getClass().getResource("/Resources/Books.png"));
        setIconImage(icono.getImage());

        agregarBotonAtras();
        promedioprestamo();
        masprestamo();
        generroliterario();
    }

    private void agregarBotonAtras() {
        JButton button1 = new JButton("Atrás");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button1.setBounds(20, 30, 100, 30);
        button1.setFocusPainted(false);
        button1.setBackground(new Color(153, 51, 0));
        button1.setForeground(Color.WHITE);
        button1.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

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
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setBounds(340, 50, 400, 40);
        add(titulo);
          
      // Cálculo del promedio de días de préstamo
    double promedio = listaPrestamos.stream()
            .mapToInt(Prestamos::getDiasPrestamo)
            .average()
            .orElse(0); // Si la lista


        JTextField campo = crearCampoEstilo();
        campo.setBounds(390, 100, 300, 40);
        add(campo);
    }

    private void masprestamo() {
        JLabel titulo = new JLabel("Libros más prestados");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBounds(100, 200, 300, 30);
        add(titulo);
        
        // Cálculo de los libros más prestados
       Map<String, Long> conteoLibros = listaPrestamos.stream()
        .collect(Collectors.groupingBy(Prestamos::getTituloLibro, Collectors.counting()));
           List<String> librosMasPrestados = conteoLibros.entrySet().stream()
        .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
        .limit(4)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
        

        int x = 100, y = 250;

        for (int i = 0; i < 4; i++) {
            JTextField campo = crearCampoEstilo();
            campo.setBounds(x, y + (i * 50), 250, 40);
            add(campo);
        }
    }

    private void generroliterario() {
        JLabel titulo = new JLabel("Preferencias de género literario");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBounds(700, 200, 350, 30);
        add(titulo);
        
             // Cálculo de los géneros literarios más populares
         Map<String, Long> conteoGeneros = listaLibros.stream()
        .collect(Collectors.groupingBy(Libros::getGenero, Collectors.counting()));

         List<String> generosPopulares = conteoGeneros.entrySet().stream()
        .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
        .limit(4)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

        int x = 700, y = 250;

        for (int i = 0; i < 4; i++) {
            JTextField campo = crearCampoEstilo();
            campo.setBounds(x, y + (i * 50), 250, 40);
            add(campo);
        }
    }

    private JTextField crearCampoEstilo() {
        JTextField campo = new JTextField();
        campo.setEditable(false);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        campo.setBackground(Color.WHITE);
        campo.setForeground(new Color(50, 50, 50));
        campo.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 1, true));
        return campo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Estadísticas ventana = new Estadísticas();
            ventana.setVisible(true);
        });
    }
}