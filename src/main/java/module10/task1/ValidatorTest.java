package module10.task1;

import java.io.File;

public class ValidatorTest {
    public static void main(String[] args) {
        Validator validator = new Validator();
        File file = new File("src\\main\\java\\module10\\task1\\file.txt");
        validator.printValidNumber(file);
    }
}
