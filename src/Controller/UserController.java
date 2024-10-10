package Controller;

import Dto.UserRegistrationDto;
import Entity.Driver;
import Entity.Passenger;
import Entity.User;
import Entity.UserType;
import Repository.UserRepository;
import Service.UserService;
import Service.UserServiceImpl;
import Utils.RideSharingUtils;
import exception.InvalidUserDetailsException;
import exception.UserNotFoundException;

public class UserController {
    private UserService userService;

    public UserController(UserRepository userRepository) {

        this.userService = new UserServiceImpl(userRepository);
    }

    public User registerUser(UserRegistrationDto userRegistrationDto) throws InvalidUserDetailsException {
        validateUserRegistration(userRegistrationDto);
        User user;
        if(userRegistrationDto.getUserType().equals(UserType.DRIVER)){
            user = new Driver();
        } else {
            user = new Passenger();
        }
        user.setName(userRegistrationDto.getName());
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        user.setGender(userRegistrationDto.getGender());
        user.setAge(userRegistrationDto.getAge());
        return userService.registerUser(user);
    }

    public User getUser(int userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }


    private void validateUserRegistration(UserRegistrationDto userRegistrationDto) throws InvalidUserDetailsException {
        if(RideSharingUtils.isEmptyOrNull(userRegistrationDto.getName()) ||
                RideSharingUtils.isEmptyOrNull(userRegistrationDto.getPhoneNumber()) ){
            throw new InvalidUserDetailsException("Missing Details");
        }

        if(userRegistrationDto.getAge() < 18)
            throw new InvalidUserDetailsException("Invalid age");
    }

}
