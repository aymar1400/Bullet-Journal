import java.util.*;
public class Main {

    public static ArrayList<DailyLog> dLogArray = new ArrayList<DailyLog>();

    public static void main(String[] args) {
        DailyLog dLog = new DailyLog("07/30/2022");



        String choice = null;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Command Options: ");
            System.out.println("a: Create Daily Log");
            System.out.println("b: Add to Log");
            System.out.println("c: Print Logs");
            System.out.println("q: Quit");
            System.out.print("Enter a command: ");
            choice = scan.nextLine();
            switch (choice) {
                case "a":
                    System.out.println("Enter date: ");
                    String dateLabel = scan.nextLine();
                    createDailyLog(dateLabel);

                    break;
                case "b":
                    System.out.println("Enter date for log: ");
                    String dateLabel2 = scan.nextLine();
                    System.out.println("Enter icon: ");
                    String iconLabel = scan.nextLine();
                    System.out.println("Enter task: ");
                    String taskLabel = scan.nextLine();
                    addTaskToLog(dateLabel2, iconLabel, taskLabel);
                    break;
                case "c":
                    for(int i = 0; i < dLogArray.size(); i++) {
                        System.out.println(dLogArray.get(i).toString());
                    }
                    break;
            } // end of switch
        } while (!choice.equals("q")); // end of loop



    }

    public static void createDailyLog(String date) {
        DailyLog log = new DailyLog(date);
        dLogArray.add(log);
    }

    public static void addTaskToLog(String inputDate, String icon, String desc) {
        Task t = new Task(icon, desc);
        for(int i = 0; i < dLogArray.size(); i++) {
            if (dLogArray.get(i).date.equals(inputDate)) {

                dLogArray.get(i).addToList(t);
            }
        }
    }

}
