package module13.task3;

import java.io.IOException;
import java.util.List;

public class ManagerTaskTest {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com";
        int idUser = 1;
        ManagerTask managerTask = new ManagerTask();
        List<Task> openTask;
        try {
            openTask = managerTask.getOpenTask(idUser, url);
        } catch (IOException|InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Task task : openTask) {
            System.out.println(task);
        }

    }
}
