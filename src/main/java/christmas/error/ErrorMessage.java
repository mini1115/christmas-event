package christmas.error;

public enum ErrorMessage {
    ERROR_DAY_LIMIT("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_ORDER_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_MENU_FORMAT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
