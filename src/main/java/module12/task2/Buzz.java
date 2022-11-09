package module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Buzz implements Runnable {
    private BlockingQueue<String> result;
    private AtomicBoolean isReplacing;


    public Buzz(BlockingQueue<String> result, AtomicBoolean isReplacing) {
        this.result = result;
        this.isReplacing = isReplacing;
    }

    @Override
    public void run() {
        result.add("buzz");
        isReplacing.set(false);
    }
}
