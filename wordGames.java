import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class wordGames {
    public static void main(String[] args) throws IOException {

        boolean loop = true;
        int choice;

        Scanner scan = new Scanner(System.in);

        List<String> listOfStrings = new ArrayList<String>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader("dictionary.txt"));

            String line = bf.readLine();

            while (line != null) {
                listOfStrings.add(line);
                line = bf.readLine();
            }

            bf.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not open file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: Could not read file.");
            e.printStackTrace();
        }

        String[] array = listOfStrings.toArray(new String[0]);

        System.out.println(listOfStrings);

        while (loop == true) {
            System.out.println("\n---Menu---");
            System.out.println("1] Substring Problem");
            System.out.println("2] Points Problem");
            System.out.println("3] Exit");

            try {
                System.out.print("Enter your choice : ");
                choice = scan.nextInt();
                if (choice == 1) {
                    substringProblem(listOfStrings);
                } else if (choice == 2) {
                    System.out.println();
                    pointsProblem(listOfStrings);
                } else if (choice == 3) {
                    System.out.println("Goodbye!");
                    loop = false;
                } else {
                    System.out.println("Invalid option, Try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid option, Try again");
                scan.nextLine();
            }
        }
    }

    public static void substringProblem(List<String> listOfStrings) {
        System.out.print("Enter the substring: ");
        Scanner scan = new Scanner(System.in);
        String subString = scan.nextLine();

        System.out.println();

        for (int i = 0; i < listOfStrings.size(); i++) {
            String str = listOfStrings.get(i);
            boolean prefix = false, infix = false, suffix = false;

            if (str.startsWith(subString)) {
                prefix = true;
            }
            if (str.endsWith(subString)) {
                suffix = true;
            }
            if (str.indexOf(subString) != -1 && str.indexOf(subString) != str.lastIndexOf(subString)) {
                infix = true;
            } else if (str.indexOf(subString) > 0 && str.indexOf(subString) < str.length()) {
                infix = true;
            }

            if (prefix && infix && suffix) {
                System.out.println(str + " = prefix, infix, suffix");
            } else if (prefix && infix) {
                System.out.println(str + " = prefix, infix");
            } else if (infix && suffix) {
                System.out.println(str + " = infix, suffix");
            } else if (prefix && suffix) {
                System.out.println(str + " = prefix, suffix");
            } else if (prefix) {
                System.out.println(str + " = prefix");
            } else if (infix) {
                System.out.println(str + " = infix");
            } else if (suffix) {
                System.out.println(str + " = suffix");
            } else {
                System.out.println(str + " = substring not present");
            }
        }
    }

    public static void pointsProblem(List<String> listOfStrings) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("a", 1);
        myMap.put("e", 1);
        myMap.put("i", 1);
        myMap.put("l", 1);
        myMap.put("n", 1);
        myMap.put("o", 1);
        myMap.put("r", 1);
        myMap.put("s", 1);
        myMap.put("t", 1);
        myMap.put("u", 1);
        myMap.put("g", 2);
        myMap.put("d", 2);
        myMap.put("b", 3);
        myMap.put("c", 3);
        myMap.put("m", 3);
        myMap.put("p", 3);
        myMap.put("f", 4);
        myMap.put("h", 4);
        myMap.put("v", 4);
        myMap.put("w", 4);
        myMap.put("y", 4);
        myMap.put("k", 5);
        myMap.put("j", 8);
        myMap.put("x", 8);
        myMap.put("q", 10);
        myMap.put("z", 10);

        for (int i = 0; i < listOfStrings.size(); i++) {
            int sum = 0;

            for (int j = 0; j < listOfStrings.get(i).length(); j++) {
                if (myMap.containsKey(Character.toString(listOfStrings.get(i).charAt(j)))) {
                    sum = sum + myMap.get(Character.toString(listOfStrings.get(i).charAt(j)));
                }
            }

            System.out.println(listOfStrings.get(i) + " worth " + sum);

        }
    }
}
