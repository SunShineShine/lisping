package lisping.g4;

public class FileReader implements CollectionReader {

	private Object value;

	@Override
	public void add(Object e) {
		value = e;
	}

	@Override
	public Object done() {
		return value;
	}

}
