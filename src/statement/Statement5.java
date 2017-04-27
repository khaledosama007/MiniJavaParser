package statement;

import identifier_statement.Identifier_Statement;

public class Statement5 implements Statement {
	// Identifier Identifier_Statement
	String id;
	Identifier_Statement identifier_statement;

	public Statement5(){
		
	}
	public Statement5(String id, Identifier_Statement identifier_statement) {
		super();
		this.id = id;
		this.identifier_statement = identifier_statement;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = "";
		result += id;
		result += identifier_statement.getValue();

		return result;
	}

}
