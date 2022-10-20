public class Car {
    private String registrationNumber;
    private String ownerName;
    private String brand;
    private String color;
    private int fabricationYear;
    private String problemDetails = "?";

    Car(String registrationNumber, String ownerName, String brand, String color, int fabricationYear){
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public String getProblemDetails() {
        return problemDetails;
    }

    public void setProblemDetails(String problemDetails) {
        this.problemDetails = problemDetails;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "Registration Number: '" + registrationNumber + '\'' +
                ", Owner Name: '" + ownerName + '\'' +
                ", Brand: '" + brand + '\'' +
                ", Color: '" + color + '\'' +
                ", Fabrication Year: " + fabricationYear +
                ", Problem Details: " + problemDetails;
    }
}
