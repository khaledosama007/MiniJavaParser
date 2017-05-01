package goal;

import java.util.ArrayList;

import class_declaration.ClassDeclaration;
import main_class.MainClass;
import symbols.EOF;

public class GoalStart implements Goal {

	MainClass mainClass;

	ArrayList<ClassDeclaration> classDeclaration;

	EOF eof;
	
	public GoalStart(MainClass mainClass, ArrayList<ClassDeclaration> cd, EOF eof) {
		super();
		this.mainClass = mainClass;
		this.classDeclaration = cd;
		this.eof = eof;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue() {
		String result = new String("");
		result+=mainClass.getValue();
			for(int i=0 ; i<classDeclaration.size(); i++)
				result+=classDeclaration.get(i).getValue();
		return result;
	}

}
