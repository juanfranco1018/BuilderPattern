package builder;

public class User {
    private final String firstName; // Obligatorio
    private final String lastName;  // Obligatorio
    private final int age;          // Opcional
    private final String phone;     // Opcional
    private final String address;   // Opcional

    // Constructor telescópico problemático
    public User(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }
    public User(String firstName, String lastName, int age) {
        this(firstName, lastName, age, "");
    }
    public User(String firstName, String lastName, int age, String phone) {
        this(firstName, lastName, age, phone, "");
    }
    public User(String firstName, String lastName, int age, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }
    // ... Getters ...
}
