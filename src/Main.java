import java.util.*;
public class Main {
    public static void main(String[] args) {
        DailyLog dLog = new DailyLog();


        //System.out.println("c: All Numbers Are the Same");
        //System.out.println("d: Sum Between Two Integers");
        //System.out.println("e: Repeat the String");
        //System.out.println("f: It is Palindrome");
        //System.out.println("?: Display");

        String choice = null;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Command Options: ");
            System.out.println("a: Add Task to List");
            System.out.println("b: Print DLOG");
            System.out.println("q: Quit");
            System.out.print("Enter a command: ");
            choice = scan.nextLine();
            switch (choice) {
                case "a":
                    System.out.println("Enter icon: ");
                    String icon = scan.nextLine();
                    System.out.println("Enter task: ");
                    String taskDesc = scan.nextLine();
                    Task t1 = new Task(icon, taskDesc);
                    dLog.addToList(t1);
                    break;
                case "b":
                    System.out.println("Date: " + dLog.getMonth() + "/" + dLog.getMonthDay() + "/" + dLog.getYear());
                    System.out.println(dLog.getTaskFromList());
                    break;
            } // end of switch
        } while (!choice.equals("q")); // end of loop
        /*
        Task t1 = new Task("[]", "clean shoes");
        Task t2 = new Task("o", "sailors birthday");
        Task t3 = new Task("-", "data structures");

        dLog.addToList(t1);
        dLog.addToList(t2);
        dLog.addToList(t3);
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        System.out.println(d.getDay());
        System.out.println("Date: " + dLog.getMonth() + "/" + dLog.getMonthDay() + "/" + dLog.getYear());
        System.out.println(dLog.getTaskFromList());

         */
    }
}
