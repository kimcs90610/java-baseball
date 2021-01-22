import domain.BaseballGameResult;

public class viewPrinter {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printBaseballResult(BaseballGameResult baseballGameResult) {
        String message = "";
        message = (baseballGameResult.nothingCount == 3) ? "낫싱" : "";
        message += (baseballGameResult.strikeCount > 0) ? (baseballGameResult.strikeCount + " 스트라이크 ") : "";
        message += (baseballGameResult.ballCount > 0) ? (baseballGameResult.ballCount + " 볼") : "";
        print(message);
    }

}
