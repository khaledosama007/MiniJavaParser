package type;

import symbols.RegularType;

public class Type1 implements Type {

	String type;
	
	public Type1(String regularType) {
		super();
		this.type = regularType;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getValue() {
		String res = new String("");
		res+=type;
		return res;
	}

}
