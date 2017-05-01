package var_declaration;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitable;

public interface VarDeclaration extends Visitable {
 public void print();
 public String getValue();
 public VarDeclaration parse();
 public DefaultMutableTreeNode getNode();
}
