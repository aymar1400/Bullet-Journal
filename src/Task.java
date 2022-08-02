import java.io.Serializable;

public class Task implements Serializable {
    // dot - task (1)
    // circle - event (2)
    // dash/hyphen - note (3)
    // star - signifier task
    // x - completed task
    // strike thru - not worth it
    // > - add task to new monthly log
    // < - add task to future log

    String type;
    String taskDescription;

    private static final long serialVersionUID = 1L;

    public Task(String icon, String desc) {
        type = icon;
        taskDescription = desc;
    }

    public void changeIcon(String i) {
        type = i;
    }

    public void changeTask(String t) {
        taskDescription = t;
    }


    public String toString() {
        String result = this.type + " " + taskDescription;
        return result;
    }
}
