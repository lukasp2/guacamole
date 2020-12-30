package base.states.menus;

public class Start extends Menu {
    private static final long serialVersionUID = -2011243664367333350L;

    public Start() {
        super.addTitle("Main Menu");
        super.addOptions("start game", "game settings", "high score", "exit");
    }

    public void tick() {
        super.tick();
    }
}    

