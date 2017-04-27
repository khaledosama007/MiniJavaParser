package statement;

import expression.Expression;

public class Statement2 implements Statement {
	// "if" "(" Expression ")" Statement ("else" Statement)
	Expression exp1;
	Statement state1;
	Statement state2;
	
	
	
	public Statement2(Expression exp1, Statement state1, Statement state2) {
		super();
		this.exp1 = exp1;
		this.state1 = state1;
		this.state2 = state2;
	}
	public Statement2(Expression exp1, Statement state1) {
		super();
		this.exp1 = exp1;
		this.state1 = state1;
		state2 = null;
	}



	public Statement2() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "if ( ";
		result += exp1.getValue();
		result += " ) ";
		result += state1.getValue();
		result += "else ";
		result += state2.getValue();
		result += " ";

		return result;
	}

}
