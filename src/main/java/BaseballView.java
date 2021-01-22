import domain.Balls;
import domain.BaseballResult;
import domain.RestartNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BaseballView {

    private Set<String> numberSetReceived;
    private Balls userBalls;
    private String restartGameNumber;

    public BaseballView() {
        this.restartGameNumber = RestartNumber.DEFAULT_START.getRestartNumber();
    }

    public String getRestartGameNumber() {
        return this.restartGameNumber;
    }

    public Set<String> getNumberReceived() {
        return this.numberSetReceived;
    }

    public Balls getUserBalls() {
        return this.userBalls;
    }

    public void init() {
        viewPrinter.print("숫자를 입력해주세요 : ");
        this.receivedInputNumber();
        this.userBalls = new Balls(new ArrayList<>(numberSetReceived));
    }

    private void receivedInputNumber() {
        try {
            this.numberSetReceived = viewScanner.nextSetString();
        } catch (NumberFormatException e) {
            viewPrinter.print("숫자만 입력할 수 있습니다.");
            this.init();
        }
        this.checkValidation();
    }

    private void checkValidation() {
        if (this.numberSetReceived.contains("0")) {
            viewPrinter.print("0은 포함될 수 없습니다.");
            this.init();
            return;
        }
        if (this.numberSetReceived.size() != 3) {
            viewPrinter.print("서로 다른 3자리 수를 입력해주세요.");
            this.init();
        }
    }

    public boolean restartCheck(List<BaseballResult> result) {
        if (Collections.frequency(result, BaseballResult.STRIKE) == 3) {
            viewPrinter.print("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            viewPrinter.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            this.whetherToRestart();
        }

        return !this.restartGameNumber.equals(RestartNumber.DONT_START_GAME.getRestartNumber());
    }

    private void whetherToRestart() {
        this.restartGameNumber = viewScanner.next();

        if (!RestartNumber.RESTART_GAME.getRestartNumber().equals(this.restartGameNumber)
                && !RestartNumber.DONT_START_GAME.getRestartNumber().equals(this.restartGameNumber)) {
            viewPrinter.print("잘못 입력하셨습니다.");
            this.whetherToRestart();
        }
    }
}
