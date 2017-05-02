package expression;

import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;
import gui_module.Visitor;

public class Expression2 implements Expression {

	Expression_Alpha exp ;
	
	public Expression2(Expression_Alpha exp) {
		super();
		this.exp = exp;
	}

	public Expression2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {

		return "true " + exp.getValue();
	}
	
	public static Expression parse () {
		Expression2 expression2 = new Expression2() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.TRUE)) {
			t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(t) ;
		if (alpha == null ) {
			return null ;
		}else {
			expression2.exp = alpha ;
		}
		return expression2 ;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}

}
