package type;

import parser.Token;
import parser.TokenQueue;
import symbols.RegularType;

public class TypeSelector {
	
	public static Type select(){
	Token t1 =TokenQueue.top();
	if(TokenQueue.queue.get(TokenQueue.index+1).type.equals(Token.LEFT_SQUARE_B)){
		 
		return new Type2();
	}
	else if(TokenQueue.queue.get(TokenQueue.index+1).type.equals(Token.IDENTIFIER)) {
		
		//TokenQueue.index++;
		return new Type1();
	}
	else {
		
		System.out.println("error expected "+t1.type+" Type");
		return null;
	}
	
}
}
