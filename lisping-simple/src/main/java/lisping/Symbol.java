package lisping;

import java.util.Map.Entry;

import lisping.vm.hack.JavaClass;

public class Symbol implements EvalAware {

	public static final char SEP = '.';

	// @NotNull
	private String name = "";

	public Symbol(String name) {
		assert name != null;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Symbol) {
			Symbol rhs = (Symbol) obj;
			return name.equals(rhs.name);
		}
		return false;
	}

	/**
	 * TODO: 如何区分 java 的 `Abc.class.clazz` (取 Class<?> 对象) 和 `Abc.abc` (取类成员) ?
	 */
	@Override
	public Object eval(Scope local) {
		SymbolTokenizer token = new SymbolTokenizer(this.name);
		String name = token.next();
		Entry<String, ?> entry = local.resolveSymbol(name);
		Object obj = null;
		if (entry != null) {
			obj = entry.getValue();
		} else {
			token.reset();
			obj = resolveClass(token);
			if (obj == null) {
				new EvalException("Unable to resolve symbol: " + name + ", scope: " + local);
			}
		}
		if (token.hasNext()) {
			Symbol remain = new Symbol(token.remain());
			obj = Core.get(obj, remain);
		}
		return obj;
	}

	private Object resolveClass(SymbolTokenizer token) {
		while (token.hasNext()) {
			String className = token.nextPossiblyClassName();
			try {
				Class<?> clazz = Class.forName(className);
				return new JavaClass(clazz);
			} catch (ClassNotFoundException e) {
				// pass
			}
		}
		return null;
	}

}
