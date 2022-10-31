package module10.task3;

public class CounterTest {
    public static void main(String[] args) {
        Counter counter = new Counter(".\\src\\main\\java\\module10\\task3\\words.txt");
        counter.frequencyEachWord();
    }

}
