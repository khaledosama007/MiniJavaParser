package gui_module;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import array_type.ArrayType;
import array_type.ArrayType1;
import class_declaration.ClassDeclaration;
import class_declaration.ClassDeclaration1;
import declaration.Declaration;
import expression.Expression;
import expression_alpha.Expression_Alpha;
import goal.Goal;
import goal.GoalStart;
import identifier_statement.Identifier_Statement;
import main_class.MainClass;
import main_class.MainClass1;
import method_declaration.MethodDeclaration;
import new_expression.New_Expression;
import parameters.Parameter;
import statement.Statement;
import symbols.EOF;
import type.Type;
import var_declaration.VarDeclaration;

public class TreeNodeVisitor implements Visitor {
	public JTree tree;
	DefaultMutableTreeNode root;
	public  TreeNodeVisitor() {
		root = new DefaultMutableTreeNode("Root");
		tree = new JTree(root);
	}
	@Override
	public DefaultMutableTreeNode visit(ArrayType arrType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(ClassDeclaration cd) {
		// TODO Auto-generated method stub
		ClassDeclaration1 cd1 = (ClassDeclaration1) cd;
		return cd1.getNode();
	}

	@Override
	public DefaultMutableTreeNode visit(Declaration declaration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Expression exp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Expression_Alpha ea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Goal goal) {
		DefaultMutableTreeNode goalroot = new DefaultMutableTreeNode("Goal");
		GoalStart g = (GoalStart) goal;
		DefaultMutableTreeNode mainClass = new DefaultMutableTreeNode();
		mainClass = this.visit(g.mainClass);
		goalroot.add(mainClass);
		if(g.classDeclaration.size()!=0){
			for(int i=0 ; i<g.classDeclaration.size() ; i++){
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
			temp = this.visit(g.classDeclaration.get(i));
			goalroot.add(temp);
			}
		}
		goalroot.add(new DefaultMutableTreeNode("EOF"));
		root.add(goalroot);
		return goalroot;
	}

	@Override
	public DefaultMutableTreeNode visit(Identifier_Statement statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(MainClass mainc) {
		MainClass1 mc = (MainClass1) mainc;
		DefaultMutableTreeNode node = new DefaultMutableTreeNode();
		node = mc.getNode();
		
		return node;
	}

	@Override
	public DefaultMutableTreeNode visit(MethodDeclaration method) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(New_Expression newex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Parameter params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Statement st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(VarDeclaration vard) {
		// TODO Auto-generated method stub
		return null;
	}
	public void showTree(){
		JFrame frame = new JFrame("Tree");
		
		JPanel panel = new JPanel();

		// add something to you panel...
		// panel.add(...);

		// add the panel to a JScrollPane
		JScrollPane jScrollPane = new JScrollPane(panel);
		// only a configuration to the jScrollPane...
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Then, add the jScrollPane to your frame
		frame.getContentPane().add(jScrollPane);
		frame.add(tree);
		frame.setVisible(true);
	}
	
}
