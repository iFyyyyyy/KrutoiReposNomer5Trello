package dev.vorstu.Repositories;

import dev.vorstu.Entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    //Optional<User> findUserBuyId(Long id);
    //Optional<User>  findUserByUsername(String username);
}
