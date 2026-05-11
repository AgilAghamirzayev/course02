package l19.fileio.practice2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeExample {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.txt"));

        User user1 = (User) in.readObject();
        User user2 = (User) in.readObject();
        User user3 = (User) in.readObject();
        in.close();

        System.out.println(user1);
        System.out.println(user2);
//        System.out.println(user3);
    }
}