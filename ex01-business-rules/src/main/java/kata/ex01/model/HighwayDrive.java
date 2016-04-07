package kata.ex01.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author kawasima
 */
@Data
public class HighwayDrive implements Serializable {
    private LocalDateTime enteredAt;
    private LocalDateTime exitedAt;
    private VehicleFamily vehicleFamily;
    private RouteType routeType;
    private Driver driver;

    public LocalDateTime getEnteredAt() {
        return enteredAt;
    }

    public void setEnteredAt(LocalDateTime enteredAt) {
        this.enteredAt = enteredAt;
    }

    public LocalDateTime getExitedAt() {
        return exitedAt;
    }

    public void setExitedAt(LocalDateTime exitedAt) {
        this.exitedAt = exitedAt;
    }

    public VehicleFamily getVehicleFamily() {
        return vehicleFamily;
    }

    public void setVehicleFamily(VehicleFamily vehicleFamily) {
        this.vehicleFamily = vehicleFamily;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
