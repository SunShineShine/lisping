package lisping.vm.hack;

import java.lang.reflect.Method;

import lisping.EvalException;
import lisping.List;

public class BindingMethod {

	Object obj;
	Method method;
	
	public BindingMethod(Object obj, Method method) {
		this.obj = obj;
		this.method = method;
	}
	
	public Method getMethod() {
		return method;
	}

	public Object apply(List args) {
		try {
			return method.invoke(obj, args.toArray());
		} catch (Exception e) {
			throw new EvalException(e);
		}
	}

}
