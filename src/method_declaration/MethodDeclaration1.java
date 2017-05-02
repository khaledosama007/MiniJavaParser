package method_declaration;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import expression.Expression;
import gui_module.Visitor;
import parameters.Parameter;
import parameters.Parameters1;
import parser.Token;
import parser.TokenQueue;
import statement.RuleSelector;
import statement.Statement;
import symbols.RegularType;
import type.Type;
import type.TypeSelector;
import var_declaration.VarDeclaration;
import var_declaration.VarDeclaration1;

public class MethodDeclaration1 implements MethodDeclaration {

	final public String PUBLIC = "public";
	final public String PRIVATE = "private";
	// (public | private )
	public String access;
	public Type type;
	public String id;
	final public String leftB = "(";
	public Parameter parameter;

	final public String rightB = ")";
	final public String leftC = "{";
	public ArrayList<VarDeclaration> varDeclaration = new ArrayList<>();
	public ArrayList<Statement> stmt = new ArrayList<>();
	// ( VarDeclaration )*
	// ( Statement )*
	final public String RETURN = "return";
	public Expression exp;
	final public String semicolon = ";";
	final public String leftB2 = "}";
	boolean isParam;

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
		result += PUBLIC + " " + 
		type.getValue() + " " + 
				id + " " + leftB + 
				parameter.getValue() + rightB + leftC;
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
		Parameters1 params = new Parameters1();
		ArrayList<VarDeclaration> vard = new ArrayList<>() ;
		ArrayList<Statement>stmt = new ArrayList<>();
		//Expression expression;
		Token token = TokenQueue.getToken();
		if (token.type.equals(Token.PUBLIC)) {
			methodDeclaration1.access = methodDeclaration1.PUBLIC;
		} else if (token.type.equals(Token.PRIVATE)) {
			methodDeclaration1.access = methodDeclaration1.PRIVATE;
		}
		else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		//token = TokenQueue.getToken();
		Type returnType = TypeSelector.select();
		if (returnType == null) {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		returnType = returnType.parse();
		methodDeclaration1.type = returnType;
		token = TokenQueue.getToken();
		if (token.type.equals(Token.IDENTIFIER)) {
			methodDeclaration1.id = token.value;
			token = TokenQueue.getToken();
		} else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		
		if (token.type.equals(Token.LEFT_ROUND_B)) {
			//token = TokenQueue.getToken();
		}
		else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		//NO parameters
		if(token.type.equals(Token.RIGHT_ROUND_B))
		{	isParam = false;
			token = TokenQueue.getToken();
		}
		else if(RegularType.isRegular(TokenQueue.top().value)){
			isParam = true;
			if(RegularType.isRegular(TokenQueue.top().value)){
				Parameters1 temp = new Parameters1();
				temp = temp.parse();
				methodDeclaration1.parameter = temp;
				token = TokenQueue.getToken();
			}
		}
		else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		if(token.type.equals(Token.RIGHT_ROUND_B) && isParam)
		{	isParam = false;
			token = TokenQueue.getToken();
		}else if (!token.type.equals(Token.RIGHT_ROUND_B) && isParam) {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		if (token.type.equals(Token.LEFT_CURLY_B)) {
			//token = TokenQueue.getToken();
		}
		else{ 
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		while (RegularType.isRegular(TokenQueue.top().value)) {
			VarDeclaration1 vard1 = new VarDeclaration1();
			vard1 = vard1.parse();
			methodDeclaration1.varDeclaration.add(vard1);
			token = TokenQueue.getToken();
		}
		while (token.type.equals(Token.LEFT_CURLY_B) || token.type.equals(Token.IF)
				|| token.type.equals(Token.WHILE) || token.type.equals(Token.SOP)
				|| token.type.equals(Token.IDENTIFIER)) {
			Statement tempst = RuleSelector.select();
			methodDeclaration1.stmt.add(tempst);
			token =TokenQueue.getToken();
		}
		if (token.type.equals(Token.RETURN)) {
			//token = TokenQueue.getToken();
		}
		else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		Expression ex = expression.RuleSelector.select(TokenQueue.top());
		if(ex != null){
			methodDeclaration1.exp = ex;
			token = TokenQueue.getToken();
		}
		else{ 
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		if (token.type.equals(Token.SEMICOLON)) {
			token = TokenQueue.getToken();
		}
		else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		if (token.type.equals(Token.RIGHT_CURLY_B)) {
				return methodDeclaration1;
		}
		else {
			System.out.println("Expected " + token.type + " Type");
			return null;
		}
		/////////////////////////////////////////
		
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
		for (int i = 0; i < varDeclaration.size(); i++) {
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(varDeclaration.get(i).getNode());
			root.add(temp);
		}
		// for (int i=0 ; i<stmt.size() ; i++){
		// DefaultMutableTreeNode temp = new
		// DefaultMutableTreeNode(stmt.get(i).getNode());
		// root.add(temp);
		// }
		root.add(new DefaultMutableTreeNode(RETURN));
		// root.add(new DefaultMutableTreeNode(exp.getNode()));
		root.add(new DefaultMutableTreeNode(semicolon));
		root.add(new DefaultMutableTreeNode(leftB2));
		return root;
	}
}
