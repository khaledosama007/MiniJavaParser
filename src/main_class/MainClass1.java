package main_class;

import java.util.ArrayList;

import parser.Token;
import parser.TokenQueue;
import statement.RuleSelector;
import statement.Statement;

public class MainClass1 implements MainClass {

	final String classString = "class";
	String id;
	final String leftB="{";
	final String publicString="public";
	final String staticString = "static";
	final String voidString ="void";
	final String mainString = "main" ;
	final String leftR = "(";
	final String StringS="String";
	final String leftS="[";
	final String rightS="]";
	String id2;
	final String rightB = ")";
	final String leftB2 ="{";
	Statement st ;
	final String rightB2="}";
	final String rightB3 = "}";
	
	
	
	
	public MainClass1() {
		super();
	}

	public MainClass1(String id, String id2, Statement st) {
		super();
		this.id = id;
		this.id2 = id2;
		this.st = st;
	}
	
	
	
	
	
	
	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getId2() {
		return id2;
	}






	public void setId2(String id2) {
		this.id2 = id2;
	}






	public Statement getSt() {
		return st;
	}






	public void setSt(Statement st) {
		this.st = st;
	}






	@Override
	public void print() {
		
		
	}
	public static MainClass parse(){
		MainClass main_class = new MainClass1() ;
		//main_class=main_class.parse(ArrayList,TokenQueue.index);
		Token t = TokenQueue.queue.get(TokenQueue.index); 
		TokenQueue.index++ ;
		if(t.type.equals(Token.CLASS) ){
			t=TokenQueue.queue.get(TokenQueue.index);
			TokenQueue.index++ ;
			if(t.type.equals(Token.IDENTIFIER)){
				t=TokenQueue.queue.get(TokenQueue.index);
				TokenQueue.index++ ;
				main_class.setId(t.value);
				if (t.type.equals(Token.LEFT_CURLY_B)){
					t=TokenQueue.queue.get(TokenQueue.index);
					TokenQueue.index++ ;
					if (t.type.equals(Token.PUBLIC)) {
						t=TokenQueue.queue.get(TokenQueue.index);
						TokenQueue.index++ ;
						if (t.type.equals(Token.STATIC)) {
							t=TokenQueue.queue.get(TokenQueue.index);
							TokenQueue.index++ ;
							if (t.type.equals(Token.VOID)) {
								t=TokenQueue.queue.get(TokenQueue.index);
								TokenQueue.index++ ;
								if ( t.type.equals(Token.MAIN)) {
									t=TokenQueue.queue.get(TokenQueue.index);
									TokenQueue.index++ ;
									if (t.type.equals(Token.LEFT_ROUND_B)) {
										t=TokenQueue.queue.get(TokenQueue.index);
										TokenQueue.index++ ;
										if (t.type.equals(Token.STRING)) {
											t=TokenQueue.queue.get(TokenQueue.index);
											TokenQueue.index++ ;
											if (t.type.equals(Token. LEFT_SQUARE_B)) {
												t=TokenQueue.queue.get(TokenQueue.index);
												TokenQueue.index++ ;
												if (t.type.equals(Token.RIGHT_SQUARE_B)) {
													t=TokenQueue.queue.get(TokenQueue.index);
													TokenQueue.index++ ;
													if (t.type.equals(Token.IDENTIFIER)) {
														t=TokenQueue.queue.get(TokenQueue.index);
														main_class.setId2(t.value);
														TokenQueue.index++ ;
														if(t.type.equals(Token.RIGHT_ROUND_B)){
															t=TokenQueue.queue.get(TokenQueue.index);
															TokenQueue.index++;
															if(t.type.equals(Token.LEFT_CURLY_B)){
																t=TokenQueue.queue.get(TokenQueue.index) ;
																TokenQueue.index++;
																Statement statement = RuleSelector.select(t);
																//statement.parse();
																TokenQueue.index++;
																if(t.type.equals(Token.LEFT_CURLY_B)){
																	t=TokenQueue.queue.get(TokenQueue.index) ;
																	TokenQueue.index++;
																	if(t.type.equals(Token.LEFT_CURLY_B)){
																		main_class.setSt(statement);
																		return main_class;
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					
				}
				
				
			}
		}
		return main_class;
	}
	@Override
	public String getValue() {
		String result = new String("");
		result+=classString+" "+id+" "+leftB+publicString+" "+staticString+" "+voidString+" "+mainString+
				" "+leftR+
				StringS+
				leftS+rightS+id2+
				rightB+leftB2+
				st.getValue()
				+rightB2+rightB3;
		return result;
	}

	@Override
	public void setStatement(Statement statement) {
		// TODO Auto-generated method stub
		
	}
	
}
