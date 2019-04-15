package lambdas;

public class Lambdas {

    public static void main(String args[]){
        Lambdas tester = new Lambdas();

        //with type declaration
        //MathOperation addition = (int a, int b) -> a + b;

        //System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}