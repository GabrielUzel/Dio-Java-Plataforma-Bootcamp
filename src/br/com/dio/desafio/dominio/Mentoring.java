package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoring extends Content {
  private LocalDate date;

  public Mentoring() {}

  public Mentoring(String title, String description, LocalDate date) {
    setTitle(title);
    setDescription(description);
    this.date = date;
  }

  @Override
  public double calculateXp() {
    return DEFAULT_XP + 20d;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return (
      "Mentoring{" +
      "title='" + getTitle() + '\'' +
      ", description='" + getDescription() + '\'' +
      ", date=" + date +
      '}'
    );
  }
}
