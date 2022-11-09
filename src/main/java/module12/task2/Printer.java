package module12.task2;

import java.util.concurrent.BlockingQueue;

public class Printer implements Runnable{
    private int n;
    private BlockingQueue<String> result;

    Printer(int n, BlockingQueue<String> result){
        this.n = n;
        this.result = result;
    }
    @Override
    public void run() {
        while (n != 0){
            if (!result.isEmpty()){
                System.out.println(result.poll());
                n--;
            }
        }
    }
}
