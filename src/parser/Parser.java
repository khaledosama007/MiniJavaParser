package parser;

import java.util.ArrayList;
import java.util.List;


import class_declaration.ClassDeclaration;
import class_declaration.ClassDeclaration1;
import goal.Goal;
import goal.GoalStart;
import main_class.MainClass;
import main_class.MainClass1;
import statement.RuleSelector;
import statement.Statement;
import symbols.EOF;

public class Parser {
	/*List<Token> TokenQueue.queue = new ArrayList<Token>();
	int TokenQueue.index;

	public Parser(List<Token> TokenQueue.queue, int TokenQueue.index) {
		super();
		this.TokenQueue.queue = TokenQueue.queue;
		this.TokenQueue.index = TokenQueue.index;
	}
*/
	public Goal parse() {
		// Token t = TokenQueue.queue.poll();
		MainClass main = mainClass1();
		ClassDeclaration cd = new ClassDeclaration1("aa", "ss", null);// = classDeclaration1();
		EOF e = new EOF();
		Goal g = new GoalStart(main, cd, e);
		return g;
	}

	public MainClass mainClass1(){
		return MainClass1.parse();
	}
		
//	}MainClass main_class = new MainClass1() ;
//		//main_class=main_class.parse(ArrayList,TokenQueue.index);
//		Token t = TokenQueue.queue.get(TokenQueue.index); 
//		TokenQueue.index++ ;
//		if(t.type.equals(Token.CLASS) ){
//			t=TokenQueue.queue.get(TokenQueue.index);
//			TokenQueue.index++ ;
//			if(t.type.equals(Token.IDENTIFIER)){
//				t=TokenQueue.queue.get(TokenQueue.index);
//				TokenQueue.index++ ;
//				main_class.setId(t.value);
//				if (t.type.equals(Token.LEFT_CURLY_B)){
//					t=TokenQueue.queue.get(TokenQueue.index);
//					TokenQueue.index++ ;
//					if (t.type.equals(Token.PUBLIC)) {
//						t=TokenQueue.queue.get(TokenQueue.index);
//						TokenQueue.index++ ;
//						if (t.type.equals(Token.STATIC)) {
//							t=TokenQueue.queue.get(TokenQueue.index);
//							TokenQueue.index++ ;
//							if (t.type.equals(Token.VOID)) {
//								t=TokenQueue.queue.get(TokenQueue.index);
//								TokenQueue.index++ ;
//								if ( t.type.equals(Token.MAIN)) {
//									t=TokenQueue.queue.get(TokenQueue.index);
//									TokenQueue.index++ ;
//									if (t.type.equals(Token.LEFT_ROUND_B)) {
//										t=TokenQueue.queue.get(TokenQueue.index);
//										TokenQueue.index++ ;
//										if (t.type.equals(Token.STRING)) {
//											t=TokenQueue.queue.get(TokenQueue.index);
//											TokenQueue.index++ ;
//											if (t.type.equals(Token. LEFT_SQUARE_B)) {
//												t=TokenQueue.queue.get(TokenQueue.index);
//												TokenQueue.index++ ;
//												if (t.type.equals(Token.RIGHT_SQUARE_B)) {
//													t=TokenQueue.queue.get(TokenQueue.index);
//													TokenQueue.index++ ;
//													if (t.type.equals(Token.IDENTIFIER)) {
//														t=TokenQueue.queue.get(TokenQueue.index);
//														main_class.setId2(t.value);
//														TokenQueue.index++ ;
//														if(t.type.equals(Token.RIGHT_ROUND_B)){
//															t=TokenQueue.queue.get(TokenQueue.index);
//															TokenQueue.index++;
//															if(t.type.equals(Token.LEFT_CURLY_B)){
//																t=TokenQueue.queue.get(TokenQueue.index) ;
//																TokenQueue.index++;
//																Statement statement = RuleSelector.select(t);
//																//statement.parse();
//																TokenQueue.index++;
//																if(t.type.equals(Token.LEFT_CURLY_B)){
//																	t=TokenQueue.queue.get(TokenQueue.index) ;
//																	TokenQueue.index++;
//																	if(t.type.equals(Token.LEFT_CURLY_B)){
//																		main_class.setSt(statement);
//																		return main_class;
//																	}
//																}
//															}
//														}
//													}
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//					
//				}
//				
//				
//			}
//		}
//		return null;
}
