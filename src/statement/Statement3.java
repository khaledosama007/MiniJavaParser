package statement;

import expression.Expression;
import expression.RuleSelector;
import parser.Token;
import parser.TokenQueue;

public class Statement3 implements Statement {
	// "while" "(" Expression ")" Statement
	Expression exp1;
	Statement state1;

	public Statement3(Expression exp1, Statement state1) {
		super();
		this.exp1 = exp1;
		this.state1 = state1;
	}

	public Statement3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = " while ( ";
		result += exp1.getValue();
		result += " ) ";
		result += state1.getValue();
		return result;
	}

	public static Statement parse() {
		// TODO Auto-generated method stub
		Statement3 statement3 = new Statement3();
		Token t = TokenQueue.getToken();

		if (t.type.equals(Token.WHILE)) {
			t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		if (t.type.equals(Token.LEFT_ROUND_B)) {
			t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		Expression exp = RuleSelector.select(t);
		if (exp == null) {
			return null;
		} else {
			statement3.exp1 = exp;
			t = TokenQueue.getToken();
		}

		if (t.type.equals(Token.RIGHT_ROUND_B)) {
			t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}

		Statement stat = statement.RuleSelector.select();
		if (stat == null) {
			return null;
		} else {
			statement3.state1 = stat;
			t = TokenQueue.getToken();
		}

		return statement3;
	}

}
