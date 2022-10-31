package module10.task2;

import java.io.File;
import java.io.IOException;

public class UserTest {
    public static void main(String[] args) {
        try {
             File json = new File("src\\main\\java\\module10\\task2\\user.json");
            json.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonUser ju = new JsonUser("src\\main\\java\\module10\\task2\\file.txt", "src\\main\\java\\module10\\task2\\user.json");
        ju.createJsonFromList();
    }

}
