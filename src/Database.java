import java.util.*;

public class Database {

    Set<User> base;
    Map<String,String> info;
    public Database(Set<User> users) {
        base = new HashSet<User>();
        base.addAll(users);
        info = new HashMap<String,String>();
        updateInfo();
    }
    public void updateInfo() {
        for(User i: base) {
            info.put(i.getUsername(),i.getPassword());
        }
    }
    public Database() {
        base = new HashSet<User>();
        info = new HashMap<String,String>();
    }
    public  User signup() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter a username");
        String yes = inp.nextLine();
        while (info.containsKey(yes)) {
            System.out.println("That username is taken! Please enter another username!");
            yes = inp.nextLine();
        }
        System.out.println("Please enter a password!");
        User newUser = new User(yes,inp.nextLine());
        System.out.println("Succesfully signed up! Logging in... ");
        base.add(newUser);
        updateInfo();
        return newUser;
    }
    public User login() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter you username");
        String username = inp.nextLine();
        System.out.println("Enter password");
        String password = inp.nextLine();
        while(!info.containsKey(username) || !info.get(username).equals(password)) {
            System.out.println("username or password was incorrect, try again!");
            System.out.println("Enter you username");
            username = inp.nextLine();
            System.out.println("Enter password");
            password = inp.nextLine();
        }
        for(User i: base) {
            if(i.checkInfo(username,password)) {
                System.out.println("Succesfully Logged in");
                return i;
            }
        }
        System.out.println("An Error occured");
        return null;
    }

}
