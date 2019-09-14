package net.thumbtack.school.colors;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Wrong string"),
    NULL_COLOR("String is null");

    String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
