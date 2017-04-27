package statement;

import java.util.ArrayList;

public class Statement1 implements Statement {
	ArrayList<Statement> statements;

	public Statement1(ArrayList<Statement> statements) {
		super();
		this.statements = statements;
	}

	public Statement1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub

		String result = "{ ";
		for (int i = 0; i < statements.size(); i++) {
			result += statements.get(i).getValue();
		}
		result += " }";

		return result;
	}

}
