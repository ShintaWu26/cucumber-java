package tia.quiz.drivers.strategies;

import tia.quiz.utils.Constants;

public class DriverImplementer {

	public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case Constants.CHROME:
                return new Chrome();

            case Constants.FIREFOX:
                return new Firefox();

            default:
                return null;
        }
    }
	
}
