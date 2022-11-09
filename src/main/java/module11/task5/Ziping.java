package module11.task5;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ziping {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 3, 4);
        Stream<Integer> second = Stream.of(25,26,27,1, 3, 4, 5, 6,7,8,9,0,10);

        List<Integer> list = zip(first, second).collect(Collectors.toList());
        System.out.println(list);
        Object o = new Object();
    }


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Spliterator<T> secondSpliterator = second.spliterator();
        Iterator<T> secondIterator = Spliterators.iterator(secondSpliterator);
        Stream<T> resultStream = first.flatMap(x -> secondIterator.hasNext() ?
                Stream.of(x, secondIterator.next()) : Stream.of());


        long size = secondSpliterator.getExactSizeIfKnown();
        System.out.println(size);
        return resultStream;
    }
}
