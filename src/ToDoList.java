import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
      System.out.println("! - Выйти");

      option = scanner.nextLine();

      switch (option) {
        case "1":
          printTasks(tasks);
          break;
        case "2":
          System.out.println("Введите новую задачу:");
          String newTask = scanner.nextLine();
          tasks.add(newTask);
          break;
        case "3":
          System.out.println("Введите номер задачи для удаления:");
          int taskIndex = scanner.nextInt();
          scanner.nextLine();
          if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.remove(taskIndex);
          } else {
            System.out.println("Недопустимый номер задачи.");
          }
          break;
        case "!":
          try {
            saveTasksToFile(tasks);
          } catch (IOException e) {
            e.printStackTrace();
          }
          System.out.println("Список задач сохранен в файле " + FILENAME);
          break;
        default:
          System.out.println("Недопустимая опция.");
          break;
      }
    }

    scanner.close();
  }

  private static void printTasks(List<String> tasks) {
    if (tasks.isEmpty()) {
      System.out.println("Список задач пуст.");
    } else {
      System.out.println("Список задач:");
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println(i + ": " + tasks.get(i));
      }
    }
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

  private static void saveTasksToFile(List<String> tasks) throws IOException {
    BufferedWriter writer = null;

    try {
      writer = new BufferedWriter(new FileWriter(FILENAME));
      for (String task : tasks) {
        writer.write(task);
        writer.newLine();
      }
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }

}