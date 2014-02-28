package lisping.vm;

public interface Debugger {

	/**
	 * eval 当前表达式. 
	 * pc 指向下一条表达式. 下条表达式可能由 form 决定.
	 * 
	 * @return 当前表达式求值结果.
	 */
	Object next();

	/**
	 * 进入函数调用栈. 
	 * 仅当前指令是函数调用时有效. 
	 * pc 指向函数体表达式.
	 */
	void stepIn();

	/**
	 * 进入子表达式求值. 
	 * 仅当当前表达式是复合表达式时有效. 
	 * pc 指向第一个子表达式.
	 */
	void enter();

	/**
	 * 完成当前表达式父表达式求值. 
	 * pc 指向父表达式的下一条表达式.
	 * 
	 * @return 父表达式求值结果.
	 */
	Object up();

	/**
	 * 完成函数调用, 当前 frame 顶层表达式. 
	 * pc 指向函数调用表达式的下一条表达式.
	 * 
	 * @return 函数调用结果
	 */
	Object finish();

}
