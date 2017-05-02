package statement;

import gui_module.Visitor;

import java.util.ArrayList;

import parser.Token;
import parser.TokenQueue;

public class Statement1 implements Statement {
	public ArrayList<Statement> statements;

	public Statement1(ArrayList<Statement> statements) {
		super();
		this.statements = statements;
	}

	public Statement1() {
		// TODO Auto-generated constructor stub
		statements = new ArrayList<>();
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub

		String result = "{ ";
		for (int i = 0; i < statements.size(); i++) {
			result += statements.get(i).getValue();
		}
		result += " }";

		return result;
	}

	public static Statement parse() {
		Statement1 statement1 = new Statement1();
		Token t = TokenQueue.getToken();
		if (t.type.equals(Token.LEFT_CURLY_B)) {
			
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		Statement s = statement.RuleSelector.select();
		
		while (s != null) {
			statement1.statements.add(s);
			s = statement.RuleSelector.select();
		}
		t = TokenQueue.getToken();
		if (t.type.equals(Token.RIGHT_CURLY_B)) {
			
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
			
		return statement1;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}

}
