public class Menu {
    private UserInputHandler in;
 
    public Menu(UserInputHandler in) {
        this.in = in;
    }
 
    public void print() {
        System.out.println("1. Összeadás");
        System.out.println("2. Kivonás");
        System.out.println("3. Szorzás");
        System.out.println("4. Osztás");
        System.out.println("5. Kilépés");
    }
 
    public int chooseMenuOption() {
        int choice = in.getInteger("Kérem, adja meg a menüpontot.", 1, 5);
        return choice;
    }
 
}