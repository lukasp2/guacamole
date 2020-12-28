package base;

import base.states.menus.Start;
import base.states.State;

public class Main {
    public static void main(String[] args) {
        // create a window
        Window window = new Window("Guacamole");

        // create initial state
        State start = new Start();

        // create state machine
        StateMachine sm = new StateMachine(start, window);

        // run state machine
        sm.run();
    }
}