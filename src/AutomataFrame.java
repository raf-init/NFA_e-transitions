import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;


public class AutomataFrame extends JFrame {
	
	public static void main(String[] args) throws IOException{
		
		ArrayList<Character> last_states_array = new ArrayList<Character>();
		ArrayList<List<Character>> transitions_array = new ArrayList<List<Character>>();
		
		int flag=0;
		
		Character first_state = null;		
		
		//If the .txt file named Automaton is present in the program's dir
		//then open it
		Scanner s = null;
	    try{
	    	s = new Scanner(new BufferedReader(new FileReader("Automaton.txt")));
	    	while (s.hasNextLine()){
	  
	        String str = s.nextLine();
	        ArrayList<Character> list = new ArrayList<Character>();
	        
	        //Initialize first state, last states and all the given transitions
	        	for(char c : str.toCharArray()) 
	        	{	
	        		if(flag==1)
	        		{
	        			first_state = c;
	        		}
	        		
	        		if(flag==3)
	        		{
	        			last_states_array.add(c);
	        		}
	        	
	        		if(flag>4)
	        		{
	        			list.add(c);
	        		}
	        	}
	        	if(flag>=5)
	        		transitions_array.add(list);
	        	flag++;
	    	}
	    } finally {
            if (s != null) {
                s.close();
            }

	    }
	    
	    ArrayList<Character> next_states_array = new ArrayList<Character>();
	    ArrayList<Character> current_states_array = new ArrayList<Character>();
	    
	    int j = 0;
	    int loop;
	    
	    //Exit loop by closing the UI
	    while(true)
	    {
	    	j=0;
	    	 	
	    	//The user types a word
	    	String string;
	    	string = JOptionPane.showInputDialog("Insert a word:");
	    	current_states_array.add(first_state);

	    	for(char c : string.toCharArray())
	    	{
	    		loop=0;
	    			
	    		//Get the current states, based on the previous saved next states
	    		//if possible, else print Error
	    		for(List<Character> l : transitions_array)
	    		{
	    				j=0;
	    				while(j<current_states_array.size())
	    				{
	    						if(current_states_array.get(j).equals(l.get(0)))
	    						{
	    							if(c==l.get(2))
	    							{
	    								next_states_array.add(l.get(4));
	    								loop=1;
	    							}	
	    						}
	    					j++;
	    				}
	    		}
	    		
	    		current_states_array.clear();
	    		current_states_array.addAll(next_states_array);
	    		next_states_array.clear();
	    				
	    		if(loop==0)
	    		{
	    				JOptionPane.showMessageDialog(null,  "Error" , "Results", JOptionPane.PLAIN_MESSAGE );
						loop=1;			
	    				break;
	    		}
	    	}
	    	
	    	int counter=0;
	    	for(Character c1 : current_states_array)
	    	{
	    		for(Character c2 : last_states_array)
	    		{
	    			if(c1==c2)
	    				counter++;
	    		}
	    	}
	    	
	    	//Based on the counter determine the Automaton's last state
	    	if(current_states_array.size()!=0)	
	    	{
	    		if(counter==current_states_array.size() && counter!=0)
	    			JOptionPane.showMessageDialog(null,  "Final state" , "Results", JOptionPane.PLAIN_MESSAGE );
	    		if(counter<current_states_array.size() && counter!=0)
	    			JOptionPane.showMessageDialog(null,  "Final or non-final state" , "Results", JOptionPane.PLAIN_MESSAGE );
	    		if(counter==0)
	    			JOptionPane.showMessageDialog(null,  "Non-final state" , "Results", JOptionPane.PLAIN_MESSAGE );
	    	}
	    	current_states_array.clear();
	    }	
	}
}
