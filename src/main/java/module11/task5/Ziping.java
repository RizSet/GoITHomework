package module11.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ziping {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 3, 4);
        Stream<Integer> second = Stream.of(5, 6, 7, 8, 9);

        List<Integer> list = zip(first, second).collect(Collectors.toList());
        System.out.println(list);
    }


        public static <T>Stream <T> zip(Stream <T> first, Stream <T> second) {
            List<T> a = first.collect(Collectors.toList());
            List<T> b = second.collect(Collectors.toList());

            Iterator<T> x = a.iterator();
            Iterator<T> y = b.iterator();
            StringBuilder s = new StringBuilder();

            IntStream.range(0, Math.min(a.size(), b.size()))
                    .forEach(value -> {
                        s.append(x.next()).append(" ");
                        s.append(y.next()).append(" ");
                    });

            return Arrays.stream(s.toString().split(" ")).map(value -> (T) value);
        }
}
