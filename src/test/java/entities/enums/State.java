package entities.enums;

public enum State {
    ALASKA("Alaska");

    private String stateName;

    State(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
