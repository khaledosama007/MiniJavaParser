package declaration;

import parser.Token;
import parser.TokenQueue;

public class RuleSelector {

	public static Declaration select(){
		if(TokenQueue.top().type.equals(Token.PUBLIC) || 
				TokenQueue.queue.get(TokenQueue.index).type.equals(Token.PRIVATE)){
			return new Declaration2();
		}
		else {
			return new Declaration1();
		}
	}
}
