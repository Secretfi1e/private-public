public class Bank {
    private int size = 0;
    private User[] users;


    public Bank(int capacity) {
        users = new User[capacity];
        size = 0;
    }


    public User[] getusers() {
        return users;
    }

    public void setusers(User[] users) {
        this.users = users;
    }

    public int getsize() {
        return size;
    }


    public void addUser(User user) {
        users[size++] = user;
    }
    public void setsize(int size) {
        this.size = size;
    }

    public User[] getAllUsers() {
        User[] allUser = new User[size];
        for (int i = 0; i < size; i++) {
            allUser[i] = users[i];
        }
        return allUser;
    }

    public User getUserById(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    public void updateUserById(int id, User user) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                users[i] = user;
                break;
            }
        }
    }

    public void removeUserById(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    users[j] = users[j + 1];
                }
                size--;
                break;
            }
        }
    }
}