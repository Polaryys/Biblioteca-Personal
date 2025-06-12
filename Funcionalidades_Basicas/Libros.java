package Funcionalidades_Basicas;
import java.util.Date;


//clase para gestionar los Libros
public class Libros {
    // Atrubutos obligatorios para añadir un Libro
    private String titulo;
    private String autor;
    private String genero;
    private int añoPublicacion;
    private int cantidad;

    //Atributos opcionales para cuando se preste un Libro
    private boolean disponible;
    private boolean prestado;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    // Constructor para crear un Libro con los atrubitos obligatorios
    public Libros(String titulo, String autor, String genero, int añoPublicacion, int cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.añoPublicacion = añoPublicacion;
        this.cantidad = cantidad; // Asignar cantidad si se proporciona
        this.disponible = true; // Por defecto, un libro está disponible al crearlo
        this.prestado = false; // Por defecto, un libro no está prestado al crearlo
    }


    // Getters y Setters para los atributos
     public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAñoPublicacion() { return añoPublicacion; }
    public int getCantidad() { return cantidad; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public boolean isPrestado() { return prestado; }
    public void setPrestado(boolean prestado) { this.prestado = prestado; }

    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
