package new_expression;

import gui_module.Visitable;
import gui_module.Visitor;

public interface New_Expression extends Visitable{
	
	public String getValue() ;
	@Override
	public void accept(Visitor visitor);

}
