package module10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonUser {
    private List<User> users = new ArrayList<>();
    private String list;
    private File json;
    private String name;
    private int age;
    private String nameOfColums[] = new String[2];

    public JsonUser(String list, String json) {
        this.list = list;

        try {
            this.json = new File(json);
            this.json.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createJsonFromList() {
        users = createListFormFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(users);


        try (OutputStream fos = new FileOutputStream(json)) {
            fos.write(jsonString.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<User> createListFormFile() {

        try (InputStream fis = new FileInputStream(list);
             Scanner s = new Scanner(fis)) {

            nameOfColums[0] = s.next();
            nameOfColums[1] = s.next();

            while (s.hasNext()) {
                if (nameOfColums[0].equals("name") && nameOfColums[1].equals("age")) {
                    name = s.next();
                    age = Integer.valueOf(s.next());
                    users.add(new User(name, age));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
