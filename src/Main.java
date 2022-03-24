/*ALGORITHM:
* INPUTS: Backpack Weight
* OUTPUTS: A pretty-printed list of the best items to take from the house to maximize value.
* CONSTRAINTS:
*   Backpack weight input must be a whole number.
*   Dollar amounts output by the program will be whole numbers. Cents are not considered
*
* main():
*   Instantiate a Scanner instance to accept user input
*   Read in the user's weight limit (must be as a string because Java)
*
*   if backpackWeightLimit is a valid integer:
*       convert to int and continue
*       Set the isInputValid flag to prevent the loop from firing again
*   else:
*       Print an error
*       Do not set the isInputValid flag, since our input is not valid.
*
*   Item[] itemsInHouse = generateList()
*   Item[] itemsInBackpack = Items[7]
*   backpackValue = 0
*   backpackWeight = 0
*
*   int maxValue = 0;
    int maxValueIndex = -1;
*   for (int i = 0; i < itemsInHouse.length; i++) {
*       for i in itemsInHouse do
                if (itemsInHouse[j].Value > maxValue) {
                    maxValue = itemsInHouse[j].Value;
                    maxValueIndex = j;
                }
        * Once we find the highest value, we check if adding its weight to the backpack will exceed the weight limit
        * of the backpack.
        * If it will, we set the value of the item to -1 (so that we won't select it again in the next run of the
        * nested for loop. We must also reset the maxValue and maxValueIndex variable to set up for the next run
        *
        * If not, we add the item to the backpack.
        *
        * In order to add the item, we add the item's weight to the backpack's weight and add the item's monetary
        * value to the total value of the backpack
        *
        * We must also create a new object for the item in the backpack (once we reset the values in the next step,
        * we lose the original value if we dont copy it somewhere)
        *
        * We then set the item's monetary value to an invalid number (such as -1) so that it won't be selected by the
        * next iteration of the nested for loop
        *
    }
*
*
* generateList():
* Instantiate a Random object to use to generate the weights and values for each item.
* Using the Item class, create an array of 7 items with randomized weights and values. Set the upper bound on the
* nextInt() calls to something sensible.
*   Optionally, you can set the random value like so: rng.nextInt(upper - lower) + lower. This will set a lower bound
*   for the random number generator. If this isn't done, its possible to get a weight of "0" on some runs.
* Call printList() to print the new list of items, then return the list
*
* printList():
*   for i:listToPrint do
*       if i is not null:
*           print i to the screen
*   for i:listToPrint do:
*       if i is not null:
*           Add the weight of i to totalWeight
*           Add the value of i to totalValue
*   print totalWeight
*   print totalValue
* */
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
                if (itemsInHouse[j].getValue() > maxValue) {
                    maxValue = itemsInHouse[j].getValue();
                    maxValueIndex = j;
                }
            }
            if (maxValueIndex != -1 && backpackWeight + itemsInHouse[maxValueIndex].getWeight() <= backpackWeightLimit) {
                itemsInBackpack[i] = new Item(itemsInHouse[maxValueIndex].getItemName(),
                        itemsInHouse[maxValueIndex].getWeight(), itemsInHouse[maxValueIndex].getValue());
                backpackWeight += itemsInHouse[maxValueIndex].getWeight();
                itemsInHouse[maxValueIndex].setValue(-1);
                maxValue = 0;
                maxValueIndex = -1;
            } else if (maxValueIndex != -1 && backpackWeight + itemsInHouse[maxValueIndex].getWeight() > backpackWeightLimit) {
                itemsInHouse[maxValueIndex].setValue(-1);
                maxValue = 0;
                maxValueIndex = -1;
            }
        }

        System.out.println("===Items in the Backpack===");
        printList(itemsInBackpack);

    }

    /* printList()
     * Parameters: Item[] listToPrint
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
                totalWeight += item.getWeight();
                totalValue += item.getValue();
            }
        }
        System.out.printf("Total Weight (lbs.): %52d\n", totalWeight);
        System.out.printf("Total Value  ($): %55d\n", totalValue);
    }

    /* generateList()
     * Parameters: int backpackWeightLimit
     * Returns: Item[]
     * Description: Generates the list of items, their values, and their weights. Calls printList() after the list is
     * generated
     * Note: backpackWeightLimit is brought in to allow you to mod the generated weights by it in order to ensure
     * that they're sensible for a given weight limit. If its deemed that this isn't necessary, the references to
     * backpackWeightLimit can be removed.*/
    private static Item[] generateList(int backpackWeightLimit) {
        Random rng = new Random();

        Item[] items = new Item[7];
        items[0] = new Item("PH CrapBook", (rng.nextInt(20-3)+3) % backpackWeightLimit, rng.nextInt(1000));
        items[1] = new Item("Sungsam TV", (rng.nextInt(100 - 50) + 50), rng.nextInt(2000));
        items[2] = new Item("Pear aPhone 16", (rng.nextInt(5 - 2) + 2), rng.nextInt(2500));
        items[3] = new Item("Keurig Coffee Maker", (rng.nextInt(20) + 1), rng.nextInt(200));
        items[4] = new Item("Rolex Wristwatch", (rng.nextInt(3 - 1) + 1), rng.nextInt(3000));
        items[5] = new Item("Weighted Sphere", (rng.nextInt(50 - 25) + 25)  % backpackWeightLimit, rng.nextInt(3000));
                // this item has sort of a story. Basically it's a hollow sphere of some sort of metal that for some
        // reason weighs a LOT. It's a curiosity, which is also why it costs so much
        items[6] = new Item("LEGO McLaren Formula 1 Car",
                (rng.nextInt(200 - 5) + 5)  % backpackWeightLimit, rng.nextInt(250)); // I needed another item that
        // went for a bit of money. That's what popped into my head.
        System.out.println("===Items in the House===");
        printList(items);
        System.out.println();
        return items;
    }


}
