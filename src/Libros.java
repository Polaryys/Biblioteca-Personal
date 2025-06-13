

public class Libros {
    private String titulo;
    private String autor;
    private String genero;
    private int añoPublicacion;
    private int cantidad;

    public Libros(String titulo, String autor, String genero, int añoPublicacion, int cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.añoPublicacion = añoPublicacion;
        this.cantidad = cantidad;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAñoPublicacion() { return añoPublicacion; }
    public int getCantidad() { return cantidad; }

    // Setters
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAñoPublicacion(int añoPublicacion) { this.añoPublicacion = añoPublicacion; }
  public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}