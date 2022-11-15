package module13.task2;

import java.io.IOException;

public class CommentResercherTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com";
        int idUser = 4;
        int idPost = CommentResearcher.getIdLastPost(idUser, url);
        CommentResearcher.printCommentsToFile(idUser, idPost, url);


    }
}
