public class Task {
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

    public Task(String type, String desc) {
        this.type = type;
        taskDescription = desc;
    }


    public String toString() {
        String result = this.type + " " + taskDescription;
        return result;
    }
}
