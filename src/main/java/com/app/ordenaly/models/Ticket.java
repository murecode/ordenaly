package com.app.ordenaly.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "TICKET")
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TICKET_ID")
  @JsonProperty("ticket_id")
  private int id;
  @Column(name = "TICKET_TIME", length = 6)
  @JsonProperty("created_at") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
  private LocalTime time;
  // TODO opcion quitar de la orden el Estado del turno y ponerlo aqui
  // TODO agregar mesero asignado a este turno
  // TODO agregar propiedad Datos del cliente (crear clase cliente)


  public Ticket() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

}
