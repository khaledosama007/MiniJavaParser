package expression;

import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;
import gui_module.Visitor;

public class Expression3 implements Expression {

	public Expression_Alpha exp ;
	
	
	
	
	public Expression3(Expression_Alpha exp) {
		super();
		this.exp = exp;
	}




	public Expression3() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public String getValue() {
		
		return "false " + exp.getValue();
	}
	
	public static Expression parse () {
		Expression3 expression3 = new Expression3() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.FALSE)) {
			//t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(TokenQueue.top()) ;
		if (alpha == null ) {
			return null ;
		}else {
			expression3.exp = alpha ;
		}
		return expression3 ;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}
	

}
