package domain;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int value;

    public Ball(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public int getValue() {
        return this.value;
    }

    // 상태를 3가지
    // Noting, Ball, Strike =>
    public BaseballResult compare(Ball userBall) {

        if (this.equals(userBall)) {
            return BaseballResult.STRIKE;
        }

        if (this.value == userBall.value) {
            return BaseballResult.BALL;
        }

        return BaseballResult.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, value);
    }
}
