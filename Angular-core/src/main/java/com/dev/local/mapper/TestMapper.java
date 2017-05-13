package com.dev.local.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.dev.local.entity.TestInfo;

public interface TestMapper {
	public List<TestInfo> getTestByTestid(@Param("testName")String testName);
}
