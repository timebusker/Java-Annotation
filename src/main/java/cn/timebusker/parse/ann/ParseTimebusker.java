package cn.timebusker.parse.ann;

import java.lang.reflect.Method;

import cn.timebusker.annotation.Timebusker;
import cn.timebusker.service.UserInfoService;
import cn.timebusker.service.Impl.UserInfoServiceImpl;

/**
 * 解析@timebusker注解
 * 通过反射获取类、方法或者成员上的运行时注解信息，从而实现动态控制程序运行时的逻辑
 * 
 */
public class ParseTimebusker {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 加载类信息:获取calss，方法不一
		UserInfoService service = new UserInfoServiceImpl();
		Class c = service.getClass();
		// 获取类上的注解
		boolean isann = c.isAnnotationPresent(Timebusker.class);
		if(isann){
			Timebusker timebusker = (Timebusker) c.getAnnotation(Timebusker.class);
			System.out.println(timebusker.value()[0]);
		}
		// 获取方法上的注解
		Method[] ms = c.getMethods();
		for (Method m : ms) {
			boolean exist = m.isAnnotationPresent(Timebusker.class);
			if (exist) {
				Timebusker timebusker = (Timebusker) m.getAnnotation(Timebusker.class);
				System.out.println(timebusker.value()[0]);
			}
		}
		
	}
}
