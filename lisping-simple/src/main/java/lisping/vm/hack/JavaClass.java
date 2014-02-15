package lisping.vm.hack;

/**
 * 一个类型的包装对象.
 * 
 * Class 对象表示 `abc.Abc.class`, JavaClass 对象表示 `abc.Abc`.
 * 
 * 对这个对象的成员访问, 将变成访问 clazz 表示的类的成员. 
 */
public class JavaClass {

	public static final String CLASS = "class";
	
	private Class<?> clazz;

	public JavaClass(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Class<?> getClazz() {
		return clazz;
	}

}
