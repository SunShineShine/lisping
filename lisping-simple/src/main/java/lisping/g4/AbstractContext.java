package lisping.g4;

import lisping.Scope;

public abstract class AbstractContext implements CollectionContext {

	private Scope scope;

	public AbstractContext(CollectionContext parent) {
		Scope parentScope = parent == null ? null : parent.getScope();
		scope = new Scope(parentScope);
	}

	public Scope getScope() {
		return scope;
	}

}
