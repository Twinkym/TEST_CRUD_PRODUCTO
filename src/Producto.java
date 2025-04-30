// Clase que representa un producto en el sistema.
public class Producto {
    
    // Atributos private (encapsulamiento).
    private Long id;
    private String nombre;
    private double precio;
    private boolean disponible;

    // Constructor inicializa todos los campos de un producto.
    public Producto(Long id, String nombre, double precio, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = false;
    }

    // Métodos detter y setter (acceso y modificación controlada de atributos).
    // Definidos los métodos Getters.
    public Long getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public boolean getDisponible() {
        return disponible;
    }

    // Definidos los métodos Setters.
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // 
    // Método toString sobreescrito: facilita imprimir el objeto de forma legible.
    @Override
    public String toString() {
        return "Producto{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' + 
        ", precio=" + precio +
        ", disponible=" + disponible +        
        '}';
    }
}
