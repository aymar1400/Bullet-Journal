import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class Main {

    public static DailyLog dLog;

    public static void main(String[] args) {
        dLog = new DailyLog("");


        String choice = null;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Command Options: ");
            System.out.println("a: Add to Daily Log");
            System.out.println("b: Print Daily Log");
            System.out.println("c: Change date, icon, task");
            System.out.println("d: Write to File");
            System.out.println("e: Read to File");
            System.out.println("q: Quit");
            System.out.print("Enter a command: ");
            choice = scan.nextLine();
            switch (choice) {
                case "a":
                    System.out.print("Enter date: ");
                    String dateLabel = scan.nextLine();
                    System.out.print("Enter icon: ");
                    String iconLabel = scan.nextLine();
                    System.out.print("Enter task: ");
                    String taskLabel = scan.nextLine();
                    createLog(dateLabel, iconLabel, taskLabel);
                    break;
                case "b":
                    System.out.println(dLog);
                    break;
                case "c":
                    System.out.println("1) Change Date");
                    System.out.println("2) Change Icon");
                    System.out.println("3) Change Task");
                    System.out.println("Enter an option: ");
                    int opt = scan.nextInt();
                    changeInLog(opt);
                    break;
                case "d":
                    writeFile();
                    System.exit(0);
                    break;
                case "e":
                    readFile();
                    break;
            } // end of switch
        } while (!choice.equals("q")); // end of loop


    }

    public static void readFile() {
        try {


            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            DailyLog pr1 = (DailyLog) oi.readObject();


            System.out.println(pr1.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(dLog);

            o.close();
            f.close();



        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream" + e);
        }
    }
    public static void changeInLog(int option) {
        Scanner s2 = new Scanner(System.in);
        if (option == 1) {
            System.out.println("Enter new date: ");
            String newDate = s2.nextLine();
            dLog.setDate(newDate);
        }
        else if (option == 2) {
            System.out.println("Enter new icon: ");
            String newIcon = s2.nextLine();
            System.out.println("Enter task number: ");
            int taskNumber = s2.nextInt();
            taskNumber = taskNumber - 1;
            dLog.getTaskInList(taskNumber).changeIcon(newIcon);
        }
        else if (option == 3) {
            System.out.println("Enter new task: ");
            String tasky = s2.nextLine();
            System.out.println("Enter task number: ");
            int tNumber = s2.nextInt();

            tNumber = tNumber - 1;
            dLog.getTaskInList(tNumber).changeTask(tasky);

        }
        else
            System.exit(0);
    }

    public static void createLog(String d, String i, String desc) {
        dLog.setDate(d);
        Task t = new Task(i, desc);
        dLog.addToList(t);
    }

    public static String printLog() {
        String result = "";
        String mod1 = "-----------------------------------------------------------";
        String dateVar = "Date: " + dLog.getDate();

        for (int i = 0; i < dLog.getTaskList().size(); i++) {
            result += dLog.getTaskList().get(i) + " (" + (i+1) + ")" + "\n";
        }

        String outResult = mod1 + "\n" + dateVar + "\n" + result + mod1;
        return outResult;
    }



}
