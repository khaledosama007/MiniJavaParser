package statement;

import expression.Expression;
import expression.RuleSelector;
import parser.Token;
import parser.TokenQueue;

public class Statement2 implements Statement {
	// "if" "(" Expression ")" Statement ("else" Statement)
	Expression exp1;
	Statement state1;
	Statement state2;

	public Statement2(Expression exp1, Statement state1, Statement state2) {
		super();
		this.exp1 = exp1;
		this.state1 = state1;
		this.state2 = state2;
	}

	public Statement2(Expression exp1, Statement state1) {
		super();
		this.exp1 = exp1;
		this.state1 = state1;
		state2 = null;
	}

	public Statement2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "if ( ";
		result += exp1.getValue();
		result += " ) ";
		result += state1.getValue();
		result += "else ";
		result += state2.getValue();
		result += " ";

		return result;
	}

	public static Statement parse() {

		Statement2 statement2 = new Statement2();
		Token t = TokenQueue.getToken();

		if (t.type.equals(Token.IF)) {
			t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		if (t.type.equals(Token.LEFT_ROUND_B)) {
			//t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		Expression exp = RuleSelector.select(TokenQueue.top());
		if (exp == null) {
			return null;
		} else {
			statement2.exp1 = exp;
			t = TokenQueue.getToken();
		}

		if (t.type.equals(Token.RIGHT_ROUND_B)) {
			//t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}

		Statement stat = statement.RuleSelector.select();
		if (stat == null) {
			return null;
		} else {
			statement2.state1 = stat;
			t = TokenQueue.getToken();
		}
		if (t.type.equals(Token.ELSE)) {
			//t = TokenQueue.getToken();
		} else {
			statement2.state2 = null;
			TokenQueue.index = TokenQueue.index - 1;
			return statement2;
		}
		stat = statement.RuleSelector.select();
		if (stat == null) {
			return null;
		} else {
			statement2.state2 = stat;
			//t = TokenQueue.getToken();
		}

		// TODO Auto-generated method stub
		return statement2;
	}

}
