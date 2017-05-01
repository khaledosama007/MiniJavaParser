package expression_alpha;

import parser.Token;
import parser.TokenQueue;
import expression.Expression;
import expression.RuleSelector;

public class Expression_Alpha1 implements Expression_Alpha {

	Expression_Alpha exp_alpha ;
	Expression exp ;
	String binaryOp ;
	
	
	
	public Expression_Alpha1(Expression_Alpha exp_alpha, Expression exp,String binaryOp) {
		super();
		this.exp_alpha = exp_alpha;
		this.exp = exp;
		this.binaryOp = binaryOp ;
	}

	
	
	public Expression_Alpha1() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getValue() {

		return binaryOp + exp.getValue() + exp_alpha.getValue();
	}
	
	
	public static Expression_Alpha parse () {
		Expression_Alpha1 alpha1 = new Expression_Alpha1() ;
		Token t = TokenQueue.getToken() ;
		if (t.type.equals(Token.PLUS) || t.type.equals(Token.MINUS) || t.type.equals(Token.MULTIPLY) || t.type.equals(Token.GREATERTHAN) || t.type.equals(Token.AND)) {
			t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression exp = RuleSelector.select(t) ;
		if (exp == null ) {
			return null ;
		}else {
			alpha1.exp = exp ;
			t = TokenQueue.getToken() ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(t) ;
		if (alpha == null ) {
			return null ;
		}else {
			alpha1.exp_alpha = alpha ;
		}
		
		return alpha1 ;
		
	}

}
