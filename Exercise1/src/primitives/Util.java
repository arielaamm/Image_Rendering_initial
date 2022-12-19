package primitives;

public class Util {
    // It is binary, equivalent to ~1/1,000,000 in decimal (6 digits)
    private static final int ACCURACY = -40;

    
    /** 
     * @param num
     * @return 
     */
    // double store format: eeee eeee eeee (1.)mmmm … mmmm
    // 1 bit sign, 11 bits exponent, 53 bits (52 stored) normalized mantissa
    private static int getExp(double num) {
        return (int) ((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
    }

    
    /** 
     * @param number
     * @return 
     */
    public static boolean isZero(double number) {
        return getExp(number) < ACCURACY;
    }

    
    /** 
     * @param number
     * @return 
     */
    public static double alignZero(double number) {
        return getExp(number) < ACCURACY ? 0.0 : number;
    }

    
    /** 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Point))
            return false;
        Point other = (Point) obj;
        return super.equals(other);
    }

    
    /** 
     * @return 
     */
    @Override
    public String toString() {
        return "->" + super.toString();
    }
}
