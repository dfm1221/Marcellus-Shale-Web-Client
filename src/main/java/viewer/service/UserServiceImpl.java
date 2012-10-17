package viewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import viewer.dao.UserDao;
import viewer.dto.UserDto;
import viewer.model.User;

import java.util.List;

/**
 * User: Justin Ford
 * Date: 10/8/12
 * Time: 8:04 PM
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public UserDto createUser(UserDto userDto) {

        // create User entity
        User user = toEntity(userDto, User.class);
        updateUserPassword(userDto, user);

        userDao.create(user);
        return beanMapper.fromEntity(user, UserDto.class);
    }

    @Transactional
    public UserDto updateUser(UserDto userDto) {

        User user = userDao.read(userDto.getId());

        beanMapper.map(userDto, user);
        userDao.update(user);
        return beanMapper.fromEntity(user, UserDto.class);
    }

    private void updateUserPassword(UserDto userDto, User user) {
        //todo
    }

    @Override
    public UserDto getUser(Long userId) {
        return fromEntity(userDao.read(userId), UserDto.class);
    }

}
