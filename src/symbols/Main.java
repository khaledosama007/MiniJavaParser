package symbols;

import java.util.ArrayList;

import class_declaration.ClassDeclaration;
import class_declaration.ClassDeclaration1;
import declaration.Declaration;
import declaration.Declaration2;
import dot_expression.Dot_Expression;
import dot_expression.Dot_Expression2;
import expression.Expression;
import expression.Expression1;
import expression.Expression4;
import expression.Expression6;
import expression_alpha.Expression_Alpha;
import expression_alpha.Expression_Alpha1;
import expression_alpha.Expression_Alpha3;
import expression_alpha.Expression_Alpha4;
import goal.Goal;
import goal.GoalStart;
import identifier_statement.Identifier_Statement;
import identifier_statement.Identifier_Statement1;
import main_class.MainClass;
import main_class.MainClass1;
import method_declaration.MethodDeclaration;
import method_declaration.MethodDeclaration1;
import new_expression.New_Expression;
import new_expression.New_Expression2;
import parameters.Parameter;
import parameters.Parameters1;
import parser.Parser;
import parser.Token;
import parser.TokenQueue;
import statement.Statement;
import statement.Statement2;
import statement.Statement4;
import statement.Statement5;
import type.Type;
import type.Type1;
import var_declaration.VarDeclaration;
import var_declaration.VarDeclaration1;

public class Main {

	public static void main(String[] args) {
		/*Expression[] arr = new Expression[1];
		// TODO Auto-generated method stub
		Expression_Alpha lamda = new Expression_Alpha4();
		Expression e_int =new Expression1(10, lamda);
		New_Expression nex = new New_Expression2("Fac");
		arr[0]= e_int;
		Dot_Expression de = new Dot_Expression2("ComputeFac", arr);
		Expression_Alpha ea = new Expression_Alpha3(de , lamda);
		Expression ex1 = new Expression6(nex,ea);
		Statement st = new Statement4(ex1);
		MainClass mc = new MainClass1("Factorial", "a", st);
		////////////////////////////////////////////////////////////
		ArrayList<Type> art = new ArrayList<>();
		ArrayList<String> srt = new ArrayList<>();
		art.add(new Type1 (RegularType.INT));
		srt.add(new String("num"));
		Parameter pr = new Parameters1(art, srt);
		Type type = new Type1(RegularType.INT);
		
		ArrayList<VarDeclaration> vars = new ArrayList<>();
		VarDeclaration vard = new VarDeclaration1(new Type1(RegularType.INT), "num_aux");
		
		Expression_Alpha ifco = new Expression_Alpha1(lamda, new Expression1(6,lamda), '<');
		Expression if1=new Expression4("num", ifco); 
		ArrayList<Statement> stmts = new ArrayList<>();
		ArrayList<VarDeclaration> varArr = new ArrayList<>();
		Expression integ = new Expression1(1 , lamda);
		Identifier_Statement idst = new Identifier_Statement1(integ);
		Statement stmtif1 = new Statement5("num_aux" ,idst );
		Statement stmtif2 = new Statement5("num+auxz", idst);
		Statement st1 = new Statement2(if1 ,stmtif1 , stmtif2);
		stmts.add(st1);
		Expression ret = new Expression4("num_aux", lamda);
		MethodDeclaration md = new MethodDeclaration1("public", type, "ComputeFac", pr, varArr, stmts, ret);
		Declaration dc = new Declaration2(md);
		ArrayList<Declaration> arrd = new ArrayList<>();
		arrd.add(dc);
		ClassDeclaration cd = new ClassDeclaration1("Fac", "", arrd);
		Goal g = new GoalStart(mc,cd , new EOF());
		
		System.out.println(g.getValue());*/
		ArrayList<Token> q=new ArrayList<>();
		TokenQueue t = new TokenQueue();
		//test case
		q.add(new Token("CLASS" , "class"));
		q.add(new Token("IDENTIFIER" , "MyC"));
		//q.add(new Token("INT" , "int"));
		q.add(new Token("LEFT_CURLY_B" , "{"));
		q.add(new Token("PUBLIC" , "public"));
		q.add(new Token("STATIC" , "static"));
		q.add(new Token("VOID" , "void"));
		q.add(new Token("MAIN" , "main"));
		q.add(new Token("LEFT_ROUND_B" , "("));
		q.add(new Token("STRING" , "String"));
		q.add(new Token("LEFT_SQUARE_B" , "["));
		q.add(new Token("RIGHT_SQUARE_B" , "]"));
		q.add(new Token("IDENTIFIER" , "a"));
		q.add(new Token("LEFT_ROUND_B" , ")"));
		q.add(new Token("LEFT_CURLY_B" , "{"));
		q.add(new Token("INT" , "int"));
		q.add(new Token("IDENTIFIER" , "x"));
		q.add(new Token("SEMICOLON" , ";"));
		q.add(new Token("RIGHT_CURLY_B" , "}"));
		q.add(new Token("RIGHT_CURLY_B" , "}"));
		
		t.queue = q;
		Parser p = new Parser();
		Goal g = p.parse();
		System.out.println(g.getValue());
		
	}
	

}