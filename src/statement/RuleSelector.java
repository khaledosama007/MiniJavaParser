package statement;

import parser.Token;

public class RuleSelector {
	public static Statement select(Token t){
		if(t.value.equals(t.LEFT_CURLY_B)){
			return new Statement1();
		}
		else if (t.value.equals(t.IF)){
			return new Statement2();
		}
		else if (t.value.equals(t.WHILE)){
			return new Statement3();
		}
		else if(t.value.equals(t.SOP)){
			return new Statement4();
		}
		else 
			return new Statement5();
		
	}
}
