package cn.timebusker.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 面向切面编程 主要功能：日志记录、性能统计、安全控制、事务处理、异常处理等等
 */
@Component
@Aspect
// 使用 order对多个切面进行排序,参数越小，越在前
@Order(1)
public class LoggerAopHandler {

	private final static Logger logger = LoggerFactory.getLogger(LoggerAopHandler.class);

	/**
	 * AOP切面中的同步问题：用于监控业务处理性能
	 */
	ThreadLocal<Long> startTime = new ThreadLocal<>();

	// 匹配 自定义注解标注的类----注解标注在接口的方法上不起作用
	@Pointcut(value = "@annotation(cn.timebusker.annotation.timebuskerMethod)")
	public void log() {
		logger.info("\t\t@annotation(cn.timebusker.annotation.timebuskerMethod)");
	}
}
