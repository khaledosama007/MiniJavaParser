package expression;

import new_expression.New_Expression;
import parser.Token;
import parser.TokenQueue;
import expression_alpha.Expression_Alpha;
import gui_module.Visitor;

public class Expression7 implements Expression {

	public Expression_Alpha exp_alpha ;
	public Expression exp ;
	
	
	
	public Expression7(Expression_Alpha exp_alpha, Expression exp) {
		super();
		this.exp_alpha = exp_alpha;
		this.exp = exp;
	}



	public Expression7() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "!" + exp.getValue()+exp_alpha.getValue();
	}
	
	
	
	public static Expression parse () {
		Expression7 expression7 = new Expression7() ;
		Token t = TokenQueue.getToken() ;
		
		if (t.type.equals(Token.NOT)) {
			//t = TokenQueue.getToken() ;
		}else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		Expression exp = RuleSelector.select(TokenQueue.top()) ;
		if (exp == null ) {
			return null ;
		}else {
			expression7.exp = exp ;
			//t = TokenQueue.getToken() ;
		}
		Expression_Alpha alpha = expression_alpha.RuleSelector.select(TokenQueue.top()) ;
		if (alpha == null ) {
			return null ;
		}else {
			expression7.exp_alpha = alpha ;
		}
		return expression7 ;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}

}
