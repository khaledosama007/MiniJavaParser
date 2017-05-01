package declaration;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitor;
import var_declaration.VarDeclaration;
import var_declaration.VarDeclaration1;

public class Declaration1 implements Declaration {

	VarDeclaration varDeclaration;
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String res = new String("");
		res+=varDeclaration.getValue();
		return res;
	}
	
	public Declaration1(VarDeclaration varDeclaration) {
		super();
		this.varDeclaration = varDeclaration;
	}

	public Declaration1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	@Override
	public Declaration parse() {
		Declaration1 d1 = new Declaration1();
		VarDeclaration varD = new VarDeclaration1();
		varD = varD.parse();
		d1.varDeclaration = varD;
		return d1;
		
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Declaration");
		DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
		temp = varDeclaration.getNode();
		root.add(temp);
		return root;
	}
}
