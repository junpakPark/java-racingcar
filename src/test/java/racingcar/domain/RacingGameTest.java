package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    @DisplayName("주어진 이름대로 자동차 생성되는지 테스트")
    @Test
    void 자동차_생성되는지() {
        List<String> names = Arrays.asList("a","b","c");
        RacingGame racingGame = new RacingGame();
        racingGame.makeCars(names);
        List<Car> cars = racingGame.getCars();
        for (int i = 0; i < names.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(names.get(i));
        }
    }
}