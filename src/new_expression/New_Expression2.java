package new_expression;

public class New_Expression2 implements New_Expression {

	String id ;
	
	public New_Expression2(String id) {
		super();
		this.id = id;
	}

	@Override
	public String getValue() {
		return id + "( )";
	}
	

}
