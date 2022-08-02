import javax.management.AttributeList;
import java.util.*;
import java.io.Serializable;

public class DailyLog implements Serializable {

    ArrayList<Task> taskList;
    String date;

    private static final long serialVersionUID = 1L;


    public DailyLog(String date) {
        this.date = date;

        taskList = new ArrayList<Task>();

    }

    public ArrayList getTaskList() { return taskList; }

    public Task getTaskInList(int index) {
        return taskList.get(index);
    }
    public String getDate() { return date; }

    public void setDate(String input) { date = input; }

    public void addToList(Task task) {
        taskList.add(task);
    }



    public String toString() {
        /*
        String result = "";
        for (int i = 0; i < taskList.size(); i++) {
            result = result + taskList.get((i)).toString() + "\n";
        }
        return date + "\n" + result;

         */
        String result = "";
        String mod1 = "-----------------------------------------------------------";
        String dateVar = "Date: " + this.getDate();

        for (int i = 0; i < this.getTaskList().size(); i++) {
            result += this.getTaskList().get(i) + " (" + (i+1) + ")" + "\n";
        }

        String outResult = mod1 + "\n" + dateVar + "\n" + result + mod1;
        return outResult;
    }
}
