

public class Main {

    public static void main(String[] args) {
        Factory factory = new AFactory();
        Role role = factory.CreatRole();

        System.out.println(role.GetRole());
    }
}
