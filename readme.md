## El Patrón Builder

### Contexto del Problema
Necesitamos crear objetos `User` que tienen muchos parámetros opcionales (algunos obligatorios, otros no). Usar constructores telescópicos (múltiples constructores con diferentes parámetros) o setters directamente en el objeto principal hace el código difícil de leer, mantener y el objeto podría ser inconsistente durante su construcción.

### Tu Tarea: Transformar el código usando el Patrón Builder.

#### Instrucciones Paso a Paso:
1. **Crea una Clase Builder Estática Interna:**
   - En la clase `User`, crea una clase estática interna llamada `Builder`.
   - El `Builder` debe tener los mismos campos que la clase `User`.
   ```java
   public static class Builder {
    // Los campos del Builder serán los mismos que los de User
    private final String firstName; // Obligatorio
    private final String lastName;  // Obligatorio
    private int age = 0;           // Opcional con valor por defecto
    private String phone = "";     // Opcional con valor por defecto
    private String address = "";   // Opcional con valor por defecto
    }
   ```

2. **Constructor del Builder para Parámetros Obligatorios:**
   - El constructor del `Builder` debe recibir solo los parámetros obligatorios (`firstName`, `lastName`).
   ```java
   public Builder(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    }
   ```

3. **Métodos de Configuración para Parámetros Opcionales:**
   - Para cada parámetro opcional, crea un método en el `Builder` que establezca el valor y devuelva la instancia actual del `Builder` (`return this;`). Esto permite el *method chaining*.
   ```java
   public Builder age(int age) {
    this.age = age;
    return this;
    }

    public Builder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Builder address(String address) {
        this.address = address;
        return this;
    }
   ```

4. **Método `build()`:**
   - Crea un método `build()` en el `Builder` que finalice la construcción y devuelva una nueva instancia de `User`, pasándose a sí mismo (`this`) normalmente a un constructor privado de `User`.
   ```java
   public User build() {
        return new User(this);
    }
   ```

5. **Constructor Privado en User:**
   - Haz que el constructor de `User` sea privado y que acepte un `Builder` como parámetro. Este constructor copiará los valores del `Builder` al `User`.
   ```java
   private User(Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
    this.phone = builder.phone;
    this.address = builder.address;
    }
   ```

6. **Usa el Builder en el Código Cliente:**
   - En `Main`, crea el usuario usando `User.Builder`.
   ```java
   public class Main {
    public static void main(String[] args) {
        // Creación legible y flexible con Builder
        User user1 = new User.Builder("Juan", "Pérez")
            .age(30)
            .phone("+123456789")
            .address("Calle Falsa 123")
            .build();
        
        System.out.println(user1);
        
        // Solo nombre, apellido y teléfono - muy claro
        User user2 = new User.Builder("María", "Gómez")
            .phone("+987654321")
            .build();
            
        System.out.println(user2);
        
        // Todas las combinaciones son posibles
        User user3 = new User.Builder("Carlos", "López")
            .age(25)
            .address("Avenida Siempre Viva 742")
            .build();
            
        System.out.println(user3);
    }
    }
   ```
## 🧪 Pruebas

Ejecuta el método main para verificar que:

* Los objetos se crean correctamente con diferentes combinaciones de parámetros
* Los objetos son inmutables después de su creación
* El código es más legible y expresivo

#### Preguntas de Análisis:
- ¿Cómo mejora la legibilidad del código cliente el uso del patrón Builder?
- ¿Qué ventaja tiene hacer la clase `Builder` estática e interna?
- ¿Garantiza este patrón la inmutabilidad del objeto `User`? ¿Por qué?

---