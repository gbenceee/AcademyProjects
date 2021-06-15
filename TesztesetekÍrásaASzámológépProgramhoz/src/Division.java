public class Division extends Operation {
 
    public Division(UserInputHandler in) {
        super(in);
    }
 
    @Override
    public void execute() {
        first = in.getDouble("Kérem, adja meg az első számot!");
        do {
            second = in.getDouble("Kérem, adja meg a második számot!");
            if (second == 0) {
                System.out.println("Nullával nem lehet osztani. Kérem, adja meg újra!");
            }
        } while (second == 0);
        double result = first / second;
        System.out.println("A hányados: " + result);
    }
 
}