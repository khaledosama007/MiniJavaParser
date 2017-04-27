package expression_alpha;

import expression.Expression;

public class Expression_Alpha1 implements Expression_Alpha {

	Expression_Alpha exp_alpha ;
	Expression exp ;
	char binaryOp ;
	
	
	
	public Expression_Alpha1(Expression_Alpha exp_alpha, Expression exp,char binaryOp) {
		super();
		this.exp_alpha = exp_alpha;
		this.exp = exp;
		this.binaryOp = binaryOp ;
	}

	
	
	@Override
	public String getValue() {

		return binaryOp + exp.getValue() + exp_alpha.getValue();
	}

}
