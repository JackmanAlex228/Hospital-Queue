package PainQueue;

import java.util.Scanner;

/* - Programming problem 6 p. 696 says, you can use data structures other than
     a heap to implement a priority queue.*
   
   - Write and implement the Java class for the array-based implementation that
     figure 12-9a represents.
   
   - Also include a menu-driven driver that allows the use to completely test 
     your implementation for a priority queue of floating-point values
   
   - Place your priority queue class in its own appropriatly named file */

public class HospitalQueue 
{
    // Menu method. Calls: Scanner and Priority queue
    public static void Menu(Scanner keyboard, ArrPQueue pq) {
        
        // Identifiers for menu selection and value of queue element
        int selection;
        float value;
        
        //Display the menu
        System.out.println("\nWhat are you going to do?");
        System.out.println("1: Go to next pacient.");
        System.out.println("2: Call on a pacient.");
        System.out.println("3: View the current queue.");
        System.out.println("4: Quit. ");
        selection = keyboard.nextInt();
        System.out.println();

        // Menue case statements
        switch(selection) 
        {
            // Press 1 to insert a value
            case 1: 
            {
                System.out.println("'How much pain are you in?'");
                System.out.print("The pacient says ");
                value = keyboard.nextFloat();
                pq.pqInsert(value);
            }
            break;
            
            // Press 2 to delete a value
            case 2: 
            {
                pq.pqDelete();
            }
            break;
            
            // Press 3 to display the queue
            case 3: 
            {
                System.out.println("You look at your clipboard and check the pacients"
                    + "\nwho are waiting, as well as their pain levels. ");
                pq.displayPQueue();
            }
            break;
            
            // Press 4 to quit
            case 4: 
            {
                System.out.println("Terminating the program.");
                System.exit(0);
            }
        }

        // Input validation for menu selection
        while (selection <= 0 || selection > 4) 
        {
            System.out.print("ERROR: Please enter an integer that represents a menu item. ");
            selection = keyboard.nextInt();
        }
    }
    
    public static void main(String[] args) 
    {
        // Variable declorators
        String answer;
        Scanner keyboard = new Scanner(System.in);
        ArrPQueue pq = new ArrPQueue();
        
        // Create a priority queue
        pq.createPQueue();
        
        // Greeting
        System.out.println("This program will deomnstrate an array-based priority queue.");
        
        // Scenario
        System.out.println(
                "\nYou are a doctor in a small clinic. You ask each pacient what their pain level is" +
                " \non a scale of 1 to 10 and ask them to wait in the waiting room." +
                " \nTheir priority is based on their pain level." +
                " \nTheir pain levels may be decimal values and they may be exagerated.");
        
        // Menu driven loop and case statements
        // 1: Insert a value
        // 2: Delete a value
        // 3: Display the priority queue
        // 4: Quit
        
        // Try block for input mismatch exception
        try 
        {
            // Begin menu loop
            do 
            {
                // Interactive menu method
                Menu(keyboard, pq);
                
                // Prompt the user if they want to keep going
                System.out.print("\nWould you like to keep going? (y/n) ");
                answer = keyboard.next();

                // Input validation for "keep going" user prompt
                while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) 
                {
                    System.out.print("ERROR: Please enter 'y' for yes or 'n' for no. ");
                    answer = keyboard.next();
                }
            } 
            while (answer.equalsIgnoreCase("y"));
        }
        
        // In case the input does not match the declaration
        catch (java.util.InputMismatchException e) 
        {
            System.out.println("ERROR: Input mismatch exception. The program will now terminate.");
        }
    } 
}
