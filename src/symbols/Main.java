package symbols;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

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
import gui_module.TreeNodeVisitor;
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

    public static ArrayList<Token> readFromFile(String fileName) throws IOException {
		FileInputStream inputFile = null;
		BufferedReader bufferReader = null;
		ArrayList<Token> inputArrayList=new ArrayList<>();

		String line = null;
		try {
			inputFile = new FileInputStream(fileName);
			bufferReader = new BufferedReader(new InputStreamReader(inputFile));
			line = bufferReader.readLine();
			while (line != null) {
				if(line.contains("EOL"))
				{
					inputArrayList.add(new Token("EOL", "\n"));
					line = bufferReader.readLine();
					line = bufferReader.readLine();
				}
				if(line.contains("< ")){
				String [] splitString =line.split(" > : -");
				String type = splitString[0].replace("< ", "");
				String value = splitString[1].replace("-", "");
				inputArrayList.add(new Token(type, value));
				}
				line = bufferReader.readLine();
			}

		} finally {
			if (line == null) {
				bufferReader.close();
				inputFile.close();
			}
		}
            return inputArrayList;
	}
	public static void main(String[] args) throws IOException {
		
		/*ArrayList<Token> inputArrayList = readFromFile("Lex_test_4_ans.txt");
		for (int i=0 ;i<inputArrayList.size();i++)
		{
			System.out.println(inputArrayList.get(i).type + " = " + inputArrayList.get(i).value );
		}*/


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
		q.add(new Token("RIGHT_ROUND_B" , ")"));
		q.add(new Token("LEFT_CURLY_B" , "{"));
		//q.add(new Token("INT" , "int"));
		//q.add(new Token("IDENTIFIER" , "x"));
		//q.add(new Token("SEMICOLON" , ";"));
		q.add(new Token("RIGHT_CURLY_B" , "}"));
		q.add(new Token("RIGHT_CURLY_B" , "}"));
		
		q.add(new Token("CLASS" , "class"));
		q.add(new Token("IDENTIFIER" , "MyC"));
		q.add(new Token("EXTENDS" , "extends"));
		q.add(new Token("IDENTIFIER" , "MyCC"));
		q.add(new Token("LEFT_CURLY_B" , "{"));
//		q.add(new Token("PUBLIC" , "public"));
//		q.add(new Token("INT" , "int"));
//		q.add(new Token("IDENTIFIER" , "ComputeFac"));
//		q.add(new Token("LEFT_ROUND_B" , "("));
//		q.add(new Token("STRING" , "String"));
//		q.add(new Token("IDENTIFIER" , "x"));
//		q.add(new Token("RIGHT_ROUND_B" , ")"));
//		q.add(new Token("LEFT_CURLY_B" , "{"));
		q.add(new Token("INT" , "int"));
		q.add(new Token("LEFT_SQUARE_B" , "["));
		q.add(new Token("RIGHT_SQUARE_B" , "]"));
		q.add(new Token("IDENTIFIER" , "x"));
		q.add(new Token("SEMICOLON" , ";"));
		q.add(new Token("RIGHT_CURLY_B" , "}"));
		//q.add(new Token("RETURN" , "return"));
		t.queue = q;
		Parser p = new Parser();
		Goal g = p.parse();
//		DefaultMutableTreeNode root = new DefaultMutableTreeNode("ROOT");
//		JTree tree = new JTree(root);
//		//tree.add(root);
//		JFrame frame = new JFrame("Tree");
//		frame.add(tree);
//		frame.setVisible(true);
		TreeNodeVisitor visitor = new TreeNodeVisitor();
		visitor.visit(g);
		visitor.showTree();
		//System.out.println(g.getValue());
		//Goal g = p.parse();
		//System.out.println(g.getValue());*/

		
	}
	

}
