package dot_expression;

import parser.Token;
import parser.TokenQueue;

public class Dot_Expression1  implements Dot_Expression {

	final String length = "length" ;
	@Override
	public String getValue() {
		return length ;
	}
	
	public static Dot_Expression parse () {
		Dot_Expression dot_Expression = new Dot_Expression1 () ;
		Token t = TokenQueue.getToken() ;
		if (t.type.equals(Token.LENGTH)) {
			
		}else{
			System.out.println("Sentax error \"length\" not found");
			return null ;
		}
		return dot_Expression ;
	}

}
