package expression_alpha;

import parser.Token;
import parser.TokenQueue;
import dot_expression.Dot_Expression;
import expression.Expression;
import dot_expression.RuleSelector;

public class Expression_Alpha3 implements Expression_Alpha{
	
	Dot_Expression exp ;
	Expression_Alpha exp_alpha ;




	public Expression_Alpha3(Dot_Expression exp , Expression_Alpha exp_alpha) {
		super();
		this.exp = exp;
		this.exp_alpha = exp_alpha;
	}




	public Expression_Alpha3() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public String getValue() {
		
		return "." + exp.getValue() ;
	}
	
	public static Expression_Alpha parse () {
		Expression_Alpha3 alpha1 = new Expression_Alpha3() ;
		Token t =  TokenQueue.getToken() ;
		
		if (t.type.equals(Token.DOT)) {
			//t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Dot_Expression exp = RuleSelector.select(TokenQueue.top()) ;
		if (exp == null ) {
			return null ;
		}else {
			alpha1.exp = exp ;
			//t = TokenQueue.getToken() ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(TokenQueue.top()) ;
		if (alpha == null ) {
			return null ;
		}else {
			alpha1.exp_alpha = alpha ;
		}
		
		return alpha1 ;
	}
	
	

}
