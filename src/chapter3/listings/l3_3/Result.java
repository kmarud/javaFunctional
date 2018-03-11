package chapter3.listings.l3_3;

public interface Result {

    class Success implements Result {}

    class Failure implements Result {

        private final String errorMessage;

        public Failure(String s) {
            this.errorMessage = s;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
