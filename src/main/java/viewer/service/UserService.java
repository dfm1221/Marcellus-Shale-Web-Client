package viewer.service;

import viewer.dto.UserDto;

/**
 * User: Justin Ford
 * Date: 10/8/12
 * Time: 7:56 PM
 */
public interface UserService{

    UserDto createUser(UserDto User);

    UserDto updateUser(UserDto UserDto);

    UserDto getUser(Long userId);

}
