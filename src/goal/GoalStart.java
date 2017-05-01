package goal;

import java.util.ArrayList;

import class_declaration.ClassDeclaration;
import gui_module.Visitor;
import main_class.MainClass;
import symbols.EOF;

public class GoalStart implements Goal {

	public MainClass mainClass;

	public ArrayList<ClassDeclaration> classDeclaration;

	public EOF eof;
	
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
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
