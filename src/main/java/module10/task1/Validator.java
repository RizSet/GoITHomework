package module10.task1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public void printValidNumber(File file) {
        try (InputStream fis = new FileInputStream(file);
             Scanner s = new Scanner(fis))
        {
            Pattern pattern = Pattern.compile("^(([(]\\d{3}[)]\\s)|(\\d{3}[-]))+\\d{3}-\\d{4}");
            Matcher matcher;
            String number;

            while (s.hasNext()) {

                number = s.nextLine();
                matcher = pattern.matcher(number);
                if (matcher.find()){
                    System.out.println(number);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
