package expression;

import expression_alpha.Expression_Alpha;
import new_expression.New_Expression;

public class Expression6 implements Expression {

	New_Expression exp ;
	Expression_Alpha exp_alpha ;
	
	
	public Expression6(New_Expression exp, Expression_Alpha exp_alpha) {
		super();
		this.exp = exp;
		this.exp_alpha = exp_alpha;
	}


	@Override
	public String getValue() {
		return "new " + exp.getValue() + exp_alpha.getValue();
	}
	
	

}
