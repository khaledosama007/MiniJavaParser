package statement;

import parser.Token;
import parser.TokenQueue;

public class RuleSelector {
	@SuppressWarnings("static-access")
	public static Statement select() {
		System.out.println(TokenQueue.top().type);
		if (TokenQueue.top().type.equals(Token.LEFT_CURLY_B)) {
			return new Statement1().parse();
		} else if (TokenQueue.top().type.equals(Token.IF)) {
			return new Statement2().parse();
		} else if (TokenQueue.top().type.equals(Token.WHILE)) {
			return new Statement3().parse();
		} else if (TokenQueue.top().type.equals(Token.SOP)) {
			
			return new Statement4().parse();
		} else if (TokenQueue.top().type.equals(Token.IDENTIFIER)) {
			
			return new Statement5().parse();
		}
		else {
			return null;
		}

	}
}
