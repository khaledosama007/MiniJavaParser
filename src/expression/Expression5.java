package expression;

import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;
import gui_module.Visitor;

public class Expression5 implements Expression {

	Expression_Alpha exp ;
	
	public Expression5(Expression_Alpha exp) {
		super();
		this.exp = exp;
	}

	public Expression5() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {

		return "this " + exp.getValue();
	}
	
	
	
	public static Expression parse () {
		Expression5 expression5 = new Expression5() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.THIS)) {
			t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(t) ;
		if (alpha == null ) {
			return null ;
		}else {
			expression5.exp = alpha ;
		}
		return expression5 ;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}
	

}
