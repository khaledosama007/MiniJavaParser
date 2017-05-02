package expression;

import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;

public class Expression4 implements Expression {

	String id ;
	Expression_Alpha exp ;

	public Expression4(String id, Expression_Alpha exp) {
		super();
		this.id = id;
		this.exp = exp;
	}
	
	public Expression4() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public Expression_Alpha getExp() {
		return exp;
	}





	public void setExp(Expression_Alpha exp) {
		this.exp = exp;
	}





	@Override
	public String getValue() {
		return id + exp.getValue() ;
	}
	
	
	public static Expression parse () {
		Expression4 expression4 = new Expression4() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.IDENTIFIER)) {
			expression4.id = t.value ;
			//t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(TokenQueue.top()) ;
		if (alpha == null ) {
			return null ;
		}else {
			expression4.exp = alpha ;
		}
		return expression4 ;
	}
	

}
