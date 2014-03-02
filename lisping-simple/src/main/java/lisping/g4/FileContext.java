package lisping.g4;

public class FileContext extends AbstractContext {

	public FileContext(CollectionContext parent) {
		super(parent);
	}

	private Object value;

	@Override
	public void accept(Object e) {
		value = e;
	}

	@Override
	public Object done() {
		return value;
	}

}
