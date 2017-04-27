package dot_expression;

import expression.Expression;


public class Dot_Expression2  implements Dot_Expression {

	String id ;
	Expression [] exps ;
	
	
	public Dot_Expression2(String id, Expression[] exps) {
		super();
		this.id = id;
		this.exps = exps;
	}

	@Override
	public String getValue() {
		String output = id ;
		output+="(";
		if(exps.length == 1){
			output+=exps[0].getValue();
		}
		else {
			output+=exps[0].getValue()+",";
		for ( int i = 1 ; i < exps.length ; i++ )
			output += " , " + exps[i].getValue() ;
		}
		return output;
	}

}
