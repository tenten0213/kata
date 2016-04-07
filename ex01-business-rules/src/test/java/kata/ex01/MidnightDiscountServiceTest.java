package kata.ex01;

import kata.ex01.model.Driver;
import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author tenten0213
 */
public class MidnightDiscountServiceTest {

    DiscountService discountService;
    private Driver driver() {
        Driver driver = new Driver();
        driver.setCountPerMonth(0);
        return driver;
    }

    private HighwayDrive highwayDrive(LocalDateTime enteredAt, LocalDateTime exitedAt, RouteType routeType, VehicleFamily vehicleFamily) {
        HighwayDrive highwayDrive = new HighwayDrive();
        highwayDrive.setDriver(driver());
        highwayDrive.setEnteredAt(enteredAt);
        highwayDrive.setExitedAt(exitedAt);
        highwayDrive.setRouteType(routeType);
        highwayDrive.setVehicleFamily(vehicleFamily);
        return highwayDrive;
    }

    @Before
    public void setUp() {
        discountService = new MidnightDiscountService();
    }

    @Test
    public void 毎日0時から4時まで30パーセント割り引かれること() throws Exception {
        HighwayDrive highwayDrive = highwayDrive(
                LocalDateTime.of(2016, 4, 7, 0, 0, 0, 0), // 0時
                LocalDateTime.of(2016, 4, 7, 4, 0, 0, 0), // 4時
                RouteType.RURAL, VehicleFamily.MINI);
        assertThat(30, is(discountService.calc(highwayDrive)));
    }

    @Test
    public void 毎日0時から4時まで30パーセント割り引かれること_高速道路に入った時間が対象() throws Exception {
        HighwayDrive highwayDrive = highwayDrive(
                LocalDateTime.of(2016, 4, 7, 0, 0, 0, 0), // 0時
                LocalDateTime.of(2016, 4, 7, 5, 0, 0, 0), // 5時
                RouteType.RURAL, VehicleFamily.MINI);
        assertThat(30, is(discountService.calc(highwayDrive)));
    }

    @Test
    public void 毎日0時から4時まで30パーセント割り引かれること_高速道路を出た時間が対象() throws Exception {
        HighwayDrive highwayDrive = highwayDrive(
                LocalDateTime.of(2016, 4, 6, 23, 0, 0, 0), // 23時
                LocalDateTime.of(2016, 4, 7, 4, 0, 0, 0), // 4時
                RouteType.RURAL, VehicleFamily.MINI);
        assertThat(30, is(discountService.calc(highwayDrive)));
    }

    @Test
    public void 毎日0時から4時まで30パーセント割り引かれること_高速道路に乗っている時間が対象() throws Exception {
        HighwayDrive highwayDrive = highwayDrive(
                LocalDateTime.of(2016, 4, 6, 23, 0, 0, 0), // 23時
                LocalDateTime.of(2016, 4, 7, 5, 0, 0, 0), // 5時
                RouteType.RURAL, VehicleFamily.MINI);
        assertThat(30, is(discountService.calc(highwayDrive)));
    }

    @Test
    public void すべての車種が割引対象になること() throws Exception {
        for (VehicleFamily vehicleFamily : VehicleFamily.values()) {
            HighwayDrive highwayDrive = highwayDrive(
                    LocalDateTime.of(2016, 4, 7, 0, 0, 0, 0), // 0時
                    LocalDateTime.of(2016, 4, 7, 4, 0, 0, 0), // 4時
                    RouteType.RURAL, vehicleFamily);
            assertThat(30, is(discountService.calc(highwayDrive)));
        }
    }
}