package com.app.ordenaly.model.entity;

import com.app.ordenaly.model.enums.TicketStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

  @Column
  private LocalTime createdAt;

  @Column
  private LocalDate createdDate;

  @Column
  private int numberOfPeople;

  @Column
  @Enumerated(EnumType.STRING)
  private TicketStatus status;

  @OneToOne(mappedBy = "ticket")
  private Order relatedOrder;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalTime getCreatedAt() {
    return createdAt;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public void setCreatedAt(LocalTime createdAt) {
    this.createdAt = createdAt;
  }

  public int getNumberOfPeople() {
    return numberOfPeople;
  }

  public void setNumberOfPeople(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
  }

  public TicketStatus getStatus() {
    return status;
  }

  public void setStatus(TicketStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Ticket{" +
            "id=" + id +
            ", createdAt=" + createdAt +
            ", numberOfPeople=" + numberOfPeople +
            ", status=" + status +
            ", relatedOrder=" + relatedOrder +
            '}';
  }


}

//DOCS
/* 1. mappedBy, indica que Ticket no es la propietaria de la relación. El valor de mappedBy
  debe ser el nombre del atributo en la otra entidad que hace referencia a esta
  entidad en este caso (ticket en Order). */

/*Linea para formatear hora: @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")*/
