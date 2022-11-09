package module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Fizz implements Runnable {
    private BlockingQueue<String> result;
    private AtomicBoolean isReplacing;


    public Fizz(BlockingQueue<String> result, AtomicBoolean isReplacing) {
        this.result = result;
        this.isReplacing = isReplacing;
    }

    @Override
    public void run() {
        result.add("fizz");
        isReplacing.set(false);
    }
}