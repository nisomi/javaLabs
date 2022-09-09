package lab_1;

/**
 * Class creates Lucas numbers and determines which one of the nth numbers of the Lucas sequence
 * can be presented in the form of w^2-1 (1 less than a certain square of a number)
 */
public class LucasNumber{
    private int number;
    private long value;

    /**
     * Constructors container for Lucas number.
     * Finds value of nth Lucas number.
     * @param number - number of Lucas number in sequence
     */
    public LucasNumber(int number, long value) {
        this.number = number;
        this.value = value;
    }

    /**
     * Getter to return n of Lucas number
     * @return - returns n of Lucas number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getter to return value of Lucas number
     * @return - returns value of nth Lucas number
     */
    public long getValue() {
        return value;
    }

    /**
     * String representation that shows Lucas number value and n position in Lucas sequence
     * @return - string representation of Lucas number object
     */
    @Override
    public String toString() {
        return "LucasNumber {" + "number = " + number + ", value = " + value + "}\n";
    }

    /**
     * Method checks whether the value of a number is 1 less than a certain square of some number
     * @return - returns the result of the check
     */
    public boolean checkPerfectSquare()
    {
        double sqrt=Math.sqrt((double)value + 1);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
}

