package statement;

import expression.Expression;

public class Statement3 implements Statement {
	// "while" "(" Expression ")" Statement
	Expression exp1;
	Statement state1;

	public Statement3(Expression exp1, Statement state1) {
		super();
		this.exp1 = exp1;
		this.state1 = state1;
	}

	public Statement3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = " while ( ";
		result += exp1.getValue();
		result += " ) ";
		result += state1.getValue();
		return result;
	}

}
