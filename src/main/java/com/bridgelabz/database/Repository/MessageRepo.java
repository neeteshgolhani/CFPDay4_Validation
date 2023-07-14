package com.bridgelabz.database.Repository;

import com.bridgelabz.database.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** UC4------------
Ability for the Greeting
App to save the
Greeting Message in the
Repository
*
*
*
* */
@Repository
public interface MessageRepo extends JpaRepository <Message,Integer>{
}
