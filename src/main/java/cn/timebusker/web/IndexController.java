package cn.timebusker.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.timebusker.annotation.Timebusker;
import cn.timebusker.annotation.Timebusker.MethodType;
import cn.timebusker.service.UserInfoService;

@RestController
public class IndexController {

	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	UserInfoService userService;

	@RequestMapping(value = { "/{name}" }, method = RequestMethod.GET)
	@Timebusker(value = { "view/aaa", "view/bbb", "view/ccc" }, description = "this is indexContrller!", method = MethodType.GET)
	public String index(@PathVariable String name) {
		name = userService.addUserInfo(name);
		logger.info("\n====================名称为\t" + name + "====================\n");
		return "我的名字是:\t" + name;
	}
	
	public String testHandler(@PathVariable String name) {
		name = userService.addUserInfo(name);
		logger.info("\n====================名称为\t" + name + "====================\n");
		return "我的名字是:\t" + name;
	}
}
