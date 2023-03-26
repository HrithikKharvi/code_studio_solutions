import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> s2 = new Stack<>();
		while(!stack.isEmpty()){
			int curr = stack.pop();
			sort(curr, s2);
		}

		while(!s2.isEmpty()){
			int curr = s2.pop();
			stack.push(curr);
		}
	}

	public static void sort(int ele, Stack<Integer> s2){
		if(s2.isEmpty()){
			s2.push(ele);
			return;
		}else if(s2.peek() > ele){
			s2.push(ele);
			return;
		}

		int curr = s2.pop();
		sort(ele, s2);
		s2.push(curr);
	}


}
