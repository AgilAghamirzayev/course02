package l19.fileio.practice2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeExample {
    public static void main(String[] args) throws Exception {
        User user1 = new User(2L, "agil", "agil@mail.com");
        User user2 = new User(2L, "agil", "agil@mail.com");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.txt", true));

        out.writeObject(user1);
        out.writeObject(user2);

        out.close();
        System.out.println("User fayla yazıldı.");
    }
}