package module11.task1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Numbering {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Dima", "Vania", "Petya", "Dasha", "Liza");
        System.out.println(nameNumbering(names));

    }

    public static String nameNumbering(List<String> names) {
        AtomicInteger number = new AtomicInteger(1);
        AtomicInteger index = new AtomicInteger(1);

        return names.stream()
                .filter(name -> number.getAndIncrement() % 2 != 0)
                .map(name -> index.getAndAdd(2) + ". " + name)
                .collect(Collectors.joining(", "));
    }
}
