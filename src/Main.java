import Controller.UserController;
import Controller.VehicleController;
import Dto.UserRegistrationDto;
import Dto.VehicleRegistrationDto;
import Entity.User;
import Entity.UserType;
import Entity.Vehicle;
import Entity.VehicleType;
import Repository.UserRepository;
import Repository.VehicleRepository;
import exception.InvalidUserDetailsException;
import exception.UserNotFoundException;
import exception.VehicleNotFoundException;

public class Main {
    public static void main(String[] args) throws InvalidUserDetailsException, UserNotFoundException, VehicleNotFoundException {
        UserRepository userRepository = new UserRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        UserController userController = new UserController(userRepository);
        VehicleController vehicleController = new VehicleController(vehicleRepository, userRepository);

        UserRegistrationDto userRegistrationDto = new UserRegistrationDto(
                "Anuj",
                "1234",
                22,
                'M',
                UserType.DRIVER
        );

        userController.registerUser(userRegistrationDto);
        User savedUser = userController.getUser(1);
        System.out.println(savedUser);

        VehicleRegistrationDto vehicleRegistrationDto = new VehicleRegistrationDto(
                "BMW X5",
                "KA01-1234",
                VehicleType.SUV,
                "Blue",
                1);

        vehicleController.registerVehicle(vehicleRegistrationDto);
        Vehicle savedVehicle = vehicleController.getVehicle(1);
        System.out.println(savedVehicle);
    }
    }
