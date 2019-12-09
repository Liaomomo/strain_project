package com.qd.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qd.demo.service.UserService;

@Controller
@RequestMapping("/qd")
public class TestController {

	@Autowired
	UserService userService;
	@RequestMapping("/getusers")
	public ModelAndView getUserList()
	{
		System.out.println("进入后台！");
		ModelAndView mv=new ModelAndView("/main.jsp");
		List<Map> lm=userService.getUserList(null);
		mv.addObject("userlist",lm);
		mv.addObject("object","张三");
		return mv;
	}
	
	@RequestMapping("/getusersparam")     //访问路径   
	@ResponseBody    //返回json格式数据
	public List<Map> getUserListParam(@RequestBody Map parms)
	{
		System.out.println("开始查询数据！"+parms); 	
		List<Map> lm=userService.getUserListParams(parms); 	
		return lm;   //返回数据
	}
	
	@RequestMapping("/test")
    public ModelAndView testMVC() {
        System.out.println("进入后台！");
        ModelAndView modelAndView = new ModelAndView("/index.jsp");
        modelAndView.addObject("info", "张三");
        return modelAndView;
    }
}
