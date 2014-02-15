package lisping;

import java.util.Map;

import lisping.vm.HashMap;

public class Scope {

	private Scope parent;
	private HashMap<String, ?> symbolTable = new HashMap<>();

	public Scope(Scope parent) {
		this.parent = parent;
	}

	protected Map.Entry<String, ?> findSymbol(String name) {
		return symbolTable.getEntry(name);
	}

	public Map.Entry<String, ?> resolveSymbol(String name) {
		Map.Entry<String, ?> entry = findSymbol(name);
		if (entry == null && parent != null) {
			entry = parent.resolveSymbol(name);
		}
		return null;
	}

}
