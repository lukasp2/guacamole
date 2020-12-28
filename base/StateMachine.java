package base;

import base.states.State;

import java.util.Stack;

public class StateMachine {
    Stack<State> stack = new Stack<State>();
    Window window;
    Boolean running = true;

    // initates the state machine with desired state
    public StateMachine(State state, Window window) {
        this.push(state);
        this.window = window;
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

    // runs the state machine
    public void run() {
        while (running) {
            stack.peek().getInput();
            stack.peek().tick();
            stack.peek().render();
        }
    }
}