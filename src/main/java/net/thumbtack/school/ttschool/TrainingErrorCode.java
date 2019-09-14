package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Error firstname"),
    TRAINEE_WRONG_LASTNAME("Error lastname"),
    TRAINEE_WRONG_RATING("Error rating"),
    GROUP_WRONG_NAME("Error name group"),
    GROUP_WRONG_ROOM("Error room group"),
    TRAINEE_NOT_FOUND("Element not found"),
    SCHOOL_WRONG_NAME("Error name school"),
    DUPLICATE_GROUP_NAME("Dublicate group name"),
    GROUP_NOT_FOUND("Element not found"),
    DUPLICATE_TRAINEE("Doublicate trainee"),
    EMPTY_TRAINEE_QUEUE("Empty trainee");

    String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
