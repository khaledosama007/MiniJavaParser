package new_expression;

import parser.Token;

public class RuleSelector {
	
	public static New_Expression select (Token t) {
		if (t.type.equals(Token.INTEGER)) {
			return New_Expression1.parse() ;
		}else if (t.type.equals(Token.IDENTIFIER)) {
			return New_Expression2.parse() ;
		}
		
		return null ;
		
	}

}
