package expression;

import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;
import gui_module.Visitor;

public class Expression1 implements Expression  {

	public String num ;
	public Expression_Alpha exp ;
	
	
	
	public Expression1(String num, Expression_Alpha exp) {
		super();
		this.num = num;
		this.exp = exp;
	}



	public Expression1() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getValue() {
		return String.valueOf(num) + exp.getValue();
	}
	
	
	public static Expression parse () {
		Expression1 expression1 = new Expression1() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.INTEGER_LITERAL)) {
			expression1.num = t.value ;
			
			
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(TokenQueue.top()) ;
		if (alpha == null ) {
			return null ;
		}else {
			

			expression1.exp = alpha ;
			//System.out.println("select"+TokenQueue.top().value);
		}
		return expression1 ;
	}



	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}

}
