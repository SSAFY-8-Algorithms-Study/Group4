package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2596 {
	
	static final String A = "000000";
	static final String B = "001111";
	static final String C = "010011";
	static final String D = "011100";
	static final String E = "100110";
	static final String F = "101001";
	static final String G = "110101";
	static final String H = "111010";
	
	static int N;
	static String[] strList;
	static char[] copyList;
	
	static String result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		strList= new String[N];
		
		String str = br.readLine();
		
		for (int i = 0, index = 0; index < N; i+= 6, index++) {
			strList[index] = str.substring(i, i+6);
		}
		//InputEnd
		
		result = "";
		
		loop:
		for (int i = 0; i < strList.length; i++) {
			String checkStr = strList[i];
			
			switch (checkStr) {
			case A:
				result+= "A";
				break;
			case B:
				result+= "B";
				break;
			case C:
				result+= "C";
				break;
			case D:
				result+= "D";
				break;
			case E:
				result+= "E";
				break;
			case F:
				result+= "F";
				break;
			case G:
				result+= "G";
				break;
			case H:
				result+= "H";
				break;

			default:
//				System.out.println(checkStr);
				if(!check(checkStr)) {
					result = Integer.toString(i+1);
					break loop;
				} 
				
				break;
			}
		}
		
		System.out.println(result);
	}
	
	static void copyCharList(char[] list) {
		copyList = new char[6];
		
		for (int i = 0; i < list.length; i++) {
			copyList[i] = list[i];
		}
	}
	
	static boolean check(String str) {
		char[] checkList = str.toCharArray();
		
		for (int i = 0; i < checkList.length; i++) {
			copyCharList(checkList);
			
			if(checkList[i] == '0') {
				copyList[i] = '1';
			} else if(checkList[i] == '1'){
				copyList[i] = '0';
			}
			
			String checkString = new String(copyList);
//			System.out.println(checkString);
			
			if(checkString.equals(A)) {
				result += "A";
				return true;
			}
			if(checkString.equals(B)) {
				result += "B";
				return true;
			}
			if(checkString.equals(C)) {
				result += "C";
				return true;
			}
			if(checkString.equals(D)) {
				result += "D";
				return true;
			}
			if(checkString.equals(E)) {
				result += "E";
				return true;
			}
			if(checkString.equals(F)) {
				result += "F";
				return true;
			}
			if(checkString.equals(G)) {
				result += "G";
				return true;
			}
			if(checkString.equals(H)) {
				result += "H";
				return true;
			}
		}
		
		//아무것도 못찾을시
		return false;
	}
}
