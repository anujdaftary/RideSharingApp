package Service;

import Entity.Vehicle;
import exception.VehicleNotFoundException;

public interface VehicleService {
    Vehicle registerVehicle(Vehicle vehicle);
    Vehicle getVehicle(int vehicleId) throws VehicleNotFoundException;
}
