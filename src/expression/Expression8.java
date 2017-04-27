package expression;

import expression_alpha.Expression_Alpha;

public class Expression8 implements Expression {

	Expression_Alpha exp_alpha ;
	Expression exp ;
	
	
	
	public Expression8(Expression_Alpha exp_alpha, Expression exp) {
		super();
		this.exp_alpha = exp_alpha;
		this.exp = exp;
	}

	
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "(" + exp.getValue() + ")" + exp_alpha.getValue();
	}
	
	

}
