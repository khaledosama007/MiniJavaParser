package goal;

import class_declaration.ClassDeclaration;
import main_class.MainClass;
import symbols.EOF;

public class GoalStart implements Goal {

	MainClass mainClass;

	ClassDeclaration classDeclaration;

	EOF eof;
	
	public GoalStart(MainClass mainClass, ClassDeclaration classDeclaration, EOF eof) {
		super();
		this.mainClass = mainClass;
		this.classDeclaration = classDeclaration;
		this.eof = eof;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue() {
		String result = new String("");
		result+=mainClass.getValue()+
				classDeclaration.getValue();
		return result;
	}

}
