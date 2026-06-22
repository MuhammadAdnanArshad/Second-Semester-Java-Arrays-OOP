import java.util.Scanner;
public class StudentsRecord {
        public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("enter teh number of rows which you want to store the student Record: ");
        int num = s.nextInt();
        s.nextLine();
        int coloumn = 2;
        while (num < 5 || num > 15) {
            System.out.println("invalid input please enter again number must be less than 15 and greater than 0 :");
            num = s.nextInt();
            s.nextLine();
        }
        String[][] data = new String[num][coloumn];
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.print("Enter Name for student " + i + ": ");
            data[i][0] = s.nextLine();
            System.out.print("Enter ID for student " + i + ": ");
            data[i][1] = s.nextLine();
        }
        System.out.println("----------------------------------------------");
        choice(data);

    }// main

    public static void choice(String[][] data) {
        Scanner s = new Scanner(System.in);
        System.out.print("0.  Press 0 to Exit\n" + //
                "1.  Press 1 to Add a New Student\n" + //
                "2.  Press 2 to Search by Name\n" + //
                "3.  Press 3 to Search by Id\n" + //
                "4.  Press 4 to Sort by Name\n" + //
                "5.  Press 5 to Sort by Id\n" + //
                "6.  Press 6 to Display All Students\r\n" + //
                "Enter your choice please:");
        int choice = s.nextInt();
        while (choice > 7) {
            System.out.print("invalid  input please enter again:  ");
            choice = s.nextInt();
        }
        if (choice == 0) {
            System.out.println("thank you for visiting this  site");
        } else if (choice == 1) {
            addNewStudent(data);
        } else if (choice == 2) {
            searchByName(data);
        } else if (choice == 3) {
            searchByID(data);
        } else if (choice == 4) {
            SortByName(data);
        } else if (choice == 5) {
            sortByID(data);
        } else if (choice == 6) {
            display(data);

        }

    }// choice method

    public static void addNewStudent(String[][] data) {
        Scanner s = new Scanner(System.in);
        String[][] newData = new String[data.length + 1][2];
        for (int i = 0; i < data.length; i++) {
            newData[i][0] = data[i][0];
            newData[i][1] = data[i][1];
            
        }
        System.out.print("Enter New Student Name: ");
        newData[data.length][0] = s.nextLine();
        System.out.print("Enter New Student ID: ");
        newData[data.length][1] = s.nextLine();
        System.out.print("Student Added Successfully!");
        display(newData);
    }

    public static void searchByName(String[][] data) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the please Student Name which you want  to seearch: ");
        String findid = s.next();
        boolean check = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(findid)) {
                System.out.println("\n--- Congrats  Record Found ---");
                System.out.println("Row Number: " + (i + 1));
                System.out.println("Name: " + data[i][0]);
                System.out.println("ID: " + data[i][1]);
                check = true;
                break;
            } // if
        } // for
        if (check == false) {
            System.out.println("Error: Student with ID " + findid + " not found!");
        }
        System.out.println("----------------------------------------------");
        choice(data);
    }// idsearch

    public static void searchByID(String[][] data) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the please Student ID to seearch: ");
        String findid = s.next();
        boolean check = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i][1].equals(findid)) {
                System.out.println("\n--- Congrats  Record Found ---");
                System.out.println("Row Number: " + (i + 1));
                System.out.println("Name: " + data[i][0]);
                System.out.println("ID: " + data[i][1]);
                check = true;
                break;
            } // if
        } // for
        if (check == false) {
            System.out.println("Error: Student with ID " + findid + " not found!");
        }
        System.out.println("----------------------------------------------");
        choice(data);
    }// idsearch

    public static void SortByName(String[][] data) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j][0].compareToIgnoreCase(data[j + 1][0]) > 0) {
                    String[] temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                } // if
            } // inner for
        } // outter for
        System.out.println("Data after sorting by name. ");
        display(data);

    }// sortbyname

    public static void sortByID(String[][] data) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j][1].compareToIgnoreCase(data[j + 1][1]) > 0) {
                    String[] temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                } // if
            } // innerfor
        } // outterfor
        System.out.println("Data after sorting by name.");

        display(data);
    }// sortbyname

    public static void display(String[][] data) {
        System.out.println("Name \t\tRollNo.");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "\t\t  ");
            } // inner for
            System.out.println();
        } // outer for
        System.out.println("----------------------------------------------");

        choice(data);
    }// display
}