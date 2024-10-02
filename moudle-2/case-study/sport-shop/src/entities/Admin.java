package entities;

public class Admin {
    private static  Admin instance;
    private  String username;
    private  String password;

    private  Admin() {
        this.username =  "phuongdong";
        this.password = "admin3105";
    }

    public  static Admin getInstance() {
        if ( instance == null) {
            instance = new Admin();
        }
        return  instance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

