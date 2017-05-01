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
import declaration.Declaration1;
import declaration.Declaration2;
import expression.Expression;
import expression_alpha.Expression_Alpha;
import goal.Goal;
import goal.GoalStart;
import identifier_statement.Identifier_Statement;
import main_class.MainClass;
import main_class.MainClass1;
import method_declaration.MethodDeclaration;
import method_declaration.MethodDeclaration1;
import new_expression.New_Expression;
import parameters.Parameter;
import parameters.Parameters1;
import statement.Statement;
import symbols.EOF;
import type.Type;
import type.Type1;
import type.Type2;
import var_declaration.VarDeclaration;
import var_declaration.VarDeclaration1;

public class TreeNodeVisitor implements Visitor {
	public JTree tree;
	DefaultMutableTreeNode root;
	public  TreeNodeVisitor() {
		root = new DefaultMutableTreeNode("Root");
		tree = new JTree(root);
	}
	@Override
	public DefaultMutableTreeNode visit(ArrayType arrType) {
		ArrayType1 type1 = (ArrayType1) arrType;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("ArrayType");
		root.add(new DefaultMutableTreeNode(type1.regularType));
		root.add(new DefaultMutableTreeNode("["));
		root.add(new DefaultMutableTreeNode("]"));
		return root;
	}

	@Override
	public DefaultMutableTreeNode visit(ClassDeclaration cd) {
		// TODO Auto-generated method stub
		ClassDeclaration1 cd1 = (ClassDeclaration1) cd;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Class Declaration");
		root.add(new DefaultMutableTreeNode(cd1.classString));
		if(!cd1.id1.equals(null)){
			root.add(new DefaultMutableTreeNode(cd1.id1));
		}
		if(!cd1.extendsString.equals(null)){
			root.add(new DefaultMutableTreeNode(cd1.extendsString));
		}
		if(!cd1.id2.equals(null)){
			root.add(new DefaultMutableTreeNode(cd1.id2));
		}
		root.add(new DefaultMutableTreeNode(cd1.leftC));
		for(int i=0 ; i<cd1.declartion.size() ; i++){
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
			temp = this.visit(cd1.declartion.get(i));
			root.add(temp);
		}
		root.add(new DefaultMutableTreeNode(cd1.rightC));
		return root;
	}

	@Override
	public DefaultMutableTreeNode visit(Declaration declaration) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Declaration");
		if(declaration instanceof Declaration1){
			Declaration1 dc = (Declaration1) declaration;
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
			temp = this.visit(dc.varDeclaration);
			node.add(temp);
			return node;
		}
		else {
			Declaration2 dc = (Declaration2) declaration;
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
			temp = this.visit(dc.methodDeclaration);
			node.add(temp);
			return node;
		}
		
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
		//DefaultMutableTreeNode node = new DefaultMutableTreeNode();
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Main Class");
		node.add(new DefaultMutableTreeNode("class"));
		if(!mc.id.equals(null)){
			node.add(new DefaultMutableTreeNode(mc.id));
		}
		node.add(new DefaultMutableTreeNode(mc.leftB));
		node.add(new DefaultMutableTreeNode(mc.publicString));
		node.add(new DefaultMutableTreeNode(mc.staticString));
		node.add(new DefaultMutableTreeNode(mc.voidString));
		node.add(new DefaultMutableTreeNode(mc.mainString));
		node.add(new DefaultMutableTreeNode(mc.leftR));
		node.add(new DefaultMutableTreeNode(mc.StringS));
		node.add(new DefaultMutableTreeNode(mc.leftS));
		node.add(new DefaultMutableTreeNode(mc.rightS));
		if(!mc.id2.equals(null)){
			node.add(new DefaultMutableTreeNode(mc.id2));
		}
		node.add(new DefaultMutableTreeNode(mc.rightB));
		node.add(new DefaultMutableTreeNode(mc.leftB2));
		//node.add(new DefaultMutableTreeNode(rightS));//STAEMENT
		node.add(new DefaultMutableTreeNode(mc.rightB2));
		node.add(new DefaultMutableTreeNode(mc.rightB3));
		
		return node;
	}

	@Override
	public DefaultMutableTreeNode visit(MethodDeclaration method) {
		MethodDeclaration1 m1 = (MethodDeclaration1) method;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Method Declaration");
		root.add(new DefaultMutableTreeNode(m1.access));
		root.add(new DefaultMutableTreeNode(this.visit(m1.type)));
		root.add(new DefaultMutableTreeNode(m1.id));
		root.add(new DefaultMutableTreeNode(m1.leftB));
		if (m1.parameter != null) {
			root.add(new DefaultMutableTreeNode(this.visit(m1.parameter)));
		}
		root.add(new DefaultMutableTreeNode(m1.rightB));
		root.add(new DefaultMutableTreeNode(m1.leftC));
		for (int i=0 ; i<m1.varDeclaration.size() ; i++){
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(this.visit(m1.varDeclaration.get(i)));
			root.add(temp);
		}
//		for (int i=0 ; i<stmt.size() ; i++){
//			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(stmt.get(i).getNode());
//			root.add(temp);
//		}
		root.add(new DefaultMutableTreeNode(m1.RETURN));
		//root.add(new DefaultMutableTreeNode(exp.getNode()));
		root.add(new DefaultMutableTreeNode(m1.semicolon));
		root.add(new DefaultMutableTreeNode(m1.leftB2));
		return root;
		
	}

	@Override
	public DefaultMutableTreeNode visit(New_Expression newex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Parameter params) {
		Parameters1 p1 = (Parameters1) params;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Parameter");
		for(int i=0 ; i<p1.type.size() ; i++){
			root.add(new DefaultMutableTreeNode(this.visit(p1.type.get(i))));
		}
		for(int i=0 ; i<p1.id.size() ; i++){
			root.add(new DefaultMutableTreeNode(p1.id.get(i)));
		}
		return root;
		
	}

	@Override
	public DefaultMutableTreeNode visit(Statement st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode visit(Type type) {
		// TODO Auto-generated method stub
		if( type instanceof Type1){
			Type1 type1 = (Type1) type;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Type1");
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(type1.regularType);
			root.add(temp);
			return root;
		}
		else{ 
			Type2 type2 = (Type2) type;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Type 2");
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
			temp = this.visit(type2.arrayType);
			root.add(temp);
			return root;
		}
		
	}

	@Override
	public DefaultMutableTreeNode visit(VarDeclaration vard) {
		VarDeclaration1 var = (VarDeclaration1) vard;
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Var Declaration");
		DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
		temp = this.visit(var.type);
		node.add(temp);
		node.add(new DefaultMutableTreeNode(var.id));
		node.add(new DefaultMutableTreeNode(var.semicolon));
		return node;
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