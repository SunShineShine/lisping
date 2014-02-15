package lisping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lisping.vm.hack.BindingMethod;
import lisping.vm.hack.JavaClass;

public class Core {

	public static Object eval(Object expr, Scope local) {
		if (!(expr instanceof EvalAware)) {
			return expr;
		}
		return ((EvalAware) expr).eval(local);
	}

	/**
	 * 获取一个对象的成员.
	 * 
	 * 如果有多个同名成员, 则报错.
	 * 
	 * TODO: 给定更多信息定位同名成员.
	 * 
	 * <p>
	 * HACK: 针对 hack.JavaClass 对象特殊处理, 参考 {@link JavaClass}.
	 * 
	 * @param obj
	 * @param name
	 * @return
	 */
	public static Object get(Object obj, Symbol symbol) {
		if (symbol == null) {
			throw new NullPointerException("symbol");
		}
		SymbolTokenizer token = new SymbolTokenizer(symbol.getName());
		while (token.hasNext()) {
			if (obj == null) {
				throw new NullPointerException("obj " + token.current());
			}
			String name = token.next();
			Class<?> clazz;
			if (obj instanceof JavaClass) {
				// drop wrapper
				clazz = ((JavaClass) obj).getClazz();
				if (name.equals(JavaClass.CLASS)) {
					obj = clazz;
					continue;
				}
			} else {
				if (obj instanceof BindingMethod) {
					// lost binding info
					obj = ((BindingMethod) obj).getMethod();
				}
				clazz = obj.getClass();
			}

			Object member = getClassMember(clazz, name);
			if (member == null) {
				throw new EvalException("no such member. class: " + clazz + ", member: " + name);
			}

			if (member instanceof Method) {
				// binding method
				Method method = (Method) member;
				// TODO does binding any pointer to static method ok ?
				if (obj instanceof JavaClass) {
					member = new BindingMethod(null, method);
				} else {
					member = new BindingMethod(obj, method);
				}
			} else if (member instanceof Field) {
				Field field = (Field) member;
				try {
					member = field.get(obj);
				} catch (IllegalAccessException e) {
					throw new EvalException(e);
				}
			}

			obj = member;
		}
		return obj;
	}

	public static Object getClassMember(Class<?> clazz, String name) {
		Method methodList[] = clazz.getMethods();
		Method method = null;
		for (Method m : methodList) {
			if (m.getName().equals(name)) {
				if (method == null) {
					method = m;
				} else {
					throw new EvalException("ambiguous class member. class: " + clazz + ", member: " + name);
				}
			}
		}

		Field field = null;
		try {
			field = clazz.getField(name);
			if (method != null) {
				throw new EvalException("ambiguous class member. class: " + clazz + ", member: " + name);
			}
			return field;
		} catch (NoSuchFieldException e) {
			// pass
		}

		// a method, or null.
		return method;
	}

}
