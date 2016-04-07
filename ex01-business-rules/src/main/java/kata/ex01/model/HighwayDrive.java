package kata.ex01.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author kawasima
 */
@Data
public class HighwayDrive implements Serializable {

    /** 高速道路利用開始時刻 */
    private LocalDateTime enteredAt;

    /**高速道路利用終了時刻 */
    private LocalDateTime exitedAt;

    /** 車種 */
    private VehicleFamily vehicleFamily;

    /** 経路タイプ */
    private RouteType routeType;

    /** ドライバ */
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
