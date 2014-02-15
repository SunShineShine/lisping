package lisping;

import org.junit.Test;

public class CoreTest {

	@Test
	public void testEval() {
		Scope local = new Scope(null);
		// FIXME: get method by parameter classes to test
		Symbol symbol = new Symbol("java.lang.System.out.printf");
		List list = new List(symbol, "%s\n", getClass());
		Object res = Core.eval(list, local);
		System.out.println(res);
	}

	@Test
	public void testGet() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetClassMember() {
//		fail("Not yet implemented");
	}

}
