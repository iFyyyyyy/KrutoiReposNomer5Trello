package dev.vorstu.mappers;

import dev.vorstu.dto.UserDTO;
import dev.vorstu.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDataMapper {

    UserDataMapper INSTANCE = Mappers.getMapper(UserDataMapper.class);

    UserDTO UserToUserDTO (User user);
}
