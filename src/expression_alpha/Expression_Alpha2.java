package expression_alpha;

import parser.Token;
import parser.TokenQueue;
import expression.Expression;
import expression.RuleSelector;
import gui_module.Visitor;

public class Expression_Alpha2 implements Expression_Alpha {
	

	public Expression_Alpha exp_alpha ;
	public Expression exp ;
	
	
	
	public Expression_Alpha2(Expression_Alpha exp_alpha, Expression exp) {
		super();
		this.exp_alpha = exp_alpha;
		this.exp = exp;
	}

	
	
	public Expression_Alpha2() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getValue() {

		return "[" + exp.getValue() + "]" + exp_alpha.getValue();
	}

	
	public static Expression_Alpha parse () {
		Expression_Alpha2 alpha1 = new Expression_Alpha2() ;
		Token t = TokenQueue.getToken() ;
		if (t.type.equals(Token.LEFT_SQUARE_B)) {
			//t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression exp = RuleSelector.select(TokenQueue.top()) ;
		if (exp == null ) {
			return null ;
		}else {
			alpha1.exp = exp ;
			t = TokenQueue.getToken() ;
		}
		if (t.type.equals(Token.RIGHT_SQUARE_B)) {
			//t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(TokenQueue.top()) ;
		if (alpha == null ) {
			return null ;
		}else {
			alpha1.exp_alpha = alpha ;
		}
		return alpha1 ;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}
	

}
