package expression;

import expression_alpha.Expression_Alpha;

public class Expression1 implements Expression  {

	int num ;
	Expression_Alpha exp ;
	
	
	
	public Expression1(int num, Expression_Alpha exp) {
		super();
		this.num = num;
		this.exp = exp;
	}



	@Override
	public String getValue() {
		return String.valueOf(num) + exp.getValue();
	}

}
