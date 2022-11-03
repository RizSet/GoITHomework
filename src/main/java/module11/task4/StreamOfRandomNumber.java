package module11.task4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfRandomNumber {
    public static void main(String[] args) {
        int c = 11;
        int m = 2^48;

        List<Long> result = random(c, m, 0)
                .collect(Collectors.toList());

        System.out.println("result = " + result);
    }

    public static Stream<Long> random (int c, int m, long seed){
        long  a = 25_214_903_917L;
        return Stream.iterate(seed, x -> (x * a + c) % m)
                .limit(10);


    }
}
