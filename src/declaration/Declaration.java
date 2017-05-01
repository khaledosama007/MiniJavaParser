package declaration;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitable;

public interface Declaration extends Visitable {
	public void print();

	public String getValue();

	public Declaration parse();

	public DefaultMutableTreeNode getNode();

}
