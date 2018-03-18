package chapter4.listings.my;

public class Main {
    public static void main(String[] args) {
        int n=6000;
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int number){
        if (number ==0 || number == 1)
            return number;
        return fibonacci(number - 1 ) + fibonacci(number -2);
    }

}
