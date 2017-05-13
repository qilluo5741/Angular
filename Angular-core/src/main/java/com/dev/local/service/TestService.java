package com.dev.local.service;

import java.util.List;

import com.dev.local.entity.TestInfo;

public interface TestService {
	public List<TestInfo> getTestByTestid(String testName);
}
