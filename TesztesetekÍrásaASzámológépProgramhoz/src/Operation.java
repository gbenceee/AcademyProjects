public class Operation {
    protected UserInputHandler in;
    protected double first;
    protected double second;
 
    public Operation(UserInputHandler in) {
        this.in = in;
    }
 
    public void execute() {
        first = in.getDouble("Kérem, adja meg az első számot!");
        second = in.getDouble("Kérem, adja meg a második számot!");
    }
 
}