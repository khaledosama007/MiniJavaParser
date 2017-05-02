package statement;

import expression.Expression;
import expression.RuleSelector;
import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;

public class Statement4 implements Statement {
	// "System.out.println" "(" Expression ")" ";"
	public Expression exp;

	public Statement4(Expression exp) {
		super();
		this.exp = exp;
	}

	public Statement4() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "System.out.println ( ";
		result += exp.getValue();
		result += ") ; ";

		return result;
	}

	public static Statement parse() {
		// TODO Auto-generated method stub
		Statement4 statement4 = new Statement4();
		Token t = TokenQueue.getToken();
		
		if (t.type.equals(Token.SOP)) {
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
			
			statement4.exp = exp;
			t = TokenQueue.getToken();
		}
		
		if (t.type.equals(Token.RIGHT_ROUND_B)) {
			t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}

		if (t.type.equals(Token.SEMICOLON)) {
			//t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}

		return statement4;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}

}
