package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
  private String name;
  private Set<Content> enrolledContents = new LinkedHashSet<>();
  private Set<Content> completedContents = new LinkedHashSet<>();

  public void enrollBootcamp(Bootcamp bootcamp){
    this.enrolledContents.addAll(bootcamp.getContents());
    bootcamp.getEnrolledDevs().add(this);
  }

  public void progress() {
    Optional<Content> content = this.enrolledContents.stream().findFirst();
    
    if(content.isPresent()) {
      this.completedContents.add(content.get());
      this.enrolledContents.remove(content.get());
    } else {
      System.err.println("You are not enrolled in any content!");
    }
  }

  public double calculateTotalXp() {
    double sum = 0;

    for(Content content : this.completedContents){
      sum += content.calculateXp();
    }

    return sum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Content> getEnrolledContents() {
    return enrolledContents;
  }

  public void setEnrolledContents(Set<Content> enrolledContents) {
    this.enrolledContents = enrolledContents;
  }

  public Set<Content> getCompletedContents() {
    return completedContents;
  }

  public void setCompletedContents(Set<Content> completedContents) {
    this.completedContents = completedContents;
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
