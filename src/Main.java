/*ALGORITHM:
* INPUTS: Backpack Weight
* OUTPUTS: A pretty-printed list of the best items to take from the house to maximize value.
* CONSTRAINTS:
* main():
* Instantiate a Scanner instance to accept user input
* Read in the user's weight limit (must be as a string because Java)
* Check if the weight limit entered is a valid integer.
*   If it is a valid integer, we can proceed.
*   If the input is not an integer, we print an error and ask the user to try again.
* Call generateList() to get the list of items inside the house and their weights and values. Assign the result
*  of the function to a variable.
*
*
*
*
*
* generateList():
* Instantiate a Random object to use to generate the weights and values for each item.
* Generate an array of Items objects to use for the items in the house.
*
* */

/*NOTES:
* Should probably mod the object's weights by the weight limit after its randomly generated, so we don't exceed that
* limit with one item.*/

import java.util.*;

public class Main {

    /* main()
    * Parameters: String[] args
    * Returns: N/A
    * Description: Method to support running/testing of project code
    * Special: Method gets implicitly called by java at runtime, and only exits at program exit.*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int backpackWeightLimit = 0;

        System.out.print("Please enter a weight limit for the backpack (Must be a valid integer): ");
        String backpackWeightLimitString = in.next();

        if (backpackWeightLimitString.matches("^-?\\d+$")) {
            backpackWeightLimit = Integer.parseInt(backpackWeightLimitString);
        } else {
            System.out.println("ERROR: Weight limit entered is NOT an integer!");
            // We need to loop back around to allow the user to try again. Note: the program will
            // fail and bail during development.
             System.exit(-1);
        }

        generateList(backpackWeightLimit);



    }

    /* printList()
     * Parameters:
     * Returns: N/A (Void)
     * Description: Prints the list of items once generateList() generates it.*/
    private static void printList() {

    }

    /* generateList()
     * Parameters: int backpackWeightLimit
     * Returns: N/A (Void)
     * Description: Generates the list of items, their values, and their weights. Calls printList() after the list is
     *  generated*/
    private static void generateList(int backpackWeightLimit) {
        // Remember that you should mod generated weights by the backpack's weight limit to ensure that the numbers
        // are usable
        Random rng = new Random();


    }


}
