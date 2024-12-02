import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to Generic Bank! Enter l to login or s to create a new account!");
        String yes;
        User user;
        HashSet<User> test = new HashSet<User>();
        test.add(new Admin("y","y"));
        Database data = new Database(test);
        do {
            yes = inp.nextLine();
            if (yes.equals("s")) {
                user = data.signup();
            } else if (yes.equals("l")) {
                user = data.login();
            } else {
                System.out.println("Invalid Entry, Enter l to login or s to create a new account!");
            }
        } while(!(yes.equals("l") || yes.equals("s")));
    }
}