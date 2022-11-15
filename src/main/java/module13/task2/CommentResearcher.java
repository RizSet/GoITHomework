package module13.task2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CommentResearcher {




    public static String getComments(int id, String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/posts/" + id + "/comments"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


    public static int getIdLastPost(int usersId, String url) throws IOException, InterruptedException {
        return getPosts(usersId, url).stream()
                .max((post1, post2) -> post1.getUserId() - post2.getId())
                .get()
                .getId();

    }

    public static List<Post> getPosts(int usersId, String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/users/" + usersId + "/posts"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();

        List<Post> posts = new Gson().fromJson(response.body(), type);

        return posts;

    }


    public static void printCommentsToFile(int idUser, int idPost, String url) throws IOException, InterruptedException {
        System.out.println("getComments(id, url) = " + getComments(idPost, url));
        try (FileWriter fw = new FileWriter("user-" + idUser + "-post-" + idPost + "-comments.json")) {
            fw.write(getComments(idPost, url));
        }catch (Exception e){
        }
    }
}
