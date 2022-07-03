import java.io.IOException;
import java.util.Scanner;

import static com.movchan.cities.CitiesUntil.*;
import static com.movchan.factorial.FactorialUtil.*;
import static com.movchan.expression.ExpressionUtil.*;

public class Main {

    public static final String OPTIONS = "Please choose the exercise 1, 2 or 3, or write \"exit\" to exit: ";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(OPTIONS);
        while (scanner.hasNext()){
            String scannerStr = scanner.nextLine();
            if (scannerStr.equals("exit")) return;
            switch (scannerStr) {
                case "1":
                    runFactorialTask(scanner);
                    System.out.print(OPTIONS);
                    break;
                case "2":
                    runCitiesTask();
                    System.out.println(OPTIONS);
                    break;
                case "3":
                    runExpressionTask(scanner);
                    System.out.print(OPTIONS);
                    break;
                default:
                    System.out.println(OPTIONS);
                    break;
            }
        }
    }
}
