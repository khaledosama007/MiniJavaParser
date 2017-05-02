package expression_alpha;

import gui_module.Visitor;

public class Expression_Alpha4 implements Expression_Alpha {

	@Override
	public String getValue() {
		
		return new String("");
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
		
	}

}
