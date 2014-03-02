package lisping.g4;

import java.util.ArrayDeque;

public class LispingReader {

	private ArrayDeque<CollectionReader> stack = new ArrayDeque<>();
	private CollectionReader parent = new FileReader();

	public void add(Object value) {
		parent.add(value);
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
		stack.addLast(parent);
		parent = new ListReader();
	}

	public void completeCollection() {
		System.out.println("completeCollection()");
		Object value = parent.done();
		parent = stack.removeLast();
		add(value);
	}

}
