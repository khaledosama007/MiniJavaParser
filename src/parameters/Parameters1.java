package parameters;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;
import symbols.RegularType;
import type.Type;
import type.TypeSelector;

public class Parameters1 implements Parameter {

	public ArrayList<Type> type;
	public ArrayList<String> id ;
	//( "," Type identifier )*
	
	@Override
	public void print() {
		// TODO Auto-generated method stub

	}
	public Parameters1(ArrayList<Type> type, ArrayList<String> id) {
		super();
		this.type = type;
		this.id = id;
	}
	public Parameters1() {
		// TODO Auto-generated constructor stub
		type = new ArrayList<>();
		id = new ArrayList<>();
	}
	@Override
	public String getValue() {
		String res = new String("");
		res += type.get(0).getValue() + " " + id.get(0) ; 
		
		for (int i =1 ; i < type.size() ; i ++){
			res += " , " + type.get(i).getValue() + " " + id.get(i) ;
		}
		
		return res;
	}
	public  Parameters1 parse(){
		Parameters1 returnParam = new Parameters1();
		Type localType ;
		String localId;
		
		do{
			localType = TypeSelector.select();
			Token current = TokenQueue.queue.get(TokenQueue.index);
		if(current.type.equals(Token.IDENTIFIER)){
			localId = current.value;
			TokenQueue.index++;
			returnParam.id.add(localId);
			returnParam.type.add(localType);
		}
		else {
			System.out.println("Error expected "+current.type+" Type");
			return null;
		}
		}while(RegularType.isRegular(TokenQueue.queue.get(TokenQueue.index).value));
		return null;
		
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Parameter");
		for(int i=0 ; i<type.size() ; i++){
			root.add(new DefaultMutableTreeNode(type.get(i).getNode()));
		}
		for(int i=0 ; i<id.size() ; i++){
			root.add(new DefaultMutableTreeNode(id.get(i)));
		}
		return root;
	}
	
}
