package parser;

import java.util.regex.Pattern;

public class Token {
	public static final String CLASS = "CLASS";
	public static final String SOP = "System.out.println";
	public static String IDENTIFIER  = "IDENTIFIER";
	public static final String  LEFT_CURLY_B = "LEFT_CURLY_B";
	public static final String  RIGHT_CURLY_B = "RIGHT_CURLY_B";
	public static final String PUBLIC  = "PUBLIC";
	public static final String PRIVATE  = "PRIVATE";
	public static final String STATIC  = "STATIC";
	public static final String VOID  = "VOID";
	public static final String MAIN  = "MAIN";
	public static final String LEFT_ROUND_B  = "LEFT_ROUND_B";
	public static final String STRING  = "STRING ";
	public static final String LEFT_SQUARE_B  = "LEFT_SQUARE_B";
	public static final String  RIGHT_SQUARE_B = "RIGHT_SQUARE_B";
	public static final String IF= "IF";
	public static final String WHILE = "WHILE";
	public static final String EXTENDS = "EXTENDS";
	public static final String RETURN = "RETURN";
	public static final String BOOLEAN = "BOOLEAN";
	public static final String COMMA = "COMMA";
	public static final String SEMICOLON = "SEMICOLON";
	public static final String DOT = "DOT";
	public static final String NOT = "NOT";
	public static final String EQUAL = "EQUAL";
	public static final String AND = "AND";
	public static final String MINUS = "MINUS";
	public static final String MULTIPLY = "MULTIPLY";
	public static final String LESSTHAN = "LESSTHAN";
	public static final String GREATERTHAN = "GREATERTHAN";
	public static final String ELSE ="ELSE";
	public static final String THIS = "THIS";
	public static final String TRUE = "TRUE";
	public static final String FALSE = "FALSE";
	public static final String LENGTH = "LENGTH";
	public static final String NEW = "NEW";
	public static final String FLOAT = "FLOAT";
	public static final String CHARACHTER = "CHARACHTER";
	public static final String INTEGER = "INT";
	public static final String  RIGHT_ROUND_B  = "RIGHT_ROUND_B";

	
	public Token(String type , String value){
		this.type = type;
		this.value = value;
	}
 public String value;
 public String type;
}
