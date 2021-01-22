package domain;


import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;
    public Balls(List<String> ballValue) {
        this.balls = generateBalls(ballValue);
    }

    private List<Ball> generateBalls(List<String> ballValue) {

        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < ballValue.size(); i++) {
            balls.add(new Ball(Integer.parseInt(ballValue.get(i)), i + 1));
        }
        return balls;
    }

    public BaseballResult compareBall(Ball userBall) {
        List<BaseballResult> resultList = new ArrayList<>();

        for (Ball ball : this.balls) {
            resultList.add(ball.compare(userBall));
        }

        return findUserResult(resultList);

        /*BaseballResult result = BaseballResult.NOTHING;

        if (!this.balls.get(0).compare(userBall).equals(result)) {
            return result = this.balls.get(0).compare(userBall);
        }
        if (!this.balls.get(1).compare(userBall).equals(result)) {
            return result = this.balls.get(1).compare(userBall);
        }
        if (!this.balls.get(2).compare(userBall).equals(result)) {
            return result = this.balls.get(2).compare(userBall);
        }

        return result;*/

/*        return this.balls.stream()
                .map(ball -> ball.compare(userBall))
                .filter(baseballResult -> !baseballResult.equals(BaseballResult.NOTHING))
                .findFirst()
                .orElse(BaseballResult.NOTHING);*/
    }

    private BaseballResult findUserResult(List<BaseballResult> resultList) {
        if (resultList.contains(BaseballResult.STRIKE)) {
            return BaseballResult.STRIKE;
        }

        if (resultList.contains(BaseballResult.BALL)) {
            return BaseballResult.BALL;
        }

        return BaseballResult.NOTHING;
    }

    // 1, return type
    // 2. 내부 로직
    public List<BaseballResult> compareBalls(Balls userBalls) {
        List<BaseballResult> result = new ArrayList<>();

        for (Ball ball : userBalls.balls) {
            result.add(this.compareBall(ball));
        }

        return result;
    }

}
