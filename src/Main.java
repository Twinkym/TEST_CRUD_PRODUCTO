import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // Permite leer entrada del usuario por consola.
        ProductoRepository repository = new ProductoRepository();  // Repositorio en memoria.
        int opcion;

        // Bucle do-while: mantiene el programa activo hasta que el usuario elige salir.
        do {
            // Manú principal.
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Mostrar todos los productos.");
            System.out.println("2. Filtrar producto por ID.");
            System.out.println("3. Guardar un nuevo producto.");
            System.out.println("4. Actualizar un producto por ID.");
            System.out.println("5. Eliminar un producto por ID.");
            System.out.println("6. Eliminar todos los productos.");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción: ");

            opcion = scanner.nextInt();  // Captura la opción del usuario.
            scanner.nextLine();   // Limpiar el buffer del scanner.

            // switch con exprpesiones lambda (Java 14+ admite -> en lugar de break)
            switch (opcion) {
                case 1 -> {
                    
                    System.out.println("--- Lista de Prodcutos ---");
                    for (Producto producto : repository.findAll()) {
                        System.out.println(producto);
                    }
                }

                case 2 -> {
                    System.out.println("Ingrese ID: ");
                    Long id = scanner.nextLong();
                    Producto producto = repository.findById(id);

                    // Operador ternario: expresión compacta para decidir qué imprimir es mucho más elegante.
                    System.out.println(producto != null ? producto : "Producto no encontrado.");
                }

                case 3 -> {
                    // Solicita datos para un nuevo producto.
                    try {
                    System.out.println("ID: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();     // Limpia el buffer del scanner.
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.println("Disponible (true/flase): ");
                    boolean disponible = scanner.nextBoolean();

                    Producto nuevo = new Producto(id, nombre, precio, disponible);
                    repository.save(nuevo);     // Guarda el nuevo producto.
                    System.out.println("Producto guardado correctamente.");
                } catch (InputMismatchException e) {
                    System.out.println("Error: Entrada no válida. Intenta de nunevo.");
                    scanner.nextLine();  // Limpiar entrada inválida.
                }

                case 4 -> {
                    System.out.println("ID del producto a actualizar: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Nuevo nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Nuevo precio: ");
                    double precio = scanner.nextDouble();
                    System.out.println("Disponible (true/false): ");
                    boolean disponible = scanner.nextBoolean();

                    Producto actualizado = new Producto(id, nombre, precio, disponible);
                    boolean resultado = repository.update(id, actualizado);
                    System.out.println(resultado ? "Producto actualizado." : "Producto no encontrado.");
                }

                case 5 -> {
                    System.out.println("ID del producto a eliminar: ");
                    Long id = scanner.nextLong();
                    boolean eliminado = repository.deleteById(id);
                    System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");
                }

                case 6 -> {
                    repository.deleteAll();
                    System.out.println("Todos los productos eliminados.");
                }
                
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);  // Mantiene abierta la ejecución hasta que el usuario selecciona la opción correcta para salir del programa.

        scanner.close();   // Cerrar el scanner al final es buena practica
    }
}
