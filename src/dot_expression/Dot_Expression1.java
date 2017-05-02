package dot_expression;

import gui_module.Visitor;
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
		Token t = TokenQueue.queue.get(TokenQueue.index); 
		TokenQueue.index++ ;
		if (t.type.equals(Token.LENGTH)) {
			TokenQueue.index++ ;
		}else{
			System.out.println("Sentax error \"length\" not found");
			return null ;
		}
		return dot_Expression ;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
