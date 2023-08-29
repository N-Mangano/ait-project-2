import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
  private static final String FILENAME = "todo.txt";
  public static void main(String[] args) {
    List<String> tasks = new ArrayList<String>();

    try {
      tasks = readTasksFromFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String option = "";
    Scanner scanner = new Scanner(System.in);

    while (!option.equals("q")) {
      System.out.println("Выберите действие:");
      System.out.println("1 - Просмотреть список задач");
      System.out.println("2 - Добавить задачу");
      System.out.println("3 - Удалить задачу");
      System.out.println("q - Выйти");

      option = scanner.nextLine();

  }

  private static List<String> readTasksFromFile() throws IOException {
    List<String> tasks = new ArrayList<String>();
    BufferedReader reader = null;

    try {
      reader = new BufferedReader(new FileReader(FILENAME));
      String line;
      while ((line = reader.readLine()) != null) {
        tasks.add(line);
      }
    } finally {
      if (reader != null) {
        reader.close();
      }
    }

    return tasks;
  }

}