package datastructure.leetcode.design;

/**
 * 1603. 设计停车系统
 */
public class ParkingSystem {
    static int big = 0;
    static int medium = 0;
    static int small = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    /**
     * 1表示big 2表示medium 3表示small
     *
     * @param carType
     * @return
     */
    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big >= 1) {
                    big--;
                    return true;
                }
                break;
            case 2:
                if (medium >= 1) {
                    medium--;
                    return true;
                }
                break;
            case 3:
                if (small >= 1) {
                    small--;
                    return true;
                }
                break;
        }
        return false;
    }

    public static void main(String[] args) {

        ParkingSystem p = new ParkingSystem(1,1,0);
        System.out.println(p.addCar(1));
        System.out.println(p.addCar(2));
        System.out.println(p.addCar(3));
        System.out.println(p.addCar(1));
    }
}
