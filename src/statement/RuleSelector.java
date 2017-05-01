package statement;

import parser.Token;
import parser.TokenQueue;

public class RuleSelector {
	public static Statement select() {

		if (TokenQueue.top().equals(Token.LEFT_CURLY_B)) {
			return new Statement1();
		} else if (TokenQueue.top().equals(Token.IF)) {
			return new Statement2();
		} else if (TokenQueue.top().equals(Token.WHILE)) {
			return new Statement3();
		} else if (TokenQueue.top().equals(Token.SOP)) {
			return new Statement4();
		} else {
			return new Statement5();
		}

	}
}
