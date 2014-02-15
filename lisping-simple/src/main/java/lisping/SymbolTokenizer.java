package lisping;

public class SymbolTokenizer {

	private String name;
	int begin;
	int end;

	public SymbolTokenizer(String name) {
		this.name = name;
		reset();
	}

	public void reset() {
		begin = 0;
		end = 0;
	}

	public boolean hasNext() {
		return end < name.length();
	}

	/**
	 * next name segment.
	 * 
	 * @return
	 */
	public String next() {
		end = name.indexOf(Symbol.SEP, begin);
		if (end < 0) {
			end = name.length();
		}
		String tmp = name.substring(begin, end);
		if (end == name.length()) {
			begin = end;
		} else {
			begin = end + 1;
		}
		return tmp;
	}

	/**
	 * next possibly class name.
	 */
	public String nextPossiblyClassName() {
		end = name.indexOf(Symbol.SEP, begin);
		if (end < 0) {
			end = name.length();
			begin = end;
		} else {
			begin = end + 1;
		}
		return name.substring(0, end);
	}

	public String current() {
		return name.substring(0, end);
	}
	
	public String remain() {
		return name.substring(begin, name.length());
	}

}
