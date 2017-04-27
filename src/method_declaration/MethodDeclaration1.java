package method_declaration;

import java.util.ArrayList;

import expression.Expression;
import parameters.Parameter;
import parser.Token;
import parser.TokenQueue;
import statement.Statement;
import type.Type;
import type.TypeSelector;
import var_declaration.VarDeclaration;

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

	public MethodDeclaration1(String access,Type type, String id, Parameter parameter, ArrayList<VarDeclaration> varDeclaration,
			ArrayList<Statement> stmt, Expression exp) {
		super();
		if(access.equals(PUBLIC)){
			this.access = PUBLIC;
		}
		else {
			this.access=PRIVATE;
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
		result+=PUBLIC+" "+type.getValue()+" "+id+" "+leftB+parameter.getValue()+rightB+leftC;
		for(int i=0 ; i<varDeclaration.size() ; i++){
			result+=varDeclaration.get(i).getValue();
		}
		for(int i=0 ; i<stmt.size() ; i++){
			result+=stmt.get(i).getValue();
		}
		result+=RETURN+exp.getValue()+semicolon+leftB2;
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
		if(token.type.equals(Token.PUBLIC)){
			methodDeclaration1.access = methodDeclaration1.PUBLIC;
		}
		else {
			methodDeclaration1.access = methodDeclaration1.PRIVATE;
		}
		//TokenQueue.index++;
		//token = TokenQueue.queue.get(TokenQueue.index);
		Type type = TypeSelector.select();
		methodDeclaration1.type =type;
		TokenQueue.index++;
		token = TokenQueue.queue.get(TokenQueue.index);
		if(token.type.equals(Token.IDENTIFIER)){
			methodDeclaration1.id = token.value;
			TokenQueue.index++;
			token = TokenQueue.queue.get(TokenQueue.index);
			
		}
		return null;
	}

}
