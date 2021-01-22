package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls comBalls;
    private Balls userBalls;

    @BeforeEach
    void init() {
        comBalls = new Balls(Arrays.asList("1", "2", "3"));
    }

    @Test
    @DisplayName("낫띵 테스트")
    void ballsTest(){
        // 객체 // 1급 객체
        // Ball 객체 123 1객체
        // Balls 객체 -> ball을 3개 가지고 있는 개체

        Ball userBall = new Ball(4,1);

        // 3comBalls //1 userBall
        // 누구를 기준으로 어느 객체로비교하늑네 좋을까

        // 결과가 어떻게 나올까?
        assertThat(comBalls.compareBall(userBall)).isEqualTo(BaseballResult.NOTHING); // 무조건 한가지 상태
    }

    @Test
    void 볼즈_볼_테스트() {

        Ball userBall = new Ball(3, 2);
        assertThat(comBalls.compareBall(userBall)).isEqualTo(BaseballResult.BALL);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strikeTest() {

        Ball userBall = new Ball(1,1);
        assertThat(comBalls.compareBall(userBall)).isEqualTo(BaseballResult.STRIKE);
    }

    // 1// 1
    // 1,1 // 1,1 ball

    // 123(1,2,3), 2(1)

    // 123(1,2,3), 234(1,2,3)


    @Test
    void ballsNothingTest() {

        userBalls = new Balls(Arrays.asList("4", "5", "6"));

        BaseballGameResult result = new BaseballGameResult(comBalls.compareBalls(userBalls));

        assertThat(result.getResult()).isEqualTo(Arrays.asList(BaseballResult.NOTHING, BaseballResult.NOTHING, BaseballResult.NOTHING));
    }

    @Test
    void ballsOneStrikeTest() {
        userBalls = new Balls(Arrays.asList("1", "5", "6"));

        BaseballGameResult result = new BaseballGameResult(comBalls.compareBalls(userBalls));

        assertThat(result.getResult()).isEqualTo(Arrays.asList(BaseballResult.STRIKE, BaseballResult.NOTHING, BaseballResult.NOTHING));
    }

/*    @Test
    void 투_스트라이크_테스트() {
        userBalls = new Balls(Arrays.asList("1", "2", "6"));

        BaseballGameResult result = new BaseballGameResult(comBalls.compareBalls(userBalls));

        assertThat(result.getResult()).isEqualTo(Arrays.asList(BaseballResult.STRIKE, BaseballResult.STRIKE, BaseballResult.NOTHING));
    }

    @Test
    @ParameterizedTest
    void 원_볼_테스트() {
        userBalls = new Balls(Arrays.asList("3", "4", "6"));

        BaseballGameResult result = new BaseballGameResult(comBalls.compareBalls(userBalls));

        assertThat(result.getResult()).isEqualTo(Arrays.asList(BaseballResult.NOTHING, BaseballResult.NOTHING, BaseballResult.BALL));
    }*/

}