package main_class;

import parser.Token;
import parser.TokenQueue;
import statement.RuleSelector;
import statement.Statement;

public class MainClass1 implements MainClass {

	final String classString = "class";
	public String id = new String("");
	final String leftB = "{";
	final String publicString = "public";
	final String staticString = "static";
	final String voidString = "void";
	final String mainString = "main";
	final String leftR = "(";
	final String StringS = "String";
	final String leftS = "[";
	final String rightS = "]";
	String id2 = new String("");
	final String rightB = ")";
	final String leftB2 = "{";
	Statement st;
	final String rightB2 = "}";
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

	public MainClass1 parse() {
		MainClass1 main_class = new MainClass1();
		Token t = TokenQueue.getToken();
		if (t.type.equals(Token.CLASS)) {
			t = TokenQueue.getToken();
			if (t.type.equals(Token.IDENTIFIER)) {
				// main_class.id = t.value;
				main_class.setId(t.value);
				t = TokenQueue.getToken();
				if (t.type.equals(Token.LEFT_CURLY_B)) {
					t = TokenQueue.getToken();
					if (t.type.equals(Token.PUBLIC)) {
						t = TokenQueue.getToken();
						if (t.type.equals(Token.STATIC)) {
							t = TokenQueue.getToken();
							if (t.type.equals(Token.VOID)) {
								t = TokenQueue.getToken();
								if (t.type.equals(Token.MAIN)) {
									t = TokenQueue.getToken();
									if (t.type.equals(Token.LEFT_ROUND_B)) {
										t = TokenQueue.getToken();
										if (t.type.equals(Token.STRING)) {
											t = TokenQueue.getToken();
											if (t.type.equals(Token.LEFT_SQUARE_B)) {
												t = TokenQueue.getToken();
												if (t.type.equals(Token.RIGHT_SQUARE_B)) {
													t = TokenQueue.getToken();
													if (t.type.equals(Token.IDENTIFIER)) {
														main_class.setId2(t.value);
														t = TokenQueue.getToken();
														if (t.type.equals(Token.RIGHT_ROUND_B)) {
															t = TokenQueue.getToken();
															if (t.type.equals(Token.LEFT_CURLY_B)) {
																t = TokenQueue.getToken();
																Statement statement = RuleSelector.select();
																// statement.parse();
																// TokenQueue.index++;

																if (t.type.equals(Token.RIGHT_CURLY_B)) {
																	t = TokenQueue.getToken();
																	if (t.type.equals(Token.RIGHT_CURLY_B)) {
																		main_class.setSt(statement);
																		return main_class;
																	} else {
																		System.out.println(
																				"Error : Expected " + t.type + " Type");
																		return null;
																	}
																} else {
																	System.out.println(
																			"Error : Expected " + t.type + " Type");
																	return null;
																}
															} else {
																System.out.println(
																		"Error : Expected " + t.type + " Type");
																return null;
															}
														} else {
															System.out.println("Error : Expected " + t.type + " Type");
															return null;
														}
													} else {
														System.out.println("Error : Expected " + t.type + " Type");
														return null;
													}
												} else {
													System.out.println("Error : Expected " + t.type + " Type");
													return null;
												}
											} else {
												System.out.println("Error : Expected " + t.type + " Type");
												return null;
											}
										} else {
											System.out.println("Error : Expected " + t.type + " Type");
											return null;
										}
									} else {
										System.out.println("Error : Expected " + t.type + " Type");
										return null;
									}
								} else {
									System.out.println("Error : Expected " + t.type + " Type");
									return null;
								}
							} else {
								System.out.println("Error : Expected " + t.type + " Type");
								return null;
							}
						} else {
							System.out.println("Error : Expected " + t.type + " Type");
							return null;
						}
					} else {
						System.out.println("Error : Expected " + t.type + " Type");
						return null;
					}

				} else {
					System.out.println("Error : Expected " + t.type + " Type");
					return null;
				}

			} else {
				System.out.println("Error : Expected " + t.type + " Type");
				return null;
			}
		} else {
			System.out.println("Error : Expected " + t.type + " Type");
			return null;
		}
		// return main_class;
	}

	@Override
	public String getValue() {
		String result = new String("");
		result += classString + " " + this.id + " " + leftB + publicString + " " + staticString + " " + voidString + " "
				+ mainString + " " + leftR + StringS + leftS + rightS + id2 + rightB + leftB2 +
				// st.getValue()
				rightB2 + rightB3;
		return result;
	}

	@Override
	public void setStatement(Statement statement) {
		// TODO Auto-generated method stub

	}

}
