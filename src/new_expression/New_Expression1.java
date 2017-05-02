package new_expression;

import parser.Token;
import parser.TokenQueue;
import expression.Expression;
import expression.RuleSelector;
import gui_module.Visitor;

public class New_Expression1 implements New_Expression {

	Expression exp ;
	
	public New_Expression1(Expression exp) {
		super();
		this.exp = exp;
	}

	public New_Expression1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		return "int "+"["+exp.getValue()+"]";
	}
	
	public static New_Expression parse () {
		New_Expression1 expression1 = new New_Expression1() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.INTEGER)) {
			t =  TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		if (t.type.equals(Token.LEFT_SQUARE_B)) {
			t=TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression exp = RuleSelector.select(t) ;
		if (exp == null ) {
			return null ;
		}else {
			expression1.exp = exp ;
			t = TokenQueue.getToken() ;
		}
		if (t.type.equals(Token.RIGHT_SQUARE_B)) {
			t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		
		return expression1 ;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}
	

}
