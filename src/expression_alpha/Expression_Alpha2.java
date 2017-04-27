package expression_alpha;

import expression.Expression;

public class Expression_Alpha2 implements Expression_Alpha {
	

	Expression_Alpha exp_alpha ;
	Expression exp ;
	
	
	
	public Expression_Alpha2(Expression_Alpha exp_alpha, Expression exp) {
		super();
		this.exp_alpha = exp_alpha;
		this.exp = exp;
	}

	
	
	@Override
	public String getValue() {

		return "[" + exp.getValue() + "]" + exp_alpha.getValue();
	}


}
