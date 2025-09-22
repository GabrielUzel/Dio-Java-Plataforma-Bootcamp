import br.com.dio.desafio.dominio.*;
import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    Course javaCourse = new Course("Java Basico", "Bootcamp Java", 8);
    Course jsCourse = new Course("JavaScript Basico", "Bootcamp Javascript", 6);

    Mentoring mentoring = new Mentoring("Mentoria Java", "Sessão de mentoria para Java", LocalDate.now());

    Bootcamp bootcamp = new Bootcamp("Java Developer Bootcamp", "Torne-se um desenvolvedor Java em 45 dias");
    bootcamp.addContent(javaCourse);
    bootcamp.addContent(jsCourse);
    bootcamp.addContent(mentoring);

    Dev devAlice = new Dev("Gabriel");
    Dev devBob = new Dev("Luana");

    devAlice.enrollBootcamp(bootcamp);
    devBob.enrollBootcamp(bootcamp);

    devAlice.progress();
    devAlice.progress();
    devBob.progress();

    System.out.println("=== Devs Status ===");
    for(Dev dev : bootcamp.getEnrolledDevs()) {
      System.out.println("Name: " + dev.getName());
      System.out.println("Enrolled Contents: " + dev.getEnrolledContents());
      System.out.println("Completed Contents: " + dev.getCompletedContents());
      System.out.println("XP: " + dev.calculateTotalXp());
      System.out.println("Progress: " + dev.progressPercentage() + "%");
      System.out.println("History: " + dev.getProgressHistory());
      System.out.println("---------------------------");
    }

    System.out.println("=== Ranking ===");
    bootcamp.getEnrolledDevs().stream()
      .sorted((d1, d2) -> Double.compare(d2.calculateTotalXp(), d1.calculateTotalXp()))
      .forEach(d -> System.out.println(d.getName() + " - XP: " + d.calculateTotalXp()));
  }
}
