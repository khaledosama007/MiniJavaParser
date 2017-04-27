package expression;

import expression_alpha.Expression_Alpha;

public class Expression5 implements Expression {

	Expression_Alpha exp ;
	
	public Expression5(Expression_Alpha exp) {
		super();
		this.exp = exp;
	}

	@Override
	public String getValue() {

		return "this " + exp.getValue();
	}
	

}
