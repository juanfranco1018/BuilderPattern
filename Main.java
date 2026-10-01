public class Main {
    public static void main(String[] args) {
        User user1 = new User.Builder("Juan", "Pérez")
                .age(30)
                .phone("+1234567890")
                .address("Calle Falsa 123")
                .build();

        System.out.println(user1);

        User user2 = new User.Builder("María", "Gómez")
                .phone("+987654321")
                .build();

        System.out.println(user2);

        User user3 = new User.Builder("Carlos", "López")
                .age(25)
                .address("Avenida Siempre Viva 456")
                .build();
                
        System.out.println(user3);
    }
}