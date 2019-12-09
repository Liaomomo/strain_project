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
		System.out.println("�����̨��");
		ModelAndView mv=new ModelAndView("/main.jsp");
		List<Map> lm=userService.getUserList(null);
		mv.addObject("userlist",lm);
		mv.addObject("object","����");
		return mv;
	}
	
	@RequestMapping("/getusersparam")     //����·��   
	@ResponseBody    //����json��ʽ����
	public List<Map> getUserListParam(@RequestBody Map parms)
	{
		System.out.println("��ʼ��ѯ���ݣ�"+parms); 	
		List<Map> lm=userService.getUserListParams(parms); 	
		return lm;   //��������
	}
	
	@RequestMapping("/test")
    public ModelAndView testMVC() {
        System.out.println("�����̨��");
        ModelAndView modelAndView = new ModelAndView("/index.jsp");
        modelAndView.addObject("info", "����");
        return modelAndView;
    }
}
