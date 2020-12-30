package base;

import base.states.State;

import java.util.Stack;

public class StateMachine {
    private Stack<State> stack = new Stack<State>();
    public Window window;
    public Boolean running = false;

    // initates the state machine with desired state
    public StateMachine(Window window) {
        this.window = window;
    }

    // gets current state
    public State peek() {
        return stack.peek();
    }

    // adds one or more states to the stack
    public void push(State... states) {
        for (State state : states) {
            window.frame.add(state);
            window.frame.setVisible(true);
            state.sm = this;
            state.addKeyListener(new KeyInput(state));
            // remove kb listen from stack[-2]!!!!!!!
            stack.push(state);
        }
    }

    // pops n states and returns new head
    public State pop(int numStates) { 
        for (int i = 0; i < numStates; ++i) {
            // remove kb listen from stack[-1]????????????
            stack.pop();
        }
        stack.peek().addKeyListener(new KeyInput(stack.peek()));
        return stack.peek();
    }
}