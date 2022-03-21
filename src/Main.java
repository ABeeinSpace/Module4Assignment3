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
        * If it will, we set the value of the item to -1 (so that we won't select it again in the next run of the
        * nested for loop.
        *
        * If not, we add the item to the backpack
        *
        * In order to add the item, we add the item's weight to the backpack's weight and add the item's monetary
        * value to the total value of the backpack
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

        boolean isInputValid = false;
        while (!isInputValid) {
            System.out.print("Please enter a weight limit for the backpack (Must be a valid integer): ");
            String backpackWeightLimitString = in.next();

            if (backpackWeightLimitString.matches("^-?\\d+$")) {
                backpackWeightLimit = Integer.parseInt(backpackWeightLimitString);
                isInputValid = true;
            } else {
                System.out.println("ERROR: Weight limit entered is NOT an integer!");
                // We need to loop back around to allow the user to try again. By not setting the isInputValid flag,
                // we repeat the loop to allow the user another crack at it
            }
        }

        Item[] itemsInHouse = generateList(backpackWeightLimit);

        Item[] itemsInBackpack = new Item[7];
        int backpackWeight = 0;

        int maxValue = 0;
        int maxValueIndex = -1;
        for (int i = 0; i < itemsInHouse.length; i++) {
            for (int j = 0; j < itemsInHouse.length; j++) {
                if (itemsInHouse[j].value > maxValue) {
                    maxValue = itemsInHouse[j].value;
                    maxValueIndex = j;
                }
            }
            if (maxValueIndex != -1 && backpackWeight + itemsInHouse[maxValueIndex].weight <= backpackWeightLimit) {
                itemsInBackpack[i] = new Item(itemsInHouse[maxValueIndex].itemName,
                        itemsInHouse[maxValueIndex].weight, itemsInHouse[maxValueIndex].value);
                backpackWeight += itemsInHouse[maxValueIndex].weight;
                itemsInHouse[maxValueIndex].value = -1;
                maxValue = 0;
                maxValueIndex = -1;
            } else if (maxValueIndex != -1 && backpackWeight + itemsInHouse[maxValueIndex].weight > backpackWeightLimit) {
                itemsInHouse[maxValueIndex].value = -1;
                maxValue = 0;
                maxValueIndex = -1;
            }
        }

        System.out.println("===Items in the Backpack===");
        printList(itemsInBackpack);

    }

    /* printList()
     * Parameters: item[] listToPrint
     * Returns: N/A (Void)
     * Description: Prints the list of items once generateList() generates it. Is also capable of printing the
     * list of items in the backpack once that is determined.*/
    private static void printList(Item[] listToPrint) {
        System.out.printf("%-44s%-15s%6s\n", "Item Name", "Item Weight", "Item Value ($)");
        System.out.println("=========================================================================");
        for (Item item : listToPrint) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println("=========================================================================");
        System.out.println("GRAND TOTALS:");
        int totalWeight = 0;
        int totalValue = 0;
        for (Item item : listToPrint) {
            if (item != null) {
                totalWeight += item.weight;
            }
        }
        for (Item item : listToPrint) {
            if (item != null) {
                totalValue += item.value;
            }
        }
        System.out.printf("Total Weight (lbs.): %52d\n", totalWeight);
        System.out.printf("Total Value  ($): %55d\n", totalValue);
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

        Item[] items = new Item[7];
        items[0] = new Item("PH CrapBook", (rng.nextInt(20-3)+3) % backpackWeightLimit, rng.nextInt(1000));
        items[1] = new Item("Sungsam TV", (rng.nextInt(100 - 50) + 50), rng.nextInt(2000));
        items[2] = new Item("Pear aPhone 16", (rng.nextInt(5 - 2) + 2), rng.nextInt(2500));
        items[3] = new Item("Keurig Coffee Maker", (rng.nextInt(20) + 1), rng.nextInt(200));
        items[4] = new Item("Rolex Wristwatch", (rng.nextInt(3 - 1) + 1), rng.nextInt(3000));
        items[5] = new Item("Weighted Sphere", (rng.nextInt(50 - 25) + 25)  % backpackWeightLimit, rng.nextInt(3000));
        items[6] = new Item("LEGO McLaren Formula 1 Car",
                (rng.nextInt(20 - 5) + 5)  % backpackWeightLimit, rng.nextInt(400));
        System.out.println("===Items in the House===");
        printList(items);
        System.out.println();
        return items;
    }


}
