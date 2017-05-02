package statement;

import parser.Token;
import parser.TokenQueue;

public class RuleSelector {
	@SuppressWarnings("static-access")
	public static Statement select() {

		if (TokenQueue.top().equals(Token.LEFT_CURLY_B)) {
			return new Statement1().parse();
		} else if (TokenQueue.top().equals(Token.IF)) {
			return new Statement2().parse();
		} else if (TokenQueue.top().equals(Token.WHILE)) {
			return new Statement3().parse();
		} else if (TokenQueue.top().equals(Token.SOP)) {
			return new Statement4().parse();
		} else {
			return new Statement5();
		}

	}
}
