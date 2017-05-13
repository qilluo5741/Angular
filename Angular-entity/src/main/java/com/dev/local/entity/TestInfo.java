package com.dev.local.entity;

import java.io.Serializable;

public class TestInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String testId;
	private String testName;
	private String testSex;
	private String testTime;

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestSex() {
		return testSex;
	}

	public void setTestSex(String testSex) {
		this.testSex = testSex;
	}

	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
}
