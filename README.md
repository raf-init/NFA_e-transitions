# NFA_e-transitions

This project is about NFA (non deterministic finite automaton) with and without e transitions.

The following steps explain the algorithm's function:

The input file contains all the details for the creation of the automaton in a specified form. 
- The algorithm saves the initial state, the final states and the possible transitions. 
- Then it initializes the arrays of the current and future states.
- The user can enter an input symbol or a sequence of symbols. Pressing "Enter" completes the process.
- A message then is printed, showing if the automaton has ended in an accepting state or not.
- Later, the user can enter again a new symbol or a sequence of symbols.
- The user can shut down the program by selecting "Cancel" from the UI or by closing the window. 

Important note #1:

- Space was used to represent the absence of a symbol.
- For a wrong transition, the message "Error" is shown.
- The first state is symbolized (in the input file) as 1 not 0.
