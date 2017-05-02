package type;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;
import symbols.RegularType;

public class Type1 implements Type {

	public String regularType;
	
	public Type1(String regularType) {
		super();
		this.regularType = regularType;
	}

	public Type1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getValue() {
		String res = new String("");
		res+=regularType;
		return res;
	}

	@Override
	public Type parse() {

		Type1 type = new Type1();
		Token c = TokenQueue.getToken();
		if(RegularType.isRegular(c.value)){
			type.regularType = c.value;
			return type;
		}
		else {
			System.out.println("error expected "+TokenQueue.queue.get(TokenQueue.index).type+" Type ");
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
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Type1");
		DefaultMutableTreeNode temp = new DefaultMutableTreeNode(regularType);
		root.add(temp);
		return root;
	}
}
