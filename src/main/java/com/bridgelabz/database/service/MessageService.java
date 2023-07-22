package com.bridgelabz.database.service;
import com.bridgelabz.database.DTO.MessageDTO;
import com.bridgelabz.database.Exception.CostumException;
import com.bridgelabz.database.Repository.MessageRepo;
import com.bridgelabz.database.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**UC2---------

ExtendGreetingController to
use Services Layer to get
Simple Greeting
message ”Hello World”

* */
@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public Message addMessage(MessageDTO messageDTO) {
        Message messageData = new Message(messageDTO);
        return messageRepo.save(messageData);
    }
    /**\UC5---------------
     * Ability for the Greeting
     *
     * App to find a Greeting
     *
     * Message by Id in the
     *
     * Repository
     *
     */
    public Optional<Message> getById(int id){

        return Optional.ofNullable(messageRepo.findById(id).orElseThrow(() -> new CostumException("message with id :" + id + " is not present")));
    }
    /**UC6---------------
     * Ability for the Greeting
     *
     * App to List all the
     *
     * Greeting Messages in
     *
     * the Repository
     */
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }
/**UC7---------------
 * Ability for the Greeting

 App to Edit a Greeting

 Messages in the

 Repository
 * */
    public Message updateMessage(int id, MessageDTO messageDTO) {
        Message messageData = getById(id).get();
            messageData.updateMessage(messageDTO);
            return messageRepo.save(messageData);

    }
    public ResponseEntity<String> deleteMessage(int id) {
        if (messageRepo.existsById(id)) {
            messageRepo.deleteById(id);

            return ResponseEntity.ok("Task Deleted Successfully");
        }
        return null;
    }

}
