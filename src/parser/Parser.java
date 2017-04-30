package parser;

import java.util.ArrayList;
import java.util.List;

import class_declaration.ClassDeclaration;
import class_declaration.ClassDeclaration1;
import goal.Goal;
import goal.GoalStart;
import main_class.MainClass;
import main_class.MainClass1;
import statement.RuleSelector;
import statement.Statement;
import symbols.EOF;

public class Parser {
	public Goal parse() {
		// Token t = TokenQueue.queue.poll();
		MainClass1 main = new MainClass1();
		main = main.parse();
		ArrayList<ClassDeclaration> classDeclars = new ArrayList<>();
		if (TokenQueue.index < TokenQueue.queue.size()) {

			while (TokenQueue.queue.get(TokenQueue.index).type.equals(Token.CLASS)) {
				ClassDeclaration1 cd = new ClassDeclaration1();
				cd = cd.parse();
				classDeclars.add(cd);
				if (TokenQueue.index >= TokenQueue.queue.size()) {
					break;
				}
			}
		}
		EOF e = new EOF();
		Goal g = new GoalStart(main, classDeclars, e);
		return g;
	}

}
