import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
  private static final String FILENAME = "todo.txt";
  public static void main(String[] args) {
    List<String> tasks = new ArrayList<String>();

    try {
      tasks = readTasksFromFile();
    } catch (IOException e) {
      e.printStackTrace();
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
}