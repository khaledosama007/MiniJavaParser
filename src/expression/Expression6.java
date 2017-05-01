package expression;

import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;
import new_expression.New_Expression;

public class Expression6 implements Expression {

	New_Expression exp ;
	Expression_Alpha exp_alpha ;
	
	
	public Expression6(New_Expression exp, Expression_Alpha exp_alpha) {
		super();
		this.exp = exp;
		this.exp_alpha = exp_alpha;
	}


	public Expression6() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getValue() {
		return "new " + exp.getValue() + exp_alpha.getValue();
	}
	
	
	public static Expression parse () {
		Expression6 expression6 = new Expression6() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.NEW)) {
			t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		New_Expression exp = new_expression.RuleSelector.select(t) ;
		if (exp == null ) {
			return null ;
		}else {
			expression6.exp = exp ;
			t = TokenQueue.getToken() ;
		}
		
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(t) ;
		if (alpha == null ) {
			return null ;
		}else {
			expression6.exp_alpha = alpha ;
		}
		return expression6 ;
	}
	

}
