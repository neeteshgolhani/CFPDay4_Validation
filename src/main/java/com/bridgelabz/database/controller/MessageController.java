package com.bridgelabz.database.controller;
import com.bridgelabz.database.DTO.MessageDTO;
import com.bridgelabz.database.DTO.ResponseDTO;
import com.bridgelabz.database.Repository.MessageRepo;
import com.bridgelabz.database.model.Message;
import com.bridgelabz.database.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**UC1----------------

* Using GreetingController return
* JSON for different HTTP Methods.
*
* */
@RestController
@Validated
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private MessageService messageService;
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addMessage(@Valid @RequestBody MessageDTO messageDTO) {
        ResponseDTO responseDTO = new ResponseDTO( "data added successfully", messageService.addMessage(messageDTO));
        return  new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Data fatch successfully",messageService.getById(id));

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
   public ResponseEntity<ResponseDTO> updateMessage(@Valid @PathVariable int id, @RequestBody MessageDTO messageDTO) {
        ResponseDTO responseDTO = new ResponseDTO("data updated",messageService.updateMessage(id, messageDTO));
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    /**UC8------------
     * Ability for the Greeting
     *
     * App to delete a Greeting
     *
     * Messages in the
     *
     * Repository
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable int id) {
        Optional<Message> messageData = messageRepo.findById(id);
        if (messageData.isPresent()) {
            messageRepo.deleteById(id);
            return ResponseEntity.ok("Message deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}

