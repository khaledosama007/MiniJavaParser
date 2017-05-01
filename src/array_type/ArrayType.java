package array_type;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitable;
import gui_module.Visitor;

public interface ArrayType extends Visitable  {
	public void print();
	public String getValue();
	void accept(Visitor visitor);
	public DefaultMutableTreeNode getNode();
}
