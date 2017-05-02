package expression;

import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;
import gui_module.Visitor;

public class Expression8 implements Expression {

	public Expression_Alpha exp_alpha ;
	public Expression exp ;
	
	
	
	public Expression8(Expression_Alpha exp_alpha, Expression exp) {
		super();
		this.exp_alpha = exp_alpha;
		this.exp = exp;
	}

	
	
	public Expression8() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "(" + exp.getValue() + ")" + exp_alpha.getValue();
	}
	
	public static Expression parse () {
		Expression8 expression8 = new Expression8() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.LEFT_ROUND_B)) {
			t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression exp = RuleSelector.select(t) ;
		if (exp == null ) {
			return null ;
		}else {
			expression8.exp = exp ;
			t = TokenQueue.getToken() ;
		}
		if (t.type.equals(Token.RIGHT_ROUND_B)) {
			t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(t) ;
		if (alpha == null ) {
			return null ;
		}else {
			expression8.exp_alpha = alpha ;
		}
		return expression8 ;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}
	
	

}
