package module13.task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class RequestMethodsTests {
    private static String url ="https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//            RequestMethods.sendPost(url, gson.toJson(new NewObjectToPostMethod()));
            RequestMethods.sendPut(url, 1, gson.toJson(new NewObjectToPostMethod()));
//            RequestMethods.sendDelete(url, 1);
//            RequestMethods.sendGetAll(url);
//            RequestMethods.sendGetOneId(url, 1);
//        RequestMethods.sendGetOneName(url, "Bret");
    }
}
