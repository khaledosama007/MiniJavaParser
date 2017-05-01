package main_class;

import javax.swing.tree.DefaultMutableTreeNode;

import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;
import statement.RuleSelector;
import statement.Statement;

public class MainClass1 implements MainClass {

	public  final String classString = "class";
	public String id = new String("");
	public  final String leftB = "{";
	public  final String publicString = "public";
	public final String staticString = "static";
	public final String voidString = "void";
	public final String mainString = "main";
	public final String leftR = "(";
	public final String StringS = "String";
	public final String leftS = "[";
	public final String rightS = "]";
	public String id2 = new String("");
	public final String rightB = ")";
	public final String leftB2 = "{";
	public Statement st;
	public final String rightB2 = "}";
	public final String rightB3 = "}";

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
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Main Class");
		node.add(new DefaultMutableTreeNode("class"));
		if(!id.equals(null)){
			node.add(new DefaultMutableTreeNode(id));
		}
		node.add(new DefaultMutableTreeNode(leftB));
		node.add(new DefaultMutableTreeNode(publicString));
		node.add(new DefaultMutableTreeNode(staticString));
		node.add(new DefaultMutableTreeNode(voidString));
		node.add(new DefaultMutableTreeNode(mainString));
		node.add(new DefaultMutableTreeNode(leftR));
		node.add(new DefaultMutableTreeNode(StringS));
		node.add(new DefaultMutableTreeNode(leftS));
		node.add(new DefaultMutableTreeNode(rightS));
		if(!id2.equals(null)){
			node.add(new DefaultMutableTreeNode(id2));
		}
		node.add(new DefaultMutableTreeNode(rightB));
		node.add(new DefaultMutableTreeNode(leftB2));
		//node.add(new DefaultMutableTreeNode(rightS));//STAEMENT
		node.add(new DefaultMutableTreeNode(rightB2));
		node.add(new DefaultMutableTreeNode(rightB3));
		return node;
	}
}
