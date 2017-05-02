package expression;
import parser.Token;
import parser.TokenQueue;

public class RuleSelector {
	
	public static Expression select (Token t) {
		
		if ( t.type.equals(Token.INTEGER_LITERAL)) {
			
			return Expression1.parse() ;
		}else if (t.type.equals(Token.TRUE)) {
			return Expression2.parse() ;
		}else if ( t.type.equals(Token.FALSE)) {
			return Expression3.parse() ;
		}else if (t.type.equals(Token.IDENTIFIER)) {
			return Expression4.parse() ;
		}else if (t.type.equals(Token.THIS)) {
			return Expression5.parse() ;
		}else if (t.type.equals(Token.NEW)) {
			return Expression6.parse() ;
		}else if (t.type.equals(Token.NOT)) {
			return Expression7.parse() ;
		}else if (t.type.equals(Token.LEFT_ROUND_B)) {
			return Expression8.parse() ;
		}else {
			return null ;
		}
		
	}
	

}
