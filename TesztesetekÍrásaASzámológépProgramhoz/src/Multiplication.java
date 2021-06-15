public class Multiplication extends Operation {
 
    public Multiplication(UserInputHandler in) {
        super(in);
    }
 
    @Override
    public void execute() {
        super.execute();
        double result = first * second;
        System.out.println("A szorzat: " + result);
    }
 
}