package gui_module;

import javax.swing.tree.DefaultMutableTreeNode;

import array_type.ArrayType;
import class_declaration.ClassDeclaration;
import declaration.Declaration;
import dot_expression.Dot_Expression;
import expression.Expression;
import expression_alpha.Expression_Alpha;
import goal.Goal;
import identifier_statement.Identifier_Statement;
import main_class.MainClass;
import method_declaration.MethodDeclaration;
import new_expression.New_Expression;
import parameters.Parameter;
import statement.Statement;
import type.Type;
import var_declaration.VarDeclaration;

public interface Visitor {
	public DefaultMutableTreeNode visit(ArrayType arrType);
	public DefaultMutableTreeNode visit(ClassDeclaration cd);
	public DefaultMutableTreeNode visit(Declaration declaration);
	public DefaultMutableTreeNode visit(Expression exp);
	public DefaultMutableTreeNode visit(Expression_Alpha ea);
	public DefaultMutableTreeNode visit(Goal goal);
	public DefaultMutableTreeNode visit(Identifier_Statement statement);
	public DefaultMutableTreeNode visit(MainClass mainc);
	public DefaultMutableTreeNode visit(MethodDeclaration method);
	public DefaultMutableTreeNode visit(New_Expression newex);
	public DefaultMutableTreeNode visit(Parameter params);
	public DefaultMutableTreeNode visit(Statement st);
	public DefaultMutableTreeNode visit(Type type);
	public DefaultMutableTreeNode visit(VarDeclaration vard	);
	public DefaultMutableTreeNode visit(Dot_Expression exp );
	
	
}
