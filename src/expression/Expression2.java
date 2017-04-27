package expression;

import expression_alpha.Expression_Alpha;

public class Expression2 implements Expression {

	Expression_Alpha exp ;
	
	public Expression2(Expression_Alpha exp) {
		super();
		this.exp = exp;
	}

	@Override
	public String getValue() {

		return "true " + exp.getValue();
	}

}
