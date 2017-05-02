package dot_expression;

import java.util.List;
import expression.RuleSelector;
import parser.Token;
import parser.TokenQueue;
import expression.Expression;


public class Dot_Expression2  implements Dot_Expression {

	public String id ;
	public List <Expression>  exps ;
	
	
	public Dot_Expression2(String id, List <Expression> exps) {
		super();
		this.id = id;
		this.exps = exps;
	}

	public Dot_Expression2() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getValue() {
		String output = id ;
		output+="(";
		if(exps.size() == 1){
			output+=exps.get(0).getValue();
		}
		else {
			output+=exps.get(0).getValue()+",";
		for ( int i = 1 ; i < exps.size() ; i++ )
			output += " , " + exps.get(0).getValue() ;
		}
		return output;
	}
	
	public static Dot_Expression parse () {
		Dot_Expression2 dot_Expression = new Dot_Expression2 () ;
		Token t = TokenQueue.getToken() ;
		if (t.type.equals(Token.IDENTIFIER)) {
			dot_Expression.id = t.value ;
			t = TokenQueue.getToken();
		}else{
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		if (t.type.equals(Token.LEFT_ROUND_B)) {
			t = TokenQueue.getToken() ;
		}
		else {
			System.out.println("Error : Expected "+t.type+" Type");
			return null ;
		}
		if (t.type.equals(Token.RIGHT_ROUND_B)) {
			//t = TokenQueue.getToken() ;
		}
		else {
			do {
				Expression exp = RuleSelector.select(TokenQueue.top()) ;
				if (exp == null ) {
					return null ;
				}
				dot_Expression.exps.add(exp) ;
			}while (  TokenQueue.getToken().equals(Token.COMMA) ) ;
			
			if (!TokenQueue.top().equals(Token.RIGHT_ROUND_B)) {
				System.out.println("Error : Expected "+t.type+" Type");
				return null ;
			}
		}
		return dot_Expression ;
	}

}
