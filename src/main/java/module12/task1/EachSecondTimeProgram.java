package module12.task1;

public class EachSecondTimeProgram implements Runnable{

    private long current = 1;


    @Override
    public void run() {
        System.out.println(current++);
;
    }
}
