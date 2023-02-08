package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.InputUtil;

public class RaceController implements Controller {

    private final InputUtil inputUtil = new InputUtil();

    @Override
    public void process() {
        Cars cars = inputUtil.getUserInput(inputUtil::getCarNames);
    }
}