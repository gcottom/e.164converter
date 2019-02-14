import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		System.out.print("Enter 0 to exit\n");
	    System.out.print("Acceptable formats: 555-555-5555 or (555)555-5555 or 5555555555 .\n"
	    		+ "Do not enter a preceding 1 or a +, these will be automatically added.\n");
		while(true) {
	        System.out.print("Enter #:");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			char [] exitTest = input.toCharArray();
			if(exitTest[0] == '0' && exitTest.length<2) {
				System.out.print("Program Exit\n");
				scan.close();
				System.exit(0);
			}
			String conNum =convert(input);
			if(conNum== null) {
				continue;
			}
			System.out.print(conNum + "\n");
		}

	}
	public static String convert(String input) {
		String conNum= "+1";
		char [] oldNum = input.toCharArray();
		if(oldNum.length == 10 || oldNum.length == 12 || oldNum.length == 13) {
			for(int i=0; i<oldNum.length;i++) {
				if(i==0||i==3||i==4||i==7||i==8) {
					if(oldNum[i]== '-' || oldNum[i] == '(' || oldNum[i] == ')') {
						continue;
					}
				}
				if(oldNum[i]!= '1' && oldNum[i]!= '2' && oldNum[i] != '3' && oldNum[i] != '3'
						&& oldNum[i] != '4' && oldNum[i] != '5' && oldNum[i] != '6' && oldNum[i] != '7'
						&& oldNum[i] != '8' && oldNum[i] != '9' && oldNum[i] != '0') {
					System.out.print("Invalid input: " + oldNum[i] + "\n");
					return null;
				}
				else {
				conNum = conNum + oldNum[i];
				}
			}
			
		}
		else {
			System.out.print("Invalid input: Invalid phone # length!\n");
			return null;
		}
		return conNum;
	}

}
