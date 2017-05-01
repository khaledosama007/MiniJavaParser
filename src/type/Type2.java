package type;

import array_type.ArrayType;
import array_type.ArrayType1;
import parser.TokenQueue;

public class Type2 implements Type {
	ArrayType arrayType;
	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	public Type2() {
		super();
		
	}
	public Type2(ArrayType type){
		this.arrayType = type;
	}
	@Override
	public String getValue() {
		return arrayType.getValue();
	}

	@Override
	public Type parse() {
		Type2 type = new Type2();
		ArrayType1 typeArr = new ArrayType1();
		typeArr = typeArr.parse();
		type.arrayType = typeArr;
		//TokenQueue.index++;
		return type;
	}

	

}
