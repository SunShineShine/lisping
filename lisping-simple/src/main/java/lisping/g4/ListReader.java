package lisping.g4;

import java.util.ArrayList;

import lisping.List;

public class ListReader implements CollectionReader {

	private ArrayList<Object> list = new ArrayList<>();

	@Override
	public void add(Object e) {
		list.add(e);
	}

	@Override
	public Object done() {
		return new List(list);
	}

}
