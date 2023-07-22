package com.bridgelabz.database.model;
import com.bridgelabz.database.DTO.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
/** UC3-----------
* Ability for the Greeting App to
give Greeting message with
1. User First Name and Last
Name or
2. With just First Name or Last
Name based on User
attributes provides or
3. Just Hello World.
*
*
* */
@Entity
@Table(name ="messagedata")
public @Data class Message {
    public Message() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String author;
    private String discription;
    private LocalDate startDate;
    private LocalDate endDate;

    public Message(MessageDTO messageDTO) {

        this.updateMessage(messageDTO);
    }

    public void updateMessage(MessageDTO messageDTO) {
        this.title = messageDTO.title;
        this.author = messageDTO.author;
        this.endDate = messageDTO.endDate;
        this.startDate = messageDTO.startDate;
        this.discription = messageDTO.discription;
    }
}