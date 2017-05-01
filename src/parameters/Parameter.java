package parameters;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitable;

public interface Parameter extends Visitable {
 public void print();
 public String getValue();
 public DefaultMutableTreeNode getNode();
}

