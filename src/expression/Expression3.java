package expression;

import expression_alpha.Expression_Alpha;

public class Expression3 implements Expression {

	Expression_Alpha exp ;
	
	
	
	
	public Expression3(Expression_Alpha exp) {
		super();
		this.exp = exp;
	}




	@Override
	public String getValue() {
		
		return "false " + exp.getValue();
	}
	
	

}
