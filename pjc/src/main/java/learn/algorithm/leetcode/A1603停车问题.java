package learn.algorithm.leetcode;

import org.junit.Test;

/**
 * @author : MichealPan
 * @description :
 * @create : 2021-03-19 10:38
 */
public class A1603停车问题 {

    @Test
    public void test() {
        ParkingSystem parkingSystem = new ParkingSystem(5, 7, 9);
        parkingSystem.addCar(1);
        parkingSystem.addCar(1);
        parkingSystem.addCar(1);
        parkingSystem.addCar(2);
        parkingSystem.addCar(3);
        parkingSystem.addCar(2);

        parkingSystem.addCar(1);


    }


    class ParkingSystem {
        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (big > 0) {
                        big--;
                        return true;
                    }
                    return false;
                case 2:
                    if (medium > 0) {
                        medium--;
                        return true;
                    }
                    return false;
                case 3:
                    if (small > 0) {
                        small--;
                        return true;
                    }
                    return false;
            }
            return false;
        }
    }
}
