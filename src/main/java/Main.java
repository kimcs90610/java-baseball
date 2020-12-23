import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            numberList.add(i);
        }

        System.out.println(numberList);

        Collections.shuffle(numberList);

        System.out.println(numberList);

        Scanner sc = new Scanner(System.in);

        int baseNumber = sc.nextInt();

        System.out.println(baseNumber);
    }
}
