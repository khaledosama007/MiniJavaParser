package parser;

import java.util.ArrayList;
import java.util.List;

public class TokenQueue {
	public static List<Token> queue = new ArrayList<>();
	public static int index = 0;

	public static List<Token> getQueue() {
		return queue;
	}

	public static void setQueue(List<Token> queue) {
		TokenQueue.queue = queue;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		TokenQueue.index = index;
	}

	public static Token getToken() {
		Token t = queue.get(index);
		index++;
		return t;
	}
	public static Token top(){
		return queue.get(index);
	}
}
