package module11.task5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ziping {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 2, 3, 4);
        Stream<Integer> second = Stream.of(5, 6, 7, 8, 9);

        List<Integer> list = zip(first, second).collect(Collectors.toList());
        System.out.println(list);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> a = first.iterator();
        Iterator<T> b = second.iterator();
        List<T> result = new ArrayList<>();
        while (a.hasNext() && b.hasNext()){
            result.add(a.next());
            result.add(b.next());
        }
        return result.stream();
    }

}
