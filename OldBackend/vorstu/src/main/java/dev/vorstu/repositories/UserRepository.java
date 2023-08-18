package dev.vorstu.repositories;

import dev.vorstu.entities.Board;
import dev.vorstu.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u  WHERE username = :username")
    User getUser(@Param("username") String username);
}
