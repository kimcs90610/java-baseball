package domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;
    public Balls(List<String> ballVaule) {

        this.balls = generateBalls(ballVaule);
    }

    private List<Ball> generateBalls(List<String> ballVaule) {

        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < ballVaule.size(); i++) {
            balls.add(new Ball(Integer.parseInt(ballVaule.get(i)), i + 1));
        }
        return balls;
    }

    public BaseballResult compareBall(Ball userBall) {

        return this.balls.stream()
                .map(ball -> ball.compare(userBall))
                .filter(baseballResult -> !baseballResult.equals(BaseballResult.NOTHING))
                .findFirst()
                .orElse(BaseballResult.NOTHING);
    }

    // 1, return type
    // 2. 내부 로직
    public List<BaseballResult> compareBalls(Balls userBalls) {
        List<BaseballResult> result = new ArrayList<>();

        for (Ball ball : this.balls) {
            result.add(userBalls.compareBall(ball));
        }

        return result;
    }
}
