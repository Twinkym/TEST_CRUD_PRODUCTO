import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    // Lista que simula una base de datos temporal (en memmoria).
    private List<Producto> productos = new ArrayList<>();

    // Implementación de los métodos (findall(), findbyId(Long id), save(Producto producto), 
    //                                update(Long id, Producto productoActualizado), 
    //                                deleteById(Long Id)), deleteAll().

    // Devuelve todos los productos existentes.
    public List<Producto> findAll() {
        return productos;
    }

    // Busca todos los productos existentes.
    public Producto findbyId(Long Id) {
        // Busqueda tradicional con bucle.
        for (Producto producto : productos) {
            if (producto.getId().equals(Id))
                return producto;
        }
        return null;  // Si no se encuentra.
    }

    // Agrega un nuevo producto a la lista.
    public void save(Producto producto) {
        productos.add(producto);
    }

    // Actualiza un producto existente si coincide el ID.
    public boolean update(Long id, Producto productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(id)) {
                productos.set(i, productoActualizado);  // Reemplaza el producto en la misma posición.
                return true;
            }
        }
        return false;
    }

    // Elimina un producto usando una expresión lambda y removeif()
    public boolean deleteById(Long id) {
        // removeIf() acepta una lambda que define una condición. si es verdadera, elimina el elemento.
        // Este enfoque es más elegante y declarativo que usar un bucle for manual.
        return productos.removeIf(productos -> productos.getId().equals(id));
    }

    // Elimina todos los productos de la lista.
    public void deleteAll() {
        productos.clear();  // Limpia completamente la colección.
    }
}
