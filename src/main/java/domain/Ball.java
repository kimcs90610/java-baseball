package domain;

public class Ball {
    private final int position;
    private final int value;

    public Ball(int value, int position) {

        this.value = value;
        this.position = position;
    }

    // 상태를 3가지
    // Noting, Ball, Strike =>
    public BaseballResult compare(Ball userBall) {
        // return s
        // return b

        return BaseballResult.NOTHING;
    }
}
