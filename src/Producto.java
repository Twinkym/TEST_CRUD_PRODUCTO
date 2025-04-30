// Clase que representa un producto con id, nombre, precio y disponibilidad.
public class Producto {
    
    // Atributos private (encapsulamiento).
    /** Identificador del producto */
    private Long id;
    /** Nombre del producto */
    private String nombre;
    /** Precio del producto, debe ser mayor o igual a 0 */
    private double precio;
    /** Indica si el producto esta disponible */
    private boolean disponible;

    /** 
     * Constructor inicializa todos los campos de un producto.
     * 
     * @param id            ID único del producto (no debe ser null).
     * @param nombre        Nombre del producto (no debe ser null o vacio).
     * @param precio        Precio del producto (debe ser >= 0).
     * @param disponible    Disponibilidad del producto (valor boolean true/flase se inicia con disponible.).
     * @throws IllegalArgumentException si alguno de los parámetros es inválido
     */
    public Producto(Long id, String nombre, double precio, boolean disponible) {

        this.id = (id != null) ? id : throwIAE("El ID no puede ser null");
        this.nombre = (nombre != null && !nombre.trim().isEmpty()) ? nombre : throwIAE("El nom no puede ser null ni vacio");
        this.precio = (precio >= 0) ? precio : throwIAE("El precio no puede ser negativo.");
        this.disponible = disponible;
    }

    // Métodos detter y setter (acceso y modificación controlada de atributos).
    // Definidos los métodos Getters.
    /** @return ID del producto */
    public Long getId(){
        return id;
    }

    /**
     * Asigna el ID del producto.
     * 
     * @param id ID no nulo.
     * @throws IllegalArgumentEception si el ID es null
     */
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
        this.id = (id != null) ? id : throwIAE("El ID no puede ser null.");
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null && !nombre.trim().isEmpty()) ? nombre : throwIAE("El nombre no puede ser null ni vacio.") ;
    }

    public void setPrecio(double precio) {
        this.precio = (precio >=0) ? precio : throwIAE("El precio no puede ser negativo.") ;
    }


    /**
     * Método auxiliar que lanza una excepción con el mensaje dado.
     * se usa para simular una excepción dentro de una expresión ternaria.
     * @param <T>       Tipo genérico que permite que el método sea usado en expresiones ternarias.
     * @param message   Mensaje descriptivo del error que se incluirá en la excepción.
     * @return          Nunca devuelve realmente un valor, ya que siempre lanza una excepción. 
     * @throws          IllegalArgumentedException Siempre se lanza con el mensaje proporcionado.
     */
    private static <T> T throwIAE(String message) {
        throw new IllegalArgumentException(message);
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
