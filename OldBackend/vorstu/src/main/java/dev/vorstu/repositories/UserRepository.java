package dev.vorstu.repositories;

import dev.vorstu.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    //Optional<User> findUserBuyId(Long id);
    //Optional<User>  findUserByUsername(String username);
}
