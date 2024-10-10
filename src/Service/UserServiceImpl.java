package Service;

import Entity.Driver;
import Entity.User;
import Repository.UserRepository;
import exception.UserNotFoundException;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Driver getUser(int userId) throws UserNotFoundException {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new UserNotFoundException("User is not found for id: " + user);

        return (Driver) user;
    }

    @Override
    public Driver getDriver(int driverId) throws UserNotFoundException {
        return null;
    }
}
