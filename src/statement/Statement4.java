package statement;

import expression.Expression;

public class Statement4 implements Statement {
	// "System.out.println" "(" Expression ")" ";"
	Expression exp;

	public Statement4(Expression exp) {
		super();
		this.exp = exp;
	}

	public Statement4() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "System.out.println ( ";
		result += exp.getValue();
		result += ") ; ";

		return result;
	}

}
