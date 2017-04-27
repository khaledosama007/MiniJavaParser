package type;

import parser.Token;
import parser.TokenQueue;

public class TypeSelector {
	
	public static Type select(){
		Token t1 = TokenQueue.queue.get(TokenQueue.index);
		TokenQueue.index++;
	if(TokenQueue.queue.get(TokenQueue.index).equals(Token.LEFT_SQUARE_B)){
		//one for "[" and one for "]"
		TokenQueue.index++;
		TokenQueue.index++;
		return new Type2(t1.value);
	}
	else {
		TokenQueue.index++;
		return new Type1(t1.value);
	}
	
}
}
