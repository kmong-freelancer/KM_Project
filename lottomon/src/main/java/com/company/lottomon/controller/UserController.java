package com.company.lottomon.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.lottomon.common.Constant;
import com.company.lottomon.common.Constant.ServiceResult;
import com.company.lottomon.model.UserInfo;
import com.company.lottomon.result.LMServiceParam;
import com.company.lottomon.service.UserService;

@Controller
@Component
public class UserController {
	
	@Autowired
	@Resource(name = "userService")
	private UserService userService;
	
	/**
     * 회원 가입 최종
     */
    @RequestMapping(value = "/user/join.do", method = RequestMethod.POST)
	public @ResponseBody ServiceResult smsCert(@RequestBody LMServiceParam<UserInfo> param, HttpServletRequest request, HttpSession session) {
    	try {
    		System.out.println(param.getData().getName());
    		
    		userService.insertUser(param.getData());
    		
		} catch (Exception e) {
			
			e.printStackTrace();
			return ServiceResult.FAIL;
			// TODO: handle exception
		}
    	
		return ServiceResult.SUCCESS;
	}
    
    
}