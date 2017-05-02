package identifier_statement;

import expression.Expression;
import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;

public class Identifier_Statement1 implements Identifier_Statement {

	public Expression exp;

	public Identifier_Statement1(Expression exp) {
		super();
		this.exp = exp;
	}

	public Identifier_Statement1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "=";
		result += exp.getValue();
		result += "; ";

		return result;
	}

	public static Identifier_Statement parse() {
		// TODO Auto-generated method stub
		Identifier_Statement1 identifier_Statement1 = new Identifier_Statement1();
		Token t = TokenQueue.getToken();
		if (t.type.equals(Token.EQUAL)) {
			Expression exp = expression.RuleSelector.select(TokenQueue.top());
			
			if (exp != null) {
				
				t = TokenQueue.getToken();
				
				
				identifier_Statement1 = new Identifier_Statement1(exp);
				if (!t.type.equals(Token.SEMICOLON)) {
					
					return null;
				}
				else{
					System.out.println("select"+t.value);
					return identifier_Statement1;
				}
			} else {
				return null;
			}

		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		//return identifier_Statement1;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}
}