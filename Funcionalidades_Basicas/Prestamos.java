package Funcionalidades_Basicas;

public class Prestamos {
    private String titulo;
    private String autor;
    private int cantidadPrestada;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String fechaDevolucionReal; // NUEVO

    public Prestamos(String titulo, String autor, int cantidadPrestada, String fechaPrestamo, String fechaDevolucion) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPrestada = cantidadPrestada;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaDevolucionReal = null;
    }

    // Getters
    public String getTituloLibro() { return titulo; }
    public String getAutor() { return autor; }
    public int getCantidadPrestada() { return cantidadPrestada; }
    public String getFechaPrestamo() { return fechaPrestamo; }
    public String getFechaDevolucion() { return fechaDevolucion; }
    public String getFechaDevolucionReal() { return fechaDevolucionReal; }

    // Setters
    public void setFechaDevolucionReal(String fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }
    public void setCantidadPrestada(int cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }
}
