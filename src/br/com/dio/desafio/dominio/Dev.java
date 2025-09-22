package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
  private String name;
  private Set<Content> enrolledContents = new LinkedHashSet<>();
  private Set<Content> completedContents = new LinkedHashSet<>();
  private List<String> progressHistory = new ArrayList<>();

  public Dev() {}

  public Dev(String name) {
    this.name = name;
  }

  public void enrollBootcamp(Bootcamp bootcamp){
    enrolledContents.addAll(bootcamp.getContents());
    bootcamp.addDev(this);
  }

  public void progress() {
    Optional<Content> content = enrolledContents.stream().findFirst();

    if(content.isPresent()) {
      Content c = content.get();
      completedContents.add(c);
      enrolledContents.remove(c);
      progressHistory.add("Completed: " + c.getTitle());
    } else {
      System.err.println("You are not enrolled in any content!");
    }
  }

  public double calculateTotalXp() {
    return (
      completedContents.stream()
        .mapToDouble(Content::calculateXp)
        .sum()
    );
  }

  public double progressPercentage() {
    int total = enrolledContents.size() + completedContents.size();
    return total == 0 ? 0 : ((double) completedContents.size() / total) * 100;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Content> getEnrolledContents() {
    return Collections.unmodifiableSet(enrolledContents);
  }

  public Set<Content> getCompletedContents() {
    return Collections.unmodifiableSet(completedContents);
  }

  public List<String> getProgressHistory() {
    return Collections.unmodifiableList(progressHistory);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Dev dev = (Dev) o;

    return (
      Objects.equals(name, dev.name) &&
      Objects.equals(enrolledContents, dev.enrolledContents) &&
      Objects.equals(completedContents, dev.completedContents)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, enrolledContents, completedContents);
  }
}
