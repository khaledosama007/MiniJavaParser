package array_type;

import symbols.RegularType;

public class ArrayType1 implements ArrayType {

	String regularType;
	final String left = "[";
	final String right = "]";
	
	public ArrayType1(String regularType) {
		super();
		this.regularType = regularType;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = new String();
		result = " "+regularType+ left+right;
		return result ;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

}
