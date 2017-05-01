package method_declaration;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import expression.Expression;
import gui_module.Visitor;
import parameters.Parameter;
import parameters.Parameters1;
import parser.Token;
import parser.TokenQueue;
import statement.Statement;
import symbols.RegularType;
import type.Type;
import type.TypeSelector;
import var_declaration.VarDeclaration;
import var_declaration.VarDeclaration1;

public class MethodDeclaration1 implements MethodDeclaration {

	final String PUBLIC = "public";
	final String PRIVATE = "private";
	// (public | private )
	String access;
	Type type;
	String id;
	final String leftB = "(";
	Parameter parameter;

	final String rightB = ")";
	final String leftC = "{";
	ArrayList<VarDeclaration> varDeclaration;
	ArrayList<Statement> stmt;
	// ( VarDeclaration )*
	// ( Statement )*
	final String RETURN = "return";
	Expression exp;
	final String semicolon = ";";
	final String leftB2 = "}";

	public MethodDeclaration1(String access, Type type, String id, Parameter parameter,
			ArrayList<VarDeclaration> varDeclaration, ArrayList<Statement> stmt, Expression exp) {
		super();
		if (access.equals(PUBLIC)) {
			this.access = PUBLIC;
		} else {
			this.access = PRIVATE;
		}
		this.type = type;
		this.id = id;
		this.parameter = parameter;
		this.varDeclaration = varDeclaration;
		this.stmt = stmt;
		this.exp = exp;
	}

	public MethodDeclaration1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getValue() {
		String result = new String("");
		result += PUBLIC + " " + type.getValue() + " " + id + " " + leftB + parameter.getValue() + rightB + leftC;
		for (int i = 0; i < varDeclaration.size(); i++) {
			result += varDeclaration.get(i).getValue();
		}
		for (int i = 0; i < stmt.size(); i++) {
			result += stmt.get(i).getValue();
		}
		result += RETURN + exp.getValue() + semicolon + leftB2;
		return result;
	}

	@Override
	public MethodDeclaration parse() {
		// TODO Auto-generated method stub
		MethodDeclaration1 methodDeclaration1 = new MethodDeclaration1();
		ArrayList<Parameter> params = new ArrayList<>();
		VarDeclaration vard;
		Statement stmt;
		Expression expression;
		Token token = TokenQueue.queue.get(TokenQueue.index);
		if (token.type.equals(Token.PUBLIC)) {
			methodDeclaration1.access = methodDeclaration1.PUBLIC;
		} else {
			methodDeclaration1.access = methodDeclaration1.PRIVATE;
		}
		TokenQueue.index++;
		token = TokenQueue.queue.get(TokenQueue.index);
		if (RegularType.isRegular(token.value) || token.type.equals(Token.LEFT_SQUARE_B)) {
			Type type = TypeSelector.select();
			type = type.parse();
			// TokenQueue.index++;
			token = TokenQueue.queue.get(TokenQueue.index);
			if (token.type.equals(Token.IDENTIFIER)) {
				id = token.value;
				TokenQueue.index++;
				token = TokenQueue.queue.get(TokenQueue.index);
				if (token.type.equals(Token.LEFT_ROUND_B)) {
					TokenQueue.index++;
					token = TokenQueue.queue.get(TokenQueue.index);
					while (RegularType.isRegular(token.value)) {
						Parameters1 p = new Parameters1();
						p = p.parse();
						params.add(p);
						TokenQueue.index++;
					}
					if (token.type.equals(Token.RIGHT_ROUND_B)) {
						TokenQueue.index++;
						token = TokenQueue.queue.get(TokenQueue.index);
						if (token.type.equals(Token.LEFT_CURLY_B)) {
							TokenQueue.index++;
							token = TokenQueue.queue.get(TokenQueue.index);
							while (RegularType.isRegular(token.value)) {
								VarDeclaration1 vard1 = new VarDeclaration1();
								vard1 = vard1.parse();
								methodDeclaration1.varDeclaration.add(vard1);
							}
							token = TokenQueue.queue.get(TokenQueue.index);
							while (token.type.equals(Token.LEFT_CURLY_B) || token.type.equals(Token.IF)
									|| token.type.equals(Token.WHILE) || token.type.equals(Token.SOP)
									|| token.type.equals(Token.IDENTIFIER)) {
								// Statement Calls
								// Statement st =
							}
							token = TokenQueue.queue.get(TokenQueue.index);
							if (token.type.equals(Token.RETURN)) {
								///// Expression exp
								token = TokenQueue.queue.get(TokenQueue.index);
								if (token.type.equals(Token.SEMICOLON)) {
									TokenQueue.index++;
									token = TokenQueue.queue.get(TokenQueue.index);
									if (token.type.equals(Token.LEFT_CURLY_B)) {
										return methodDeclaration1;
									} else {
										System.out.println("Expected " + token.type + " Type");
										return null;
									}
								} else {
									System.out.println("Expected " + token.type + " Type");
									return null;
								}
							} else {
								System.out.println("Expected " + token.type + " Type");
								return null;
							}
						} else {
							System.out.println("Expected " + token.type + " Type");
							return null;
						}
					} else {
						System.out.println("Expected " + token.type + " Type");
						return null;
					}
				} else {
					System.out.println("Expected " + token.type + " Type");
					return null;
				}
			} else {
				System.out.println("Expected " + token.type + " Type");
				return null;
			}
		} else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}

		// methodDeclaration1.type =type;
		// TokenQueue.index++;
		// token = TokenQueue.queue.get(TokenQueue.index);
		// if(token.type.equals(Token.IDENTIFIER)){
		// methodDeclaration1.id = token.value;
		// TokenQueue.index++;
		// token = TokenQueue.queue.get(TokenQueue.index);
		//
		// }
		// return null;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Method Declaration");
		root.add(new DefaultMutableTreeNode(access));
		root.add(new DefaultMutableTreeNode(type.getNode()));
		root.add(new DefaultMutableTreeNode(id));
		root.add(new DefaultMutableTreeNode(leftB));
		if (parameter != null) {
			root.add(new DefaultMutableTreeNode(parameter.getNode()));
		}
		root.add(new DefaultMutableTreeNode(rightB));
		root.add(new DefaultMutableTreeNode(leftC));
		for (int i=0 ; i<varDeclaration.size() ; i++){
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(varDeclaration.get(i).getNode());
			root.add(temp);
		}
//		for (int i=0 ; i<stmt.size() ; i++){
//			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(stmt.get(i).getNode());
//			root.add(temp);
//		}
		root.add(new DefaultMutableTreeNode(RETURN));
		//root.add(new DefaultMutableTreeNode(exp.getNode()));
		root.add(new DefaultMutableTreeNode(semicolon));
		root.add(new DefaultMutableTreeNode(leftB2));
		return root;
	}
}
