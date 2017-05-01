package expression_alpha;

import parser.Token;

public class RuleSelector {
	
	public static Expression_Alpha select (Token t) {
		if (t.type.equals(Token.PLUS) || t.type.equals(Token.MINUS) || t.type.equals(Token.MULTIPLY)|| t.type.equals(Token.GREATERTHAN) || t.type.equals(Token.AND)) {
			return Expression_Alpha1.parse() ;
		}
		else if (t.type.equals(Token.LEFT_SQUARE_B)) {
			return  Expression_Alpha2.parse();
		}
		else if (t.type.equals(Token.DOT)) {
			return  Expression_Alpha3.parse();
		}
		else {
			return new Expression_Alpha4 () ;
		}
	}

}
