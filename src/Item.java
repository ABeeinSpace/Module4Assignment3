public class Item {
	String itemName;
	int weight;
	double value;

	public Item(String itemName, int weight, double value) {
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String output = "";
		output = output + String.format("%s %d %.0f", itemName, weight, value);
		return output;
	}
}
