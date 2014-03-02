package lisping.g4;

import java.util.ArrayDeque;

import lisping.Core;
import lisping.EvalAware;
import lisping.EvalException;
import lisping.form.Form;
import lisping.vm.hack.BindingMethod;

public class LispingInterpreter {

	private ArrayDeque<CollectionContext> stack = new ArrayDeque<>();
	private CollectionContext parent = new FileContext(null);
	private Object current;
	private int quote = 0;

	public void accept(Object value) {
		if (quote > 0) {
			current = value;
			parent.accept(value);
		} else {
			value = Core.eval(value, parent.getScope());
			current = value;
			if (value instanceof EvalAware) {
				value = Core.quote(value);
			}
			parent.accept(value);
		}
		System.out.println("found expr: " + current);
	}

	public void readInt(String s) {
		Integer value = Integer.valueOf(s);
		accept(value);
	}

	public void readString(String s) {
		// FIXME java escape
		String value = s;
		accept(value);
	}

	public void newList() {
		System.out.println("newList()");
		stack.addLast(parent);
		parent = new ListContext(parent);
		if (quote > 0) {
			quote++;
		}
	}
	
	public void completeListHead() {
		if (quote <= 0) { 
			if (current instanceof BindingMethod) {
				// pass
			} else if (current instanceof Form) {
				quote++;
			} else {
				throw new EvalException("list head is not callable");
			}
		}
	}
	
	public void completeList() {
		if (quote > 0) {
			quote--;
		}
	}

	public void completeCollection() {
		System.out.println("completeCollection()");
		Object value = parent.done();
		parent = stack.removeLast();
		accept(value);
	}

}
