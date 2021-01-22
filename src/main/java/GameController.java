import domain.Balls;
import domain.BaseballGameResult;
import domain.RestartNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController {

    public boolean isStart;
    private Balls comBalls;

    public GameController() {
        this.isStart = true;
        this.initComBalls();
    }

    public void baseBallGameStart() {

        while(this.isStart) {
            BaseballView baseballView = new BaseballView();

            baseballView.init();

            BaseballGameResult baseballGameResult = new BaseballGameResult(this.comBalls.compareBalls(baseballView.getUserBalls()));

            viewPrinter.printBaseballResult(baseballGameResult);

            this.restartCheck(baseballView, baseballGameResult);
        }
    }

    private void restartCheck(BaseballView baseballView, BaseballGameResult baseballGameResult) {
        this.isStart = baseballView.restartCheck(baseballGameResult.getResult());

        if (RestartNumber.RESTART_GAME.getRestartNumber().equals(baseballView.getRestartGameNumber())) {
            initComBalls();
        }
    }

    private void initComBalls() {
        List<String> numberList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Collections.shuffle(numberList);

        this.comBalls = new Balls(numberList.subList(0, 3));
    }
}
