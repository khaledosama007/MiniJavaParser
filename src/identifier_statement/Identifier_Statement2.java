package identifier_statement;

import expression.Expression;

public class Identifier_Statement2 implements Identifier_Statement {

	// "[" Expression "]" "=" Expression ";"
	Expression exp1;
	Expression exp2;

	public Identifier_Statement2(Expression exp1, Expression exp2) {
		super();
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public Identifier_Statement2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "[ ";
		result += exp1.getValue();
		result += " ] = ";
		result += exp2.getValue();
		result += " ; ";

		return result;
	}

	@Override
	public Identifier_Statement parse() {
		// TODO Auto-generated method stub
		return null;
	}

}
