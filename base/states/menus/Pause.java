package base.states.menus;

public class Pause extends Menu {
    private static final long serialVersionUID = 6010686138069172337L;

    public Pause() {
        super.addTitle("Game Paused");
        super.addOptions("Resume", "Quit to main menu");
    }
}