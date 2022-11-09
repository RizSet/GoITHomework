package module12.task1;

import java.security.PublicKey;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer {

    public Timer(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(new EachSecondTimeProgram(), 1, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new EachFiveSecondMessage(), 5, 5, TimeUnit.SECONDS);
    }
}
