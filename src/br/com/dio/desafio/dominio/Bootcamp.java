package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {
  private String name;
  private String description;
  private final LocalDate startDate = LocalDate.now();
  private final LocalDate endDate = startDate.plusDays(45);
  private Set<Dev> enrolledDevs = new HashSet<>();
  private Set<Content> contents = new LinkedHashSet<>();

  public Bootcamp() {}

  public Bootcamp(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public Set<Dev> getEnrolledDevs() {
    return Collections.unmodifiableSet(enrolledDevs);
  }

  public Set<Content> getContents() {
    return Collections.unmodifiableSet(contents);
  }

  public void addContent(Content content) {
    contents.add(content);
  }

  public void addDev(Dev dev) {
    enrolledDevs.add(dev);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Bootcamp bootcamp = (Bootcamp) o;

    return (
      Objects.equals(name, bootcamp.name) &&
      Objects.equals(description, bootcamp.description) &&
      Objects.equals(startDate, bootcamp.startDate) &&
      Objects.equals(endDate, bootcamp.endDate) &&
      Objects.equals(enrolledDevs, bootcamp.enrolledDevs) &&
      Objects.equals(contents, bootcamp.contents)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, startDate, endDate, enrolledDevs, contents);
  }
}
