package christmas.domain;

import java.util.Arrays;

public enum BADGE {
    Star(5000, 10000, "별"),
    Tree(10000, 20000, "트리"),
    Santa(20000, 1_375_001, "산타"),
    EMPTY(0, 0, "없음");
    private final int min_value;
    private final int max_value;
    private final String grade;

    BADGE(int min_value, int max_value, String grade) {
        this.min_value = min_value;
        this.max_value = max_value;
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    public static BADGE getBadge(int min_value, int max_value) {
        return Arrays.stream(BADGE.values()).filter(x -> x.min_value <= min_value && x.max_value > max_value).findAny().orElse(EMPTY);
    }

    public static String getGrade(int min_value, int max_value) {
        return getBadge(min_value, max_value).getGrade();
    }

}
