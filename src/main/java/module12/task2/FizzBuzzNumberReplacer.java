package module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class FizzBuzzNumberReplacer {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    BlockingQueue<String> result = new LinkedBlockingQueue<>();
    AtomicBoolean isReplacing = new AtomicBoolean(false);



    public void replace(int n) {
        executor.execute(new Printer(n, result));

        int j = 1;

        while (j <= n) {
            if (!isReplacing.get()) {
                isReplacing.set(true);
                if (j % 5 != 0 && j % 3 != 0) {
                    executor.execute(new CommonNumber(j, result, isReplacing));
                    j++;
                    continue;
                }
                if (j % 5 == 0 && j % 3 == 0) {
                    executor.execute(new FizzBuzz(result, isReplacing));
                    j++;
                    continue;
                }
                if (j % 5 == 0) {
                    executor.execute(new Buzz(result, isReplacing));
                    j++;
                    continue;
                }
                if (j % 3 == 0) {
                    executor.execute(new Fizz(result, isReplacing));
                    j++;
                    continue;
                }

            }
        }
    }
}
