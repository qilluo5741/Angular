package com.dev.local.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dev.local.entity.TestInfo;
import com.dev.local.service.TestService;
import com.dev.local.util.ResultDto;

@Controller
@RequestMapping("/test")
public class TestController {
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private TestService TestService;
	/**
	 * test/getTestByTestid?testName=admin
	 * @param session
	 * @param testName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getTestByTestid",method=RequestMethod.POST)
    public ResultDto getTestByTestid(HttpSession session,String testName){
		if(testName==null && testName==null){
			//返回给请求者
			return new ResultDto(3000,"请求参数为空！");
		}
		try {
			List<TestInfo> test=TestService.getTestByTestid(testName);
			if(test!=null){
				return new ResultDto(200,"成功",test);
			}
		} catch (Exception e) {
			log.info("操作繁忙!请稍后再试！");
			System.out.println("操作繁忙!请稍后再试！");
		}
		return new ResultDto(201,"操作繁忙!请稍后再试！");
	}
}
