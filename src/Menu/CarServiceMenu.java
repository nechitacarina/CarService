package Menu;
public enum CarServiceMenu {
    DISPLAY_ALL_EXISTING_CARS_IN_SERVICE(1, "Display all existing cars in service"),
    ADD_CARS_IN_SERVICE(2, "Add a new car in service"),
    ADD_CAR_QUOTE(3, "Add car quote"),
    DELETE_CARS_FROM_SERVICE(4, "Delete a car from service"),
    EXPORT_ALL_CARS_IN_TEXT_FILE(5, "Export all cars in a text file"),
    DISPLAY_CARS_OLDER_THAN_2020(6, "Display cars older than 2020"),
    DISPLAY_CARS_THAT_DONT_START(7, "Display cars that don't start"),
    EXIT(8, "Exit");

    private int optionNumber;
    private String optionDescription;

    CarServiceMenu(int optionNumber, String optionDescription){
        this.optionNumber = optionNumber;
        this.optionDescription = optionDescription;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getOptionDescription() {
        return optionDescription;
    }
}
