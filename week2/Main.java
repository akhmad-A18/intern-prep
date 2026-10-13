import java.util.*;

enum Status{
  OPEN,
  DONE;
}

class Task{
  private long id;
  private String title;
  private Status status;

  public long getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public Status getStatus() {
    return status;
  }
  public void setId(long id) {
    this.id = id;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setStatus(Status status) {
    this.status = status;
  }

  public Task(long id, String title) {
    this.id = id;
    this.title = title;
    this.status = Status.OPEN;
  }

  @Override
    public String toString() {
      return id + ": " + title + " is " + status;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "java"));
        tasks.add(new Task(2, "SpringBoot"));
        tasks.add(new Task(3, "intern"));
        tasks.get(0).setStatus(Status.DONE);

        int count = 0;
        for (Task t : tasks) {
            System.out.println(t);
            if (t.getStatus() == Status.OPEN) {
                count++;
            }
        }
        System.out.println("The number of OPEN is " + count);
    }
}