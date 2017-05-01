package dot_expression;

import parser.Token;

public class RuleSelector {
	public static Dot_Expression select (Token t) {
		if (t.type.equals(Token.LENGTH)) {
			return Dot_Expression1.parse() ;
		}
		if (t.type.equals(Token.IDENTIFIER)) {
			return Dot_Expression2.parse() ;
		}
		else {
			return null ;
		}
	}

}
