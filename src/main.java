import java.io.*;
import java.util.Scanner;


public class main {
	public static void showMenu() {
		System.out.println("Functions: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create Room");
		System.out.println("2. Set camera");
		System.out.println("3. Caculate Hidden Area");
		System.out.println("4. Show Hidden Area");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void main(String[] args) {
		int choice;
		int n = 0, check = 0;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				break;
			case 2:
			
				break;					
			case 3:
                break;
            case 4:
      
            default:
                break;
			}
		}while(choice!=0);

	}
}
