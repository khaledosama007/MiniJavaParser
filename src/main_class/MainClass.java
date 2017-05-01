package main_class;

import gui_module.Visitable;
import statement.Statement;

public interface MainClass extends Visitable {
	public void print();
	public String getValue();
	public void setId(String value);
	public void setId2(String value);
	public void setStatement(Statement statement);
	public void setSt(Statement statement);
}
