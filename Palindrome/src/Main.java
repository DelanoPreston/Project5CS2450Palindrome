import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter the path of the file");
		String fileContents = ReadInFile(in.nextLine());
		in.close();
		
		List<String> palindromes = FindPalindromes(fileContents);
		String longest = FindLongestString(palindromes);
		System.out.print("The longest Palindrome is: ");
		System.out.println(longest);
	}
	private static String ReadInFile(String path){
		String temp = "";
		Scanner input = null;
		
		try {
			input = new Scanner(new File(path));
			temp = input.useDelimiter("//Z").next();
			input.close();
			String[] t =  temp.split("\r\n");
			
			temp = "";
			
			for(int i = 0; i < t.length; i++){
				temp += t[i];
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	private static List<String> FindPalindromes(final String inString){
		List<String> temp = new ArrayList<String>();
		int rightIndex = 0;
		int leftIndex = 0;
		
		for(int center = 1; center < inString.length(); center++){
			leftIndex = center - 1;
			rightIndex = center + 1;
			
			while(leftIndex >= 0 && rightIndex < inString.length()){
				if(inString.charAt(leftIndex) != inString.charAt(rightIndex)){
					break;
				}
				temp.add(inString.substring(leftIndex, rightIndex + 1));
				leftIndex--;
				rightIndex++;
			}
		}
		return temp;
	}
	private static String FindLongestString(List<String> inStrings){
		String temp = "";
		
		for(int i = 0; i < inStrings.size(); i++){
			if(temp.length() < inStrings.get(i).length()){
				temp = inStrings.get(i);
			}
		}
		
		return temp;
	}
}
