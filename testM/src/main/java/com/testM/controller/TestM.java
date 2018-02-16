package com.testM.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestM {
	@RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<String> getAllServerDetails() {
		List<String> str=new ArrayList<String>();
		str.add("hi");
		str.add("hello");
		System.out.println(str);
		return str;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateExportDetails(@RequestBody String json) {
		System.out.println("inside "+json);
	}

}
