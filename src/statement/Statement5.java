package statement;

import gui_module.Visitor;
import identifier_statement.Identifier_Statement;
import parser.Token;
import parser.TokenQueue;

public class Statement5 implements Statement {
	// Identifier Identifier_Statement
	public String id;
	public Identifier_Statement identifier_statement1;

	public Statement5() {

	}

	public Statement5(String id, Identifier_Statement identifier_statement) {
		super();
		this.id = id;
		this.identifier_statement1 = identifier_statement;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "";
		result += id;
		result += identifier_statement1.getValue();

		return result;
	}

	public static Statement parse() {
		// TODO Auto-generated method stub
		Statement5 statement5 = new Statement5();
		Token t = TokenQueue.getToken();
		if (t.type.equals(Token.IDENTIFIER)) {
			statement5.id = t.value;
			//t = TokenQueue.getToken();
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		Identifier_Statement identifier_Statement2 = identifier_statement.RuleSelector.select();
		if (identifier_Statement2 == null) {
			return null;
		} else {
			statement5.identifier_statement1 = identifier_Statement2;
//			System.out.println("XYZ"+t.type);
//			t = TokenQueue.getToken();
		}
		
		return statement5;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}

}
