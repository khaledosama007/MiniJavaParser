package new_expression;

import parser.Token;
import parser.TokenQueue;
import expression.Expression;
import expression.RuleSelector;
import gui_module.Visitor;

public class New_Expression2 implements New_Expression {

	String id ;
	
	public New_Expression2(String id) {
		super();
		this.id = id;
	}

	public New_Expression2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		return id + "( )";
	}
	
	
	public static New_Expression parse () {
		New_Expression2 expression2 = new New_Expression2() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.IDENTIFIER)) {
			expression2.id = t.value ;
			t =  TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		if (t.type.equals(Token.LEFT_ROUND_B)) {
			t=TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		if (t.type.equals(Token.RIGHT_ROUND_B)) {
			t=TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		
		return expression2 ;
	}
	
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}
}

