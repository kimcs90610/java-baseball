package domain;

import java.util.Collections;
import java.util.List;

public class BaseballGameResult {

    private final List<BaseballResult> result;
    public final int strikeCount;
    public final int ballCount;
    public final int nothingCount;

    public BaseballGameResult(List<BaseballResult> resultList) {
        this.result = resultList;
        this.strikeCount = Collections.frequency(resultList, BaseballResult.STRIKE);
        this.ballCount = Collections.frequency(resultList, BaseballResult.BALL);
        this.nothingCount = Collections.frequency(resultList, BaseballResult.NOTHING);
    }

    public List<BaseballResult> getResult() {
        return this.result;
    }
}
