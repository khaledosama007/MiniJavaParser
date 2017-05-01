package parameters;

import java.util.ArrayList;

import parser.Token;
import parser.TokenQueue;
import symbols.RegularType;
import type.Type;
import type.TypeSelector;

public class Parameters1 implements Parameter {

	ArrayList<Type> type;
	ArrayList<String> id ;
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
}
