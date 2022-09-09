package lab_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class creates Lucas numbers sequence and determines which of the nth numbers of the Lucas sequence
 * can be presented in the form of w^2-1 (1 less than a certain square of a number)
 */
public class LucasNumbersSequence {
    public List<LucasNumber> lucasNumberList = new ArrayList<>();

    /**
     * Method that generates the sequence of Lucas numbers
     * @param num - number of Lucas number in sequence
     */
    public void GenerateSequence(int num){
        lucasNumberList.add(new LucasNumber(0,2));
        lucasNumberList.add(new LucasNumber(1,1));
        for (int i = 2; i < num; i++) {
            lucasNumberList.add(new LucasNumber(i,findLucasValue(i,lucasNumberList.get(i-1).getValue(),lucasNumberList.get(i-2).getValue())));
        }
    }

    /**
     * Method that finds the value of the nth Lucas number in the sequence
     * @param number - number of Lucas number in sequence
     * @param prev1 - value of the first preceding Lucas number in the sequence
     * @param prev2 - value of the second preceding Lucas number in the sequence
     * @return - returns value of the nth Lucas number
     */
    private long findLucasValue(int number, long prev1, long prev2) {
        return prev1+prev2;
    }

    /**
     * String representation that shows sequence of Lucas numbers
     * @return - string representation of Lucas number sequence
     */
    @Override
    public String toString() {
        return "LucasNumbersSequence{" + "lucasNumberList=" + lucasNumberList + '}';
    }

    /**
     * Method checks whether the value of a numbers in the sequence is 1 less than a certain square of some number
     * @return - returns a list of Lucas number objects that match the given condition
     */
    public List<LucasNumber> CheckSequence(){
        List<LucasNumber> CheckedList = new ArrayList<>();
        for (LucasNumber lucasNumber : lucasNumberList) {
            if (lucasNumber.checkPerfectSquare()) {
                CheckedList.add(lucasNumber);
            }
        }
        return CheckedList;
    }
}

