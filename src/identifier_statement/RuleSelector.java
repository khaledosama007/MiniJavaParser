package identifier_statement;

import parser.Token;
import parser.TokenQueue;

public class RuleSelector {

	public static Identifier_Statement select() {
		if (TokenQueue.top().equals(Token.EQUAL)) {
			return new Identifier_Statement1();
		} else
			return new Identifier_Statement2();

	}

}
