import javax.management.AttributeList;
import java.util.*;

public class DailyLog {

    ArrayList taskList;
    String date;


    public DailyLog(String date) {
        this.date = date;

        taskList = new ArrayList<Task>();

    }



    public void addToList(Task task) {
        taskList.add(task);
    }



    public String toString() {
        String result = "";
        for (int i = 0; i < taskList.size(); i++) {
            result = result + taskList.get((i)).toString() + "\n";
        }
        return date + "\n" + result;
    }
}
