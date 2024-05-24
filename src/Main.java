import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        userlist();
    }

    public static void userlist() {
        Bank bank = new Bank(31);


        while (true) {
            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showAllUsers(bank);
                    break;
                case 2:
                    showUserById(bank);
                    break;
                case 3:
                    createUser(bank);
                    break;
                case 4:
                    updateUser(bank);
                    break;
                case 5:
                    removeUser(bank);
                    break;

            }
        }
    }

    public static void showMenu() {
        System.out.println("1-Bankdaki iscileri gor");
        System.out.println("2-Bankdaki spesifik iscini gor");
        System.out.println("3-Banka user elave et");
        System.out.println("4-Useri update et");
        System.out.println("5-Useri sil");
    }

    public static void showAllUsers(Bank bank) {
        System.out.println("Bankdaki isciler:");
        User[] users = bank.getAllUsers();
        for (User user : users) {
            System.out.println(user.getId() + ": " + user.getName() + " " + user.getSurname());
        }
    }


    public static void createUser(Bank bank) {
        System.out.println("Yeni user yaratmaq...");
        System.out.print("ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ad:");
        String name = scanner.nextLine();
        System.out.print("Soyad:");
        String surname = scanner.nextLine();
        System.out.print("Email:");
        String email = scanner.nextLine();
        System.out.print("Sifre:");
        String password = scanner.nextLine();

        User newUser = new User(id, name, surname, email, password);
        bank.addUser(newUser);
        System.out.println("Yeni user yaradildi: " + name + " " + surname);
    }

    public static void updateUser(Bank bank) {
        System.out.print("Update etmek ucun id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        User findUser = bank.getUserById(id);

        if (findUser != null) {
            System.out.println("Bezi temalar daxil edeceksen");
            System.out.print("Ad: ");
            String name = scanner.nextLine();
            System.out.print("Soyad: ");
            String surname = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Sifre: ");
            String password = scanner.nextLine();

            User updatedUser = new User(id, name, surname, email, password);
            bank.updateUserById(id, updatedUser);
        } else {
            System.out.println("For this ID is not find user");
        }

    }

    public static void showUserById(Bank bank) {
        System.out.print("Gormek istediyiniz User-in ID-ni daxil edin:");
        int id = scanner.nextInt();
        scanner.nextLine();
        User findUser = bank.getUserById(id);
        if (findUser != null) {
            System.out.println("User: " + findUser.getName() + " " + findUser.getSurname());
        } else {
            System.out.println("For this id is not find user ");
        }

    }

    public static void removeUser(Bank bank) {
        System.out.print("silmek istediyin id");
        int id = scanner.nextInt();
        scanner.nextLine();

        User findUser = bank.getUserById(id);

        if (findUser != null) {
            bank.removeUserById(id);
            System.out.println("adam silindi");
        } else {
            System.out.println("tapammadim" + id);
        }
    }
}