package base.states;

import base.StateMachine;

public class State {
    public StateMachine sm;

    public void getInput() {} // get and store input
    
    public void tick() {} // process game information
    
    public void render() {} // draw result to screen
}