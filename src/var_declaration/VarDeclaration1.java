package var_declaration;


import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;
import type.Type;
import type.TypeSelector;

public class VarDeclaration1 implements VarDeclaration {

	public Type type;
	public String id;
	final public String semicolon = ";";
	
	public VarDeclaration1(Type type, String id) {
		super();
		this.type = type;
		this.id = id;
	}

	public VarDeclaration1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue() {
		String res = new String("");
		res+=type.getValue()+id+semicolon;
		return res;
	}

	@Override
	public VarDeclaration1 parse() {
		VarDeclaration1 var = new VarDeclaration1();
		Type type = TypeSelector.select();
		type = type.parse();
		Token idToken = TokenQueue.getToken();
		if(idToken.type.equals(Token.IDENTIFIER)){
			var.id =idToken.value; 
			var.type = type;
			idToken = TokenQueue.getToken();
			if(idToken.type.equals(Token.SEMICOLON)){
				return var;
			}
			else {
				System.out.println("Error : expected "+Token.IDENTIFIER+" Type");
				return null;
			}
			
		}
		else {
			System.out.println("Error : expected "+Token.IDENTIFIER+" Type");
			return null;
		}
		
		
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Var Declaration");
		DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
		temp = type.getNode();
		root.add(temp);
		root.add(new DefaultMutableTreeNode(id));
		root.add(new DefaultMutableTreeNode(semicolon));
		return root;
	}
}
