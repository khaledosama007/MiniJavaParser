package expression_alpha;

import dot_expression.Dot_Expression;

public class Expression_Alpha3 implements Expression_Alpha{
	
	Dot_Expression exp ;
	Expression_Alpha exp_alpha ;




	public Expression_Alpha3(Dot_Expression exp , Expression_Alpha exp_alpha) {
		super();
		this.exp = exp;
		this.exp_alpha = exp_alpha;
	}




	@Override
	public String getValue() {
		
		return "." + exp.getValue() ;
	}
	
	

}
