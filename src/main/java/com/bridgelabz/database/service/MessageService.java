package com.bridgelabz.database.service;
import com.bridgelabz.database.DTO.MessageDTO;
import com.bridgelabz.database.Repository.MessageRepo;
import com.bridgelabz.database.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
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
        return messageRepo.findById(id);
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
        Optional<Message> messageData = getById(id);
        if(messageData.isPresent()){
            messageData.get().updateMessage(messageDTO);
            return messageRepo.save(messageData.get());
        }
        return null;
    }
}
