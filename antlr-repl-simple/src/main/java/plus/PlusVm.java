package plus;

import java.util.ArrayDeque;

public class PlusVm {

	private ArrayDeque<Integer> stack = new ArrayDeque<>();

	public void read(String s) {
		int n = Integer.parseInt(s);
		stack.addLast(n);
		System.out.println("read int: " + n);
	}

	public void plus() {
		int b = stack.removeLast();
		int a = stack.removeLast();
		int c = a + b;
		stack.addLast(c);
		System.out.printf("plus: %d + %d = %d\n", a, b, c);
	}

}
