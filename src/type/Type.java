package type;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitable;

public interface Type extends Visitable {
 public void print();
 public String getValue();
 public Type parse();
 public DefaultMutableTreeNode getNode();
}
