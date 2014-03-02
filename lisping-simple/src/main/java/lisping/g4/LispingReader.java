package lisping.g4;

import java.util.ArrayDeque;

public class LispingReader {

	private ArrayDeque<CollectionReader> stack = new ArrayDeque<>();
	private CollectionReader current = new FileReader();

	public void add(Object value) {
		current.add(value);
		System.out.println("found expr: " + value);
	}

	public void readInt(String s) {
		Integer value = Integer.valueOf(s);
		add(value);
	}

	public void readString(String s) {
		// FIXME java escape
		String value = s;
		add(value);
	}

	public void newList() {
		System.out.println("newList()");
		stack.addLast(current);
		current = new ListReader();
	}

	public void completeCollection() {
		System.out.println("completeCollection()");
		Object value = current.done();
		current = stack.removeLast();
		add(value);
	}

}
