package domain;

public enum RestartNumber {
    DEFAULT_START("0"),
    RESTART_GAME("1"),
    DONT_START_GAME("2");

    private final String restartNumber;

    RestartNumber(String restartNumber) {
        this.restartNumber = restartNumber;
    }

    public String getRestartNumber() {
        return restartNumber;
    }
}
