package module10.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Counter {
    private File file;

    public Counter(String pathToFile) {
        this.file = new File(pathToFile);
    }

    public void frequencyEachWord() {

        Map<String, Integer> map = new HashMap<>();

        String currentWord;

        try (InputStream fis = new FileInputStream(file);
             Scanner s = new Scanner(fis)) {
            while (s.hasNext()) {
                currentWord = s.next();

                if (!map.containsKey(currentWord)) {
                    map.put(currentWord, 1);
                }else {
                    map.put(currentWord, map.get(currentWord) + 1);
                }
            }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<String, Integer> treeMap = new TreeMap<>(new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) < map.get(o2) ? 1 : -1;
            }
        });
        treeMap.putAll(map);

        for ( Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
    }
}
