package cn.timebusker.service.Impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.timebusker.annotation.Timebusker;
import cn.timebusker.service.UserInfoService;

@Service
@Timebusker("this is class")
public class UserInfoServiceImpl implements UserInfoService {

	private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Override
	@Timebusker("this is method")
	public String addUserInfo(String name) {
		logger.info("新增的用户姓名是：" + name);
		return name + "\t当前时间为：\t" + new Date();
	}
}