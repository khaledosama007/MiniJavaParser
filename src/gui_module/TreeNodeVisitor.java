package gui_module;

import java.util.List;

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
import dot_expression.Dot_Expression;
import dot_expression.Dot_Expression1;
import dot_expression.Dot_Expression2;
import expression.Expression;
import expression.Expression1;
import expression.Expression2;
import expression.Expression3;
import expression.Expression4;
import expression.Expression5;
import expression.Expression6;
import expression.Expression7;
import expression.Expression8;
import expression_alpha.Expression_Alpha;
import expression_alpha.Expression_Alpha1;
import expression_alpha.Expression_Alpha2;
import expression_alpha.Expression_Alpha3;
import goal.Goal;
import goal.GoalStart;
import identifier_statement.Identifier_Statement;
import identifier_statement.Identifier_Statement1;
import identifier_statement.Identifier_Statement2;
import main_class.MainClass;
import main_class.MainClass1;
import method_declaration.MethodDeclaration;
import method_declaration.MethodDeclaration1;
import new_expression.New_Expression;
import new_expression.New_Expression1;
import new_expression.New_Expression2;
import parameters.Parameter;
import parameters.Parameters1;
import statement.Statement;
import statement.Statement1;
import statement.Statement2;
import statement.Statement3;
import statement.Statement4;
import statement.Statement5;
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
	
	//------------------------------------------------------------------------------------------------
	@Override
	public DefaultMutableTreeNode visit(Dot_Expression exp) {
		if (exp instanceof Dot_Expression1 ) {
			Dot_Expression1 exp1 = (Dot_Expression1) exp;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Dot_Expression1");
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode("length");
			root.add(temp);
			return root;
		}else {
			Dot_Expression2 exp2 = (Dot_Expression2) exp;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Dot_Expression2");
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(exp2.id);
			DefaultMutableTreeNode temp1 = new DefaultMutableTreeNode("(");
			root.add(temp);
			root.add(temp1);
			List <Expression> list = exp2.exps ;
			for ( int i = 0 ; i < list.size() ; i++ ) {
			DefaultMutableTreeNode temp2 = new DefaultMutableTreeNode(this.visit(list.get(i)));
			root.add(temp2);
			if (i != list.size()-1 ) 
				root.add(new DefaultMutableTreeNode(","));
			}
			root.add(new DefaultMutableTreeNode(")"));
			return root;
		}
	}
	
	@Override
	public DefaultMutableTreeNode visit(Expression_Alpha ea) {
		
		if (ea instanceof Expression_Alpha1 ){
			Expression_Alpha1 alpha1 = (Expression_Alpha1) ea ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression_Alpha1");
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(alpha1.binaryOp);
			root.add(temp);
			root.add(new DefaultMutableTreeNode(this.visit(alpha1.exp)));
			root.add(new DefaultMutableTreeNode(this.visit(alpha1.exp_alpha))) ;
			return root ;
		}else if (ea instanceof Expression_Alpha2){
			Expression_Alpha2 alpha2 = (Expression_Alpha2) ea ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression_Alpha2");
			root.add(new DefaultMutableTreeNode ("["));
			root.add(new DefaultMutableTreeNode(this.visit(alpha2.exp)));
			root.add(new DefaultMutableTreeNode ("]"));
			root.add(new DefaultMutableTreeNode(this.visit(alpha2.exp_alpha))) ;
			return root ;
		}else if (ea instanceof Expression_Alpha3){
			Expression_Alpha3 alpha3 = (Expression_Alpha3) ea ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression_Alpha3");
			root.add(new DefaultMutableTreeNode ("."));
			root.add(new DefaultMutableTreeNode(this.visit(alpha3.exp)));
			root.add(new DefaultMutableTreeNode(this.visit(alpha3.exp_alpha))) ;
			return root ;
		}else {
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression_Alpha4");
			root.add(new DefaultMutableTreeNode (""));
			return root ;
		}

	}
	
	@Override
	public DefaultMutableTreeNode visit(New_Expression newex) {
	
		if (newex instanceof New_Expression1 ){
			New_Expression1 new_Expression1 = (New_Expression1) newex ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("New_Expression1");
			root.add(new DefaultMutableTreeNode("int"));
			root.add(new DefaultMutableTreeNode("["));
			root.add(new DefaultMutableTreeNode(this.visit(new_Expression1.exp)));
			root.add(new DefaultMutableTreeNode("]")) ;
			return root ;
		}else {
			New_Expression2 new_Expression2 = (New_Expression2) newex ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("New_Expression2");
			root.add(new DefaultMutableTreeNode(new_Expression2.id));
			root.add(new DefaultMutableTreeNode ("("));
			root.add(new DefaultMutableTreeNode (")"));
			return root ;
		}
	}
	
	@Override
	public DefaultMutableTreeNode visit(Expression exp) {
		
		if (exp instanceof Expression1 ){
			Expression1 exp1 = (Expression1) exp ; 
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression1");
			root.add(new DefaultMutableTreeNode(exp1.num));
			root.add(new DefaultMutableTreeNode(this.visit(exp1.exp)));
			return root ;
			
		}else if (exp instanceof Expression2 ){
			Expression2 exp2 = (Expression2) exp ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression2");
			root.add(new DefaultMutableTreeNode("true"));
			root.add(new DefaultMutableTreeNode(this.visit(exp2.exp)));
			return root ;
			
		}else if (exp instanceof Expression3 ){
			Expression3 exp3 = (Expression3) exp ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression3");
			root.add(new DefaultMutableTreeNode("false"));
			root.add(new DefaultMutableTreeNode(this.visit(exp3.exp)));
			return root ;
			
		}else if (exp instanceof Expression4 ){
			Expression4 exp4 = (Expression4) exp ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression4");
			root.add(new DefaultMutableTreeNode(exp4.id));
			root.add(new DefaultMutableTreeNode(this.visit(exp4.exp)));
			return root ;
			
		}else if (exp instanceof Expression5 ){
			Expression5 exp5 = (Expression5) exp ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression5");
			root.add(new DefaultMutableTreeNode("this"));
			root.add(new DefaultMutableTreeNode(this.visit(exp5.exp)));
			return root ;
			
		}else if (exp instanceof Expression6 ){
			Expression6 exp6 = (Expression6) exp ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression6");
			root.add(new DefaultMutableTreeNode("new"));
			root.add(new DefaultMutableTreeNode(this.visit(exp6.exp)));
			root.add(new DefaultMutableTreeNode(this.visit(exp6.exp_alpha)));
			return root ;
			
		}else if (exp instanceof Expression7 ){
			Expression7 exp7 = (Expression7) exp ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression7");
			root.add(new DefaultMutableTreeNode("!"));
			root.add(new DefaultMutableTreeNode(this.visit(exp7.exp)));
			root.add(new DefaultMutableTreeNode(this.visit(exp7.exp_alpha)));
			return root ;
			
		}else {
			Expression8 exp8 = (Expression8) exp ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression8");
			root.add(new DefaultMutableTreeNode("("));
			root.add(new DefaultMutableTreeNode(this.visit(exp8.exp)));
			root.add(new DefaultMutableTreeNode(")"));
			root.add(new DefaultMutableTreeNode(this.visit(exp8.exp_alpha)));
			return root ;
			
		}
		
	}
	

	@Override
	public DefaultMutableTreeNode visit(Identifier_Statement statement) {
		if (statement instanceof Identifier_Statement1 ){
			Identifier_Statement1 identifier_Statement1 = (Identifier_Statement1)statement ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Identifier_Statement1");
			root.add(new DefaultMutableTreeNode("="));
			root.add(new DefaultMutableTreeNode(this.visit(identifier_Statement1.exp)));
			root.add(new DefaultMutableTreeNode(";"));
			return root ;
			
		}else{
			Identifier_Statement2 identifier_Statement2 = (Identifier_Statement2)statement ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Identifier_Statement2");
			root.add(new DefaultMutableTreeNode("["));
			root.add(new DefaultMutableTreeNode(this.visit(identifier_Statement2.exp1)));
			root.add(new DefaultMutableTreeNode("]"));
			root.add(new DefaultMutableTreeNode("="));
			root.add(new DefaultMutableTreeNode(this.visit(identifier_Statement2.exp2)));
			return root ;
		}
	}

	@Override
	public DefaultMutableTreeNode visit(Statement st) {
		if (st instanceof Statement1 ){
			Statement1 st1 = (Statement1) st ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Statement1");
			root.add(new DefaultMutableTreeNode("{"));
			
			List <Statement> list = st1.statements ;
			for ( int i = 0 ; i < list.size() ; i++ ) {
				root.add(new DefaultMutableTreeNode(this.visit(list.get(0))));
			}
			root.add(new DefaultMutableTreeNode("}"));
			return root ;
			
		}else if (st instanceof Statement2 ){
			Statement2 st2 = (Statement2) st ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Statement2");
			root.add(new DefaultMutableTreeNode("if"));
			root.add(new DefaultMutableTreeNode("("));
			root.add(new DefaultMutableTreeNode(this.visit(st2.exp1)));
			root.add(new DefaultMutableTreeNode(")"));
			root.add(new DefaultMutableTreeNode(this.visit(st2.state1)));
			if (st2.state2 != null) {
				root.add(new DefaultMutableTreeNode("else"));
				root.add(new DefaultMutableTreeNode(this.visit(st2.state2)));
			}
			return root ;
	
		}else if (st instanceof Statement3 ){
			Statement3 st3 = (Statement3) st ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Statement3");
			root.add(new DefaultMutableTreeNode("while"));
			root.add(new DefaultMutableTreeNode("("));
			root.add(new DefaultMutableTreeNode(this.visit(st3.exp1)));
			root.add(new DefaultMutableTreeNode(")"));
			root.add(new DefaultMutableTreeNode(this.visit(st3.state1)));
			return root ;
			
			
		}else if (st instanceof Statement4 ){
			Statement4 st4 = (Statement4) st ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Statement4");
			root.add(new DefaultMutableTreeNode("System.out.print"));
			root.add(new DefaultMutableTreeNode("("));
			root.add(new DefaultMutableTreeNode(this.visit(st4.exp)));
			root.add(new DefaultMutableTreeNode(")"));
			root.add(new DefaultMutableTreeNode(";"));	
			return root ;
		
		}else{
			Statement5 st5 = (Statement5) st ;
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Statement5");
			root.add(new DefaultMutableTreeNode(st5.id));
			root.add(new DefaultMutableTreeNode(this.visit(st5.identifier_statement1)));
			return root ;
			
		}
	}
	
	
	
}
