package cn.timebusker.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.timebusker.annotation.Timebusker;
import cn.timebusker.entity.RequestLogEntity;

import com.alibaba.fastjson.JSON;

/**
 * 通过拦截器，拦截所有的请求
 * 解析自定义注解
 */
public class WebRequestInterceptor implements HandlerInterceptor {

	private final static Logger logger = LoggerFactory.getLogger(WebRequestInterceptor.class);

	/**
	 * 在请求已经返回之后执行 整个请求处理完毕回调方法，即在视图渲染完毕时调用
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
		// TODO Auto-generated method stube
		logger.info("在请求已经返回之后执行:\t整个请求处理完毕回调方法，即在视图渲染完毕时调用");
		// logger.info("\n\n\n\n");
		// logger.info(JSON.toJSONString(handler));
		// logger.info("\n\n\n\n");
	}

	/**
	 * 执行目标方法之后执行
	 * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时可以通过ModelAndView对模型数据进行处理或对视图进行处理
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
		// TODO Auto-generated method stub
		logger.info("执行目标方法之后执行:\t后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时可以通过ModelAndView对模型数据进行处理或对视图进行处理");
		// logger.info("\n\n\n\n");
		// logger.info(JSON.toJSONString(handler));
		// logger.info("\n\n\n\n");
	}

	/**
	 * 在执行目标方法之前执行 若方法返回值为true，请求继续（调用下一个拦截器或处理器方法）；若方法返回值为false，请求处理流程中断，
	 * 不会继续调用其他的拦截器或处理器方法，此时需要通过response产生响应；
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		logger.info("在执行目标方法之前执行:\t若方法返回值为true，请求继续（调用下一个拦截器或处理器方法）；若方法返回值为false，请求处理流程中断，不会继续调用其他的拦截器或处理器方法，此时需要通过response产生响应；");
		logger.info("\n\n\n\n");
		logger.info(JSON.toJSONString(handler));
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			logger.info(JSON.toJSONString(method));
			// 判断是否存在注解
			// boolean exist = method.isAnnotationPresent(Timebusker.class);
			// 直接获取注解
			Timebusker timebusker = method.getAnnotation(Timebusker.class);
			if (timebusker == null) {
				logger.info("该方法不存在该注解！");
			}
			Map<String, String[]> params = request.getParameterMap();
			RequestLogEntity rle = new RequestLogEntity();
			rle.setRequestCategory(timebusker.method().toString());
			rle.setRequestDesc(timebusker.description());
			rle.setRequestParams(JSON.toJSONString(params));
			rle.setRequestType(timebusker.method().toString());
			rle.setRequestUrl(JSON.toJSONString(timebusker.value()));
			logger.info(JSON.toJSONString(rle));
		}
		logger.info("\n\n\n\n");
		return true;
	}

}
