package type;

import javax.swing.tree.DefaultMutableTreeNode;

import array_type.ArrayType;
import array_type.ArrayType1;
import gui_module.Visitor;
import parser.TokenQueue;

public class Type2 implements Type {
	public ArrayType arrayType;
	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	public Type2() {
		super();
		
	}
	public Type2(ArrayType type){
		this.arrayType = type;
	}
	@Override
	public String getValue() {
		return arrayType.getValue();
	}

	@Override
	public Type parse() {
		Type2 type = new Type2();
		ArrayType1 typeArr = new ArrayType1();
		typeArr = typeArr.parse();
		type.arrayType = typeArr;
		//TokenQueue.index++;
		return type;
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Type 2");
		DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
		temp = arrayType.getNode();
		root.add(temp);
		return root;
	}
	

}
