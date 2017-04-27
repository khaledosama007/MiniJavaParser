package new_expression;

import expression.Expression;

public class New_Expression1 implements New_Expression {

	Expression exp ;
	
	public New_Expression1(Expression exp) {
		super();
		this.exp = exp;
	}

	@Override
	public String getValue() {
		return "int "+"["+exp.getValue()+"]";
	}
	

}
