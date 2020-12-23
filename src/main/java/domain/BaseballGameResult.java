package domain;

import java.util.List;

public class BaseballGameResult {

    private List<BaseballResult> result;

    public BaseballGameResult(List<BaseballResult> compareBalls) {
        this.result = compareBalls;
    }

    public List<BaseballResult> getResult() {
        return this.result;
    }
}
