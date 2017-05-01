package symbols;

public class RegularType {
	final static String BOOLEAN= "boolean"; 
	final static String INT = "int";
	final static String FLOAT =  "float";
	final static String STRING =  "String";
	final static String CHAR =  "char";
	public static boolean isRegular(String temp){
		if(temp.equals(BOOLEAN)||temp.equals(INT)||temp.equals(FLOAT)||temp.equals(STRING)
				||temp.equals(CHAR)){
			return true;
		}
		else return false;
	}
 
}
