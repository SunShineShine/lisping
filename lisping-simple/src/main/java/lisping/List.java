package lisping;

import java.util.ArrayList;
import java.util.Arrays;

import lisping.form.Form;
import lisping.vm.hack.BindingMethod;

public class List implements EvalAware {

	private java.util.List<Object> list;

	public List() {
		list = new ArrayList<>();
	}

	public List(java.util.List<Object> list) {
		this.list = list;
	}

	public List(Object... a) {
		list = Arrays.asList(a);
	}

	public List tail() {
		java.util.List<Object> tmp = list.subList(1, list.size());
		return new List(tmp);
	}

	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public Object eval(Scope local) {
		Object head = list.get(0);
		head = Core.eval(head, local);
		if (head instanceof BindingMethod) {
			List tmp = new List();
			for (Object e : tail().list) {
				e = Core.eval(e, local);
				tmp.list.add(e);
			}
			BindingMethod method = (BindingMethod) head;
			return method.apply(tmp);
		} else if (head instanceof Form) {
			Form form = (Form) head;
			List tail = this.tail();
			return form.apply(tail);
		}
		throw new EvalException("List head is not callable");
	}

}
