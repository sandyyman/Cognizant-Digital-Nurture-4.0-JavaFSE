public class TaskLinkedList {
    Task head = null;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        newTask.next = head;
        head = newTask;
        System.out.println("Task added: " + newTask);
    }

    public void traverseTasks() {
        Task current = head;
        System.out.println("All Tasks:");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                System.out.println("Found: " + current);
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    public void deleteTask(int id) {
        Task current = head, prev = null;
        while (current != null) {
            if (current.taskId == id) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Task deleted: " + current);
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(1, "Design UI", "Pending");
        taskList.addTask(2, "Write Backend", "In Progress");
        taskList.addTask(3, "Test System", "Pending");

        taskList.traverseTasks();

        taskList.searchTask(2);
        taskList.deleteTask(2);
        taskList.traverseTasks();
    }
}
