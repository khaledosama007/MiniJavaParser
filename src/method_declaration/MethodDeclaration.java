package method_declaration;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitable;

public interface MethodDeclaration extends Visitable {
 public void print();
 public String getValue();
 public MethodDeclaration parse();
 public DefaultMutableTreeNode getNode();
}
