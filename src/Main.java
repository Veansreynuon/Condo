import javax.lang.model.element.Name;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int room, floor;
        int option;
        int desireFloor, desireRoom;
        int sellroom, sellfloor;

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the number of floor: ");
            floor = input.nextInt();
            if (floor <= 0) {
                System.out.println("floor can not be zero and negative");
            } else break;
        }
        while (true) {
            System.out.print("Enter the number of room: ");
            room = input.nextInt();
            if (room <= 0) {
                System.out.println("room can not be zero and negative");
            } else break;
        }
        String[][] condo = new String[floor][room];
        System.out.println("You have successfully set up the condo");
        System.out.println("=> Number of floor is : " + floor);
        System.out.println("=> Number of room is : " + room);
        System.out.println("Total condo: " + floor * room);

        do {
            System.out.println("***************** Welcome to PP Condo *****************");
            System.out.println(" [1]. Buy Condo ");
            System.out.println(" [2]. Sell Condo ");
            System.out.println(" [3]. Search Information ");
            System.out.println(" [4]. Display Information ");
            System.out.println(" [5]. Exit ");
            System.out.println("=======================================================");
            System.out.print("Please choose your option: ");
            option = input.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("----------------------Buy Condo---------------------");
                    System.out.print("Enter your desired floor(1-" + floor + ") : ");
                    desireFloor = input.nextInt();
                    if (desireFloor > 0 && desireFloor <= floor) {
                        System.out.print("Enter your room(1-" + room + ") : ");
                        desireRoom = input.nextInt();
                        if (desireRoom > 0 && desireRoom <= room) {
                            if (condo[desireFloor - 1][desireRoom - 1] == null) {
                                System.out.print("Enter your name: ");
//                                input.next();
                                condo[desireFloor - 1][desireRoom - 1] = input.next();
                            } else {
                                System.out.println("Room is already occupied.");
                            }

                        } else {
                            System.out.println("ROM RANK START FROM (1-" + room + ") : ");
                        }
                    } else {
                        System.out.println("FLOOR RANK START FROM 1-" + floor + ") : ");
                    }
                    System.out.println("=========================================");
                }
                break;
                case 2: {
                    System.out.println("--------------------Sell Condo--------------------");
                    System.out.print("Please enter your floor:");
                    sellfloor = input.nextInt();
                    if (sellfloor > 0 && sellfloor <= floor) {
                        System.out.print("Enter your room(1-" + room + ") : ");
                        sellroom = input.nextInt();
                        if (sellroom > 0 && sellroom <= room) {
                            if (condo[sellfloor - 1][sellroom - 1] == null) {
                                System.out.println("You don't have the ownership!");
                            } else {
                                condo[sellfloor - 1][sellroom - 1] = null;
                                System.out.println("You have successfully set up the condo");
                            }
                        } else {
                            System.out.println("ROM RANK START FROM (1-" + room + ") : ");
                        }
                    } else {
                        System.out.println("FLOOR RANK START FROM 1-" + floor + ") : ");
                    }
                    System.out.println("===========================================");
                }
                break;
                case 3: {
                    int option1;
                    String ownerName;
                    int ownerFloor;
                    boolean found = false;
                    System.out.println("-------------------Search Information-----------------");
                    do {
                        System.out.println("1. Search by owner's name:");
                        System.out.println("2. Search by floor:");
                        System.out.println("3. Exit");
                        System.out.print("Choose your option : ");
                        option1 = input.nextInt();
                        switch (option1) {
                            case 1:
                                System.out.println(" ====================== Search by owner name ======================s");
                            {
                                System.out.print("Please owner name to search : ");
                                ownerName = input.next();
                                for (int i = floor - 1; i >= 0; i--) {
                                    for (int j = 0; j < room; j++) {
                                        if (condo[i][j] != null) {
                                            if (condo[i][j].equalsIgnoreCase(ownerName)) {
                                                found = true;
                                                System.out.println("The owner name : " + ownerName + " Floor :" + floor + " Room : " + room);
                                            }
                                        }
                                    }
                                    System.out.println();
                                }
                                if (!found) {
                                    System.out.println("Condo with owner name  " + ownerName + " cannot be found");
                                }
                                System.out.println("===========================================");
                            }
                            break;
                            case 2: {
                                System.out.print("Please enter your floor to search: ");
                                ownerFloor = input.nextInt();
                                for (int i = floor - 1; i >= 0; i--) {
                                    if (ownerFloor - 1 == i) {
                                        found = true;
                                        System.out.print("Floor " + ownerFloor + ": \t\t");
                                        for (int j = 0; j < room; j++) {
                                            System.out.print(condo[i][j] + "\t\t");
                                        }
                                        System.out.println();
                                    }
                                }
                                if (!found) {
                                    System.out.println("Floor " + ownerFloor + " cannot be found");
                                }
                            }
                            break;
                            case 3:{
                                System.out.println("Exiting program");
                            }
                            default:
                                System.out.println("Invalid option,please select again");
                        }
                    } while (option1 != 3);
                }
                break;
                case 4: {
                    System.out.println("--------------Display Condo Information-------------");
                    for (int i = floor - 1; i >= 0; i--) {
                        System.out.print("Floor " + (i + 1) + " :\t\t");
                        for (int j = 0; j < room; j++) {
                            System.out.print(condo[i][j] + "\t\t");
                        }
                        System.out.println();
                    }
                }
                break;
                case 5: {
                    System.out.println("Exiting program");
                }
                default:
                    System.out.println("Invalid option,please select again");
            }
        } while (option != 5);
    }
}