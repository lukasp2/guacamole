package base;

import base.states.State;

import java.util.Stack;

public class StateMachine {
    public Stack<State> stack = new Stack<State>();
    public Boolean running = false;
    
    // initates the state machine with desired state
    public StateMachine(State state) {
        this.push(state);
    }

    // adds one or more states to the stack
    public void push(State... states) {
        for (State state : states) {
            state.sm = this;
            stack.push(state);
        }
    }

    // pops n states and returns new head
    public State pop(int numStates) { 
        for (int i = 0; i < numStates; ++i) {
            stack.pop();
        }
        return stack.peek();
    }
}