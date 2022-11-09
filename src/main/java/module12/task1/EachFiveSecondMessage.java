package module12.task1;

public class EachFiveSecondMessage implements Runnable{
    @Override
    public void run() {
        System.out.println("5 second have passed");
    }
}
