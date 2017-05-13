package com.dev.local.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.local.entity.TestInfo;
import com.dev.local.mapper.TestMapper;
import com.dev.local.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestMapper mapper;
	@Override
	public List<TestInfo> getTestByTestid(String testName) {
		return mapper.getTestByTestid(testName);
	}
}
