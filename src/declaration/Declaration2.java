package declaration;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitor;
import method_declaration.MethodDeclaration;
import method_declaration.MethodDeclaration1;

public class Declaration2 implements Declaration {

	public MethodDeclaration methodDeclaration;
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String res = new String ("") ; 
		res+=" "+methodDeclaration.getValue();
		return res;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	public Declaration2(MethodDeclaration methodDeclaration) {
		super();
		this.methodDeclaration = methodDeclaration;
	}

	public Declaration2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Declaration parse() {
		// TODO Auto-generated method stub
	
		Declaration2 dec2 = new Declaration2();
		MethodDeclaration method = new MethodDeclaration1();
		method = method.parse();
		dec2.methodDeclaration = method;
		return dec2;
		
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
		temp = methodDeclaration.getNode();
		root.add(temp);
		return root;
	}
}
