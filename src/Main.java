/*ALGORITHM:
* INPUTS: Backpack Weight
* OUTPUTS: A pretty-printed list of the best items to take from the house to maximize value.
* CONSTRAINTS:
*
* main():
*   Instantiate a Scanner instance to accept user input
*   Read in the user's weight limit (must be as a string because Java)
*
*   if backpackWeightLimit is a valid integer:
*       convert to int and continue
*   else:
*       Print an error
*
*   Item[] itemsInHouse = generateList()
*   Item[] itemsInBackpack = Items[10]
*   backpackValue = 0
*   backpackWeight = 0
*
*   for (int i = 0; i < itemsInHouse.length; i++) {
        for (int j = i; j < itemsInHouse.length - 1; j++) {
            We need to find the item with the highest value in the list.
        }
        * Once we find the highest value, we check if adding its weight to the backpack will exceed the weight limit
        * of the backpack.
        * If it will, we set the value of the item to -1 (so that we wont select it again in the next run of the
        * nested for loop.
        *
        * If not, we add the item to the backpack
        *
        * In order to add the item, we add the item's weight to the backpack's weight
        *
        * We then set the item's monetary value to an invalid number (such as -1) so that it won't be selected by the
        * next iteration of the nested for loop
        *
    }
*
*
* generateList():
* Instantiate a Random object to use to generate the weights and values for each item.
* Using the Item class, create an array of 10 items with randomized weights and values. Set the upper bound on the
* nextInt() calls to something sensible.
* Call printList() to print the new list of items, then return
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

        Item[] itemsInHouse = generateList(backpackWeightLimit);

        Item[] itemsInBackpack = new Item[10];
        int backpackValue = 0;
        int backpackWeight = 0;

        for (int i = 0; i < itemsInHouse.length; i++) {
            for (int j = i; j < itemsInHouse.length - 1; j++) {

            }
        }

    }

    /* printList()
     * Parameters: item[] listToPrint
     * Returns: N/A (Void)
     * Description: Prints the list of items once generateList() generates it.*/
    private static void printList(Item[] listToPrint) {
        for (int i = 0; i < listToPrint.length; i++) {
            System.out.println(listToPrint[i]);
        }
    }

    /* generateList()
     * Parameters: int backpackWeightLimit
     * Returns: Item[]
     * Description: Generates the list of items, their values, and their weights. Calls printList() after the list is
     *  generated*/
    private static Item[] generateList(int backpackWeightLimit) {
        // Remember that you should mod generated weights by the backpack's weight limit to ensure that the numbers
        // are usable
        Random rng = new Random();

        Item[] items = new Item[5];

        items[0] = new Item("PH CrapBook", rng.nextInt(10) % backpackWeightLimit, rng.nextInt(1000));
        items[1] = new Item("Sungsam TV", rng.nextInt(100) % backpackWeightLimit, rng.nextInt(2000));
        items[2] = new Item("Pear aPhone 16", rng.nextInt(5), rng.nextInt(2500));
        items[3] = new Item("Keurig coffee maker", rng.nextInt(20), rng.nextInt(200));
        items[4] = new Item("Rolex wristwatch", rng.nextInt(3), rng.nextInt(3000));
        printList(items);
        return items;
    }


}
