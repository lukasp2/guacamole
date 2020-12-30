package base.states.menus;

public class GameOver extends Menu {
    private static final long serialVersionUID = 451956262471663224L;

    public GameOver() {
        super.addTitle("Game Over");
        super.addOptions("Try Again", "Back to main menu");
    }
}
