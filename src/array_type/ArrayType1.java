package array_type;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;
import symbols.RegularType;

public class ArrayType1 implements ArrayType {

	public String regularType;
	public final String left = "[";
	public final String right = "]";
	
	public ArrayType1(String regularType) {
		super();
		this.regularType = regularType;
	}
	
	
	public ArrayType1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String result = new String();
		result = " "+regularType+ left+right;
		return result ;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}
	public ArrayType1 parse(){
		ArrayType1 arr = new ArrayType1();
		Token name = TokenQueue.getToken();
		System.out.println("SS"+name.type);
		if(RegularType.isRegular(name.value)){
			arr.regularType = name.value;
			 name = TokenQueue.getToken();
			 
			 if(name.type.equals(Token.LEFT_SQUARE_B)){
				 name = TokenQueue.getToken();
				 if(name.type.equals(Token.RIGHT_SQUARE_B)){
					
					 return arr;
				 }
				 else{
					 System.out.println("Error Expexted "+name.type+" Type");
					 return null;
				 }
			 }
			 else {
				 System.out.println("Error Expexted "+name.type+" Type");
				 return null;
			 }
			
		}
		else {
			System.out.println("Error Expexted "+name.type+" Type");
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
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("ArrayType");
		root.add(new DefaultMutableTreeNode(regularType));
		root.add(new DefaultMutableTreeNode("["));
		root.add(new DefaultMutableTreeNode("]"));
		return root;
	}

}
