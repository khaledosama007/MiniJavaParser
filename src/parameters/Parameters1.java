package parameters;

import java.util.ArrayList;


import type.Type;

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
	@Override
	public String getValue() {
		String res = new String("");
		res += type.get(0).getValue() + " " + id.get(0) ; 
		
		for (int i =1 ; i < type.size() ; i ++){
			res += " , " + type.get(i).getValue() + " " + id.get(i) ;
		}
		
		return res;
	}

}
