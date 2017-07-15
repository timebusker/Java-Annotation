package cn.timebusker.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
/**
 * @Target：设定注解的作用域：
 * TYPE声明在类上或枚举上或者是注解上
 * FIELD声明在字段上
 * METHOD声明在方法上
 * PARAMETER声明在形参列表中
 * CONSTRUCTOR声明在构造方法上
 * LOCAL_VARIABLE声明在局部变量上
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PACKAGE})
/**
 * @Retention：注解保留时期
 * SOURCE：编译时注解，只在源码时期存在，编译成.class文件就不存在
 * CLASS：编译时注解，注解在源码时期和.class文件中都存在，运行时没起作用。例如：@Override、@Suppvisewarning、@Deprecated
 * RUNTIME：运行时注解,在代码运行时期还起作用，也就是一直保留, 通常也都用这个，例如：@Autowired
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * @Inherited：声明允许被标注的类可以在子类继承该注解
 */
@Inherited
/**
 * @Documented:声明在生成javadoc文档时会生成该注解的文档内容
 */
@Documented
/**
 * @interface : 使用该类型声明一个注解
 */
public @interface Timebusker {
	/**
	 * 声明成员：
	 * 
	 * 成员以无参数、无异常的方式声明：public abstract String value() default "";
	 * 
	 * 可以使用 default 为成员指定默认属性值
	 * 
	 * 成员类型是受限制的，合法的数据类型包括
	 *                      基本数据类型：数值型（整数：byte、short、int、long；浮点类型：float、double）
	 *                                 字符型：char
	 *                                 布尔类型：boolean
	 *                      额外类型：String、Class、Annotation、Enumeration
	 *                      
	 * 如果注解只有一个成员，则成员名称必须为value(),在使用时可以忽略成员名称和赋值等号（=）
	 * 
	 * 注解可以没有成员，没有成员的注解称为标志注解
	 */
	
    public enum MethodType {
    	GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
    }
    
	@AliasFor("name")
	String[] value() default {};
	
	@AliasFor("value")
    String[] name() default {};
    
    boolean islog() default true;
    
    MethodType method() default MethodType.GET;
    
    String description() default "";
    
}