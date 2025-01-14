package racingcar.domain;

import racingcar.util.GoForward;
import racingcar.util.MoveStrategy;
import racingcar.util.Stop;

import java.util.Objects;

import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

public class Car {

    public static final int START_POSITION = 1;
    public static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;
    private int position;

    private Car(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name.trim();
        this.position = START_POSITION;
    }

    public static Car of(final String name) {
        return new Car(name);
    }


    public void move(int speed) {
        MoveStrategy moveStrategy = chooseStrategy(speed);
        position += moveStrategy.move();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    private void validateNameLength(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }

    private MoveStrategy chooseStrategy(int speed) {
        if (speed >= 4) {
            return new GoForward();
        }
        return new Stop();
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
