package fd.ng.core.annotation;

import fd.ng.core.utils.StringUtil;

import java.lang.annotation.*;


/**
 * 使用本注解的 JavaBean 可以被自动构造对象时赋值。
 * 对Action方法中JavaBean类型的参数自动赋值时使用。
 * 这个注解的Target只能到类级。不能修改为属性级、参数级！
 */
@Target({ ElementType.METHOD,ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(Params.class)
public @interface Param {
	String alias() default StringUtil.EMPTY;//该参数在 request 中对应的名字，默认为参数名
	String name();//方法的参数名称，不能为空
	boolean nullable() default false; // 该参数在 request 中是否可以不存在或为空。
	String[] valueIfNull() default {}; // 对于可空变量，赋予的默认值（因为前端提交的数据有可能是字符数组）
	boolean ignore() default false; // 是否忽略（跳过）被注解的参数
	boolean isBean() default false;//该参数是不是实体bean
	String desc();//用于描述类、方法、参数、返回值的含义
	String range();//用于描述参数和返回值的取值范围，"如：任意，4位数字，1-100之间的数字"。
	String example() default StringUtil.EMPTY;//例子数据，如10.78.90.22这样有特殊意义的数据
}
