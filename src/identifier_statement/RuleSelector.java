package identifier_statement;

import parser.Token;
import parser.TokenQueue;

public class RuleSelector {

	@SuppressWarnings("static-access")
	public static Identifier_Statement select() {
		if (TokenQueue.top().equals(Token.EQUAL)) {
			return new Identifier_Statement1().parse();
		} else
			return new Identifier_Statement2().parse();

	}

}
