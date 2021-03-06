package expression;

import gui_module.Visitable;
import gui_module.Visitor;

public interface Expression extends Visitable {
	
	public String getValue () ;
	@Override
	public void accept(Visitor visitor);
}
