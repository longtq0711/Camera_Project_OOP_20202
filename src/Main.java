
import Coordinates.Point;
import readfile.CreateRoom;
import spaceFigure.Room;

import java.util.Scanner;

public class Main {
	public static void showMenu() {
		System.out.println("Functions: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create Room");
		System.out.println("2. Check Point");
		System.out.println("0. Exit (Press 0)");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void main(String[] args) {
		int choice;
		Room r = null;
		Point p;
		Boolean checkCreateRoom = false, checkCanBeSee;
		do {
			showMenu();
			choice = new Scanner(System.in).nextInt();
			switch(choice) {
			case 1:
				System.out.println("1. Create Room");
				if(checkCreateRoom == false){
					CreateRoom createRoom = new CreateRoom();
					r = createRoom.create();
					if(r != null) {
						System.out.println("Create Room Success");
						checkCreateRoom = true;
					}else {
						System.out.println("Create Room False");
					}
				}else {
					System.out.println("Created Room");
				}
				break;
			case 2:
				if(checkCreateRoom) {
					System.out.println("Input point");
					p = new Point();
					System.out.println("X = ");
					p.setX(new Scanner(System.in).nextFloat());
					System.out.println("Y = ");
					p.setY(new Scanner(System.in).nextFloat());
					System.out.println("Z = ");
					p.setZ(new Scanner(System.in).nextFloat());
					checkCanBeSee = r.canBeSeen(p);
					if (checkCanBeSee) {
						System.out.println("This Point : " + p.printPoint() + " can be seen");
					} else {
						System.out.println("This Point : " + p.printPoint() + " can't be seen");
					}
				}else {
					System.out.println("Room is not initialized");
				}
				break;
            default:
                break;
			}
		}while(choice != 0);

	}
}
