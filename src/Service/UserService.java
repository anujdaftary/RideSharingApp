package Service;

import Entity.Driver;
import Entity.User;
import exception.UserNotFoundException;

public interface UserService {
    public User registerUser(User user);
    public Driver getUser(int userId) throws UserNotFoundException;
    public Driver getDriver(int driverId) throws UserNotFoundException;
}
