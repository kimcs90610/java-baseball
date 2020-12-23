package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {


    // 게임 로직 -> 랜덤 3자리 ,,, 유저 3개 입력 3/ 3 비교 결과
    // 총 3개 / 3개 숫자가 다 동일해야

    // 123, 123 -> 비교
    // 단위 테스트
    // 단위 다 짜르는거야
    // 123 324 비교, 동시 3개를 다 비교?
    // 한자리 한자리.
    // 즉 단위는 1자리
    // com: 1, user: 3 -> result = S가 아니다.
    // com: 1, user: 1 -> ball? Strike? 숫자를 비교하는데 자리수 필요해

    // class -> postion, value
    // 123 (123), 325(123)
    // (1,1) // (3,1) 를 비교 -> no
    // 2,2 // 2,2 => S
    // 3가지
    // n, b,s -> 1, 1 => 3가지
    // n: v, p x
    // b: v o , p x
    // s: v o , p o
    private  Ball comBall;

    @BeforeEach
    void init() {
        comBall = new Ball(3, 1);
    }

    @Test
    @DisplayName("Noting test")
    void baseballTest() {
        // 3,1

        Ball userBall = new Ball(4,1);

        // TDD 중요한점
        // 모든 코딩 시작 test 코드에서 시작해
        assertThat(comBall.compare(userBall)).isEqualTo(BaseballResult.NOTHING);
    }

    @Test
    @DisplayName("Ball Test")
    void ballTest() {

        Ball userBall = new Ball(3, 2); //value == value, posiont x
        assertThat(comBall.compare(userBall)).isEqualTo(BaseballResult.BALL);
    }

    @Test
    @DisplayName("Strike Test")
    void strikeTest() {
        Ball userBall = new Ball(3, 1);
        assertThat(comBall.compare(userBall)).isEqualTo(BaseballResult.STRIKE);
    }

    // nextLevel
    // 그 다음은 어떤 테스트 코드를 짤까?
    // Test code // MVC model
    // Controller => M (domaion), View // 2개를 제어 하는
    // view 제일 마지막
    // domain 로직 -> 로직 결과만 view
    
}