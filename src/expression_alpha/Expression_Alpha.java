package expression_alpha;

import gui_module.Visitable;
import gui_module.Visitor;

public interface Expression_Alpha extends Visitable{
	
	public String getValue () ;
	@Override
	public void accept(Visitor visitor);

}
