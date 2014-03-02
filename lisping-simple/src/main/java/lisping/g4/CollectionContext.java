package lisping.g4;

import lisping.Scope;

public interface CollectionContext {

	Scope getScope();

	void accept(Object e);

	Object done();

}
