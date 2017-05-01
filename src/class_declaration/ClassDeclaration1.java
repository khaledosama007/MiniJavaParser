package class_declaration;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import declaration.Declaration;
import declaration.RuleSelector;
import gui_module.Visitor;
import parser.Token;
import parser.TokenQueue;
import symbols.RegularType;

public class ClassDeclaration1 implements ClassDeclaration {
	// region ss
	final String classString = "class";
	public String id1;
	public String extendsString = "extends";
	public String id2;
	final String leftC = "{";
	// endregion ss
	public ArrayList<Declaration> declartion;
	// (Declaration)*
	final String rightC = "}";

	public ClassDeclaration1(String id1, String id2, ArrayList<Declaration> declartion) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.declartion = declartion;
	}

	public ClassDeclaration1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getValue() {
		String res = new String("");
		if (id2.equals("")) {
			
			res += " " + classString + " " + id1 + leftC;
		} else {
			System.out.println(id1);
			res += " " + classString + " " + id1 + " " + extendsString + " " + id2 + leftC;
		}
		for (int i = 0; i < declartion.size(); i++) {
			res += declartion.get(i).getValue();
		}
		res += rightC;
		return res;
	}

	public  ClassDeclaration1 parse() {
		ClassDeclaration1 cd = new ClassDeclaration1();
		Token current = TokenQueue.getToken();
		if (current.type.equals(Token.CLASS)) {
			current = TokenQueue.getToken();
			if (current.type.equals(Token.IDENTIFIER)) {
				cd.id1=current.value;
				cd = (ClassDeclaration1) handleExtend(cd, current);
			} //ID Handling
			else {
				System.out.println("Error : expected " + current.type + " Type");
				return null;
			}
		}

		// class Handling
		else {
			System.out.println("Error : expected " + current.type + " Type");
			return null;
		}
		return cd;

	}

	private static ClassDeclaration handleExtend(ClassDeclaration1 cd, Token current) {
		ArrayList<Declaration> returnDeclaration = new ArrayList<>();
		current = TokenQueue.getToken();
		System.out.println(current.type);
		if (current.type.equals(Token.EXTENDS)) {
			current = TokenQueue.getToken();
			if (current.type.equals(Token.IDENTIFIER)) {
				cd.id2 = current.value;
				current = TokenQueue.getToken();
				if (current.type.equals(Token.LEFT_CURLY_B)) {
					cd.declartion = callDeclaration(current);
					current = TokenQueue.getToken();
					if (current.type.equals(Token.RIGHT_CURLY_B)) {
							return cd;
					}
					else {
						System.out.println("Error : expected " + current.type + " Type but found ");
						return null;
					}
				}//Handle LCB
				else {
					System.out.println("Error : expected " + current.type + " Type");
					return null;
				}
			}//Handle ID
			else {
				
				System.out.println("Error : expected " + current.type + " Type");
				return null;
			}
		} else if (current.type.equals(Token.LEFT_CURLY_B)) {
			cd.extendsString = null;
			cd.id2 = null;
			cd.declartion = callDeclaration(current);
			current = TokenQueue.queue.get(TokenQueue.index);
			if (current.type.equals(Token.RIGHT_CURLY_B)) {
					return cd;
			}
			else {
				System.out.println("Error : expected " + current.type + " Type");
				return null;
			}
			
		} //Not extend or '{'
		else {
			System.out.println("Error : expected " + current.type + " Type");
			return null;
		}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Declaration> callDeclaration(Token current) {
		ArrayList<Declaration> decs = new ArrayList<>();
		current = TokenQueue.top();
		while (RegularType.isRegular(current.value) || current.type.equals(Token.PUBLIC) ||
				current.type.equals(Token.PRIVATE))
		 {
			Declaration tempD = RuleSelector.select();
			tempD = tempD.parse();
			decs.add(tempD);
			current = TokenQueue.top();
		} 
		return decs;
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Class Declaration");
		root.add(new DefaultMutableTreeNode(classString));
		if(!id1.equals(null)){
			root.add(new DefaultMutableTreeNode(id1));
		}
		if(!extendsString.equals(null)){
			root.add(new DefaultMutableTreeNode(extendsString));
		}
		if(!id2.equals(null)){
			root.add(new DefaultMutableTreeNode(id2));
		}
		root.add(new DefaultMutableTreeNode(leftC));
		for(int i=0 ; i<declartion.size() ; i++){
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
			temp = declartion.get(i).getNode();
			root.add(temp);
		}
		root.add(new DefaultMutableTreeNode(rightC));
		return root;
	}
}
