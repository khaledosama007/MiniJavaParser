package identifier_statement;

import expression.Expression;
import parser.Token;
import parser.TokenQueue;
import statement.RuleSelector;
import statement.Statement;

public class Identifier_Statement1 implements Identifier_Statement {

	Expression exp;

	public Identifier_Statement1(Expression exp) {
		super();
		this.exp = exp;
	}

	public Identifier_Statement1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "=";
		result += exp.getValue();
		result += "; ";

		return result;
	}

	@Override
	public Identifier_Statement parse() {
		// TODO Auto-generated method stub
		Identifier_Statement1 identifier_Statement1 = new Identifier_Statement1();
		Token t = TokenQueue.queue.get(TokenQueue.index);
		if (t.type.equals(Token.EQUAL)) {
			t = TokenQueue.queue.get(TokenQueue.index);
			Expression expression = null;
			// expression = RuleSelector.select(t);
			// expression = expression.parse();
			if (!expression.equals(null)) {
				t = TokenQueue.queue.get(TokenQueue.index);

				if (t.type.equals(Token.EXTENDS)) {
					t = TokenQueue.queue.get(TokenQueue.index);

				} else {

				}

			} else {
				return null;
			}

		} else {
			System.out.println("Expected = Symbol ");
			return null;
		}

		return identifier_Statement1;
	}

}