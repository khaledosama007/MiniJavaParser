package type;

import array_type.ArrayType;

public class Type2 implements Type {
	public String type;
	final public String leftB = "[";
	final public String rightB = "]";
	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	public Type2() {
		super();
		
	}
	public Type2(String type){
		this.type = type;
	}
	@Override
	public String getValue() {
		return type+" "+leftB+rightB;
	}

}
