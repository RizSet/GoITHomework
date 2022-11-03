package module11.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Sort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dima", "Vania", "Petya", "Dasha", "Liza");
        System.out.println(sortedList(names));

    }

    public static List<String> sortedList (List<String> names){
        return names.stream()
                .sorted((n1, n2) -> n2.compareToIgnoreCase(n1))
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
    }


}
