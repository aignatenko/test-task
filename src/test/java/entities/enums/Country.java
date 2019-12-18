package entities.enums;

public enum Country {
    UNITED_STATES("United States");

    private String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
