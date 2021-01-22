import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class viewScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static String next() {
        scanner.reset();
        return scanner.next();
    }

    public static Set<String> nextSetString() throws NumberFormatException {
        scanner.reset();
        String textReceived = scanner.next().replaceAll("\\p{Z}", "");
        int numberReceived = Integer.parseInt(textReceived);
        return new LinkedHashSet<>(Arrays.asList(textReceived.split("")));
    }
}
