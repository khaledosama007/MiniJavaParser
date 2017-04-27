package class_declaration;

import java.util.ArrayList;

import declaration.Declaration;
import declaration.RuleSelector;
import parser.Token;
import parser.TokenQueue;

public class ClassDeclaration1 implements ClassDeclaration {

	final String classString = "class";
	public String id1;
	public String extendsString = "extends";
	public String id2;
	final String leftC = "{";
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
			res += " " + classString + " " + id1 + " " + extendsString + " " + id2 + leftC;
		}
		for (int i = 0; i < declartion.size(); i++) {
			res += declartion.get(i).getValue();
		}
		res += rightC;
		return res;
	}

	public static ClassDeclaration parse() {
		ClassDeclaration1 cd = new ClassDeclaration1();
		Token current = TokenQueue.queue.get(TokenQueue.index);
		if (current.type.equals(Token.CLASS)) {
			TokenQueue.index++;
			current = TokenQueue.queue.get(TokenQueue.index);
			if (current.type.equals(Token.IDENTIFIER)) {
					
					TokenQueue.index++;
					current = TokenQueue.queue.get(TokenQueue.index);
					if(current.type.equals(Token.EXTENDS)){
						cd.id1 = current.value;
						TokenQueue.index++;
						current = TokenQueue.queue.get(TokenQueue.index);
						if(current.type.equals(Token.IDENTIFIER)){
							cd.id2 = current.value;
							
						}
					}
					else { cd.extendsString=null;cd.id2=null;TokenQueue.index--; }
					
			}
			TokenQueue.index++;
			current = TokenQueue.queue.get(TokenQueue.index);
			if(current.type.equals(Token.LEFT_CURLY_B)){
				TokenQueue.index++;
				current = TokenQueue.queue.get(TokenQueue.index);
				if(!current.type.equals(Token.RIGHT_CURLY_B)){
					ArrayList<Declaration> decs = new ArrayList<>();
					do{
						Declaration tempD = RuleSelector.select();
						tempD.parse();
						decs.add(tempD);
						TokenQueue.index++;
						current = TokenQueue.queue.get(TokenQueue.index);
					}while(!current.type.equals(Token.RIGHT_CURLY_B));
					cd.declartion = decs;
				}
				return cd;
				
			}
		}
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

}
