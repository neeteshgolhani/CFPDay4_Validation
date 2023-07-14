package com.bridgelabz.database.model;
import com.bridgelabz.database.DTO.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name ="message_data")
public class Message {
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
    public void updateMessage(MessageDTO messageDTO){
        this.title = messageDTO.title;
        this.author = messageDTO.author;
        this.endDate = messageDTO.endDate;
        this.startDate = messageDTO.startDate;
        this.discription = messageDTO.discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}