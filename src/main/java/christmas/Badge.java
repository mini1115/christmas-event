package christmas;

import java.util.Arrays;

public enum Badge {
    //    5천 원 이상: 별
//    - 1만 원 이상: 트리
//    - 2만 원 이상: 산타
    EMPTY(0, 0, "없음"),
    Star(5000, 10000, "별"),
    Tree(10000, 20000, "트리"),
    Santa(20000, 1_375_001, "산타");

    private final int min_value;
    private final int max_value;
    private final String grade;

    Badge(int min_value, int max_value, String grade) {
        this.min_value = min_value;
        this.max_value = max_value;
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    public static Badge getBadge(int min_value, int max_value) {
        return Arrays.stream(Badge.values()).filter(x -> x.min_value >= min_value && x.max_value < max_value).findAny().orElse(EMPTY);
    }

    public static String getGrade(int min_value, int max_value) {
        return getBadge(min_value, max_value).getGrade();
    }

}
