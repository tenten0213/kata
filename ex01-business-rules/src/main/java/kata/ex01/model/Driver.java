package kata.ex01.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kawasima
 */
@Data
public class Driver implements Serializable {

    /** 月の利用回数 */
    private int countPerMonth;

    public int getCountPerMonth() {
        return countPerMonth;
    }

    public void setCountPerMonth(int countPerMonth) {
        this.countPerMonth = countPerMonth;
    }
}
