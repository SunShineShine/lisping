package lisping;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {

	public static final String HELLO = "hello";

	public static String hello() {
		return HELLO;
	}

	@Test
	public void testEval() {
		Scope local = new Scope(null);
		Symbol symbol = new Symbol(ListTest.class.getName() + ".hello");
		List list = new List(symbol);
		Object obj = list.eval(local);
		Assert.assertEquals(HELLO, obj);
	}

}
