package module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommonNumber implements Runnable {

    int j;
    private BlockingQueue<String> result;
    private AtomicBoolean isReplacing;

    public CommonNumber(int j, BlockingQueue<String> result, AtomicBoolean isReplacing) {
        this.j = j;
        this.result = result;
        this.isReplacing = isReplacing;
    }

    @Override
    public void run() {
        result.add(String.valueOf(j));
        isReplacing.set(false);
    }
}
