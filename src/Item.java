public class Item {
	String itemName;
	int weight;
	int value;

	public Item(String itemName, int weight, int value) {
		this.itemName = itemName;
		this.weight = weight;
		this.value = value;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String output = "";
		output = output + String.format("%s %d %d", itemName, weight, value);
		return output;
	}
}
