import javax.management.AttributeList;
import java.util.*;

public class DailyLog {
    String day;
    int month, monthDay, year;
    ArrayList taskList;



    public DailyLog() {
        Calendar calendar = Calendar.getInstance();
        Date d = new Date();
        int date = d.getDay();
        taskList = new ArrayList<Task>();
        month = calendar.get(Calendar.MONTH) + 1;
        monthDay = calendar.get(Calendar.DATE);
        year = calendar.get(Calendar.YEAR);
    }


    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void addToList(Task task) {
        taskList.add(task);
    }

    public String getTaskFromList() {
        String result = "";
        for (int i = 0; i < taskList.size(); i++) {
            result = result + taskList.get((i)).toString() + "\n";
        }
      return result;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < taskList.size(); i++) {
            result = result + taskList.get(i) + "\n";
        }
        return result;
    }
}
