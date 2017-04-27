package expression;

import expression_alpha.Expression_Alpha;

public class Expression4 implements Expression {

	String id ;
	Expression_Alpha exp ;

	public Expression4(String id, Expression_Alpha exp) {
		super();
		this.id = id;
		this.exp = exp;
	}

	@Override
	public String getValue() {
		return id + exp.getValue() ;
	}
	

}
