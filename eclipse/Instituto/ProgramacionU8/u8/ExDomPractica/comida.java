package ExDomPractica;

public class comida {
	 private String name;
     private Double price;
     private String description;
     private Integer calories;
     private String Healthy;
    
	public comida() {}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	Double getPrice() {
		return price;
	}

	void setPrice(Double price) {
		this.price = price;
	}

	String getDescription() {
		return description;
	}

	void setDescription(String description) {
		this.description = description;
	}

	Integer getCalories() {
		return calories;
	}

	void setCalories(Integer calories) {
		this.calories = calories;
	}

	String getHealthy() {
		return Healthy;
	}

	void setHealthy(String healthy) {
		Healthy = healthy;
	}

	@Override
	public String toString() {
		return  name + "[price=" + price + ", description=" + description + ", calories=" + calories
				+ ", Healthy=" + Healthy + "]";
	}   
}
