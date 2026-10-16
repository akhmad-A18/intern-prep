import java.util.*;

enum Status {
    OPEN,
    DONE;
}

class Task {
    private long id;
    private String title;
    private Status status;

    public Task(long id, String title) {
        this.id = id;
        this.title = title;
        this.status = Status.OPEN;
    }

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

    @Override
    public String toString() {
        return id + ": " + title + " is " + status;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        long nextId = 1;
        boolean running = true;

        while (running) {
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Mark task as DONE");
            System.out.println("4. Delete task");
            System.out.println("5. Count OPEN tasks");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Task p = new Task(nextId, name);
                    tasks.add(p);
                    nextId++;
                    System.out.println(p);
                    break;
                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks");
                    } else {
                        for (Task t : tasks) {
                            System.out.println(t);
                        }
                    }
                    break;
                case "3":
                    System.out.print("Choose tasks's ID: ");
                    String idText = scanner.nextLine();
                    long cID = Long.parseLong(idText);
                    Task found = null;
                    for(Task w : tasks) {
                      if(w.getId()== cID) {
                        found = w;
                      }
                    }
                    if (found == null) {
                      System.out.println("Task not found");
                    } else {
                      found.setStatus(Status.DONE);
                    }
                    break;
                case "4":
                    System.out.print("Choose tasks's ID: ");
                    String dlID = scanner.nextLine();
                    long dID = Long.parseLong(dlID);
                    Task mark = null;
                    for(Task q : tasks) {
                      if(q.getId() == dID) {
                        mark = q;
                      }
                    }
                    if (mark == null) {
                        System.out.println("Task not found");
                    }
                    else {
                      tasks.remove(mark);
                    }
                    break;
                case "5":
                        int rcount = 0;
                        for (Task r : tasks){
                        if(r.getStatus() == Status.OPEN){
                          rcount++;
                        }
                        }
                        System.out.println("Open tasks: " + rcount );
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown option");
            }
        }
    }
}