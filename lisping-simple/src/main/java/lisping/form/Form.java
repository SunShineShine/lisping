package lisping.form;

import lisping.EvalAware;
import lisping.List;

public interface Form extends EvalAware {

	Object apply(List tail);

}
