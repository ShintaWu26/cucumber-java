package tia.quiz.utils;

public enum TestScenarios {
	T1("Valid Login");
	
	private String testName;
	TestScenarios(String value){
		testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
