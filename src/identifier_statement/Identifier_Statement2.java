package identifier_statement;

import expression.Expression;
import expression.RuleSelector;
import parser.Token;
import parser.TokenQueue;

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

	public static Identifier_Statement parse() {
		// TODO Auto-generated method stub
		Identifier_Statement2 identifier_Statement2 = new Identifier_Statement2();
		Token t = TokenQueue.getToken();

		if (t.type.equals(Token.LEFT_SQUARE_B)) {
			
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		Expression exp = RuleSelector.select(TokenQueue.top());
		if (exp == null) {
			return null;
		} else {
			identifier_Statement2.exp1 = exp;
			t = TokenQueue.getToken();
		}
		if (t.type.equals(Token.RIGHT_SQUARE_B)) {
			t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}

		if (t.type.equals(Token.EQUAL)) {
			//t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}

		exp = RuleSelector.select(TokenQueue.top());
		if (exp == null) {
			return null;
		} else {
			identifier_Statement2.exp2 = exp;
			t = TokenQueue.getToken();
		}

		if (t.type.equals(Token.SEMICOLON)) {
			
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}

		return identifier_Statement2;
	}

}
