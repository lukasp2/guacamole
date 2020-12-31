package base;

import base.states.State;

import java.util.Stack;

public class StateMachine {
    private Stack<State> stack = new Stack<State>();
    public Window window;
    public Boolean running = false;

    public StateMachine(Window window) {
        this.window = window;
    }

    // gets current state
    public State peek() {
        return stack.peek();
    }

    // adds one or more states to the stack
    public void push(State... states) {
        inactivateHeadState();

        // add the new states to the stack
        for (State state : states) {
            state.sm = this;
            stack.push(state);
        }

        activateHeadState();
    }

    // pops n states and returns new head
    public State pop(int numStates) { 
        inactivateHeadState();

        for (int i = 0; i < numStates; ++i) {
            stack.pop();
        }

        activateHeadState();

        return stack.peek();
    }

    // removes frame and keylistners from the currently active State (the head) on the stack.
    private void inactivateHeadState() {
        if (stack.size() > 0) {
            window.frame.remove(stack.peek());
            while (stack.lastElement().getKeyListeners().length > 0) { 
                stack.lastElement().removeKeyListener(stack.lastElement().getKeyListeners()[0]);
            }
        }    
    }

    // sets frame and keylistners on the currently active State (the head) on the stack.
    private void activateHeadState() {
        stack.peek().addKeyListener(new KeyListener(stack.peek()));
        window.frame.add(stack.peek());
        window.frame.setVisible(true);
    }
}