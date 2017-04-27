package identifier_statement;

import expression.Expression;

public class Identifier_Statement1 implements Identifier_Statement {
	Expression exp;

	
	
	public Identifier_Statement1(Expression exp) {
		super();
		this.exp = exp;
	}



	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "=";
		result += exp.getValue();
		result += "; ";

		return result;
	}

}
