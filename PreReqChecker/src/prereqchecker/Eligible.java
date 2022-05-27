package prereqchecker;

import java.util.*;

/**
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */

public class Eligible {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
            return;
        }
        StdIn.setFile(args[0]);
        int numcourses = StdIn.readInt();
        NewClass x = new NewClass();
        for(int i = 0; i<numcourses; i++){
            x.add(StdIn.readString());
        }
        int numprereqs = StdIn.readInt();
        for(int i = 0; i<numprereqs; i++){
            x.update(StdIn.readString(), StdIn.readString());
        }
        StdIn.setFile(args[1]);
        int takenNum = StdIn.readInt();
        ArrayList<String> takenCourses = new ArrayList<String>();
        for(int i=0; i<takenNum; i++){
            takenCourses.add(StdIn.readString());
        }
        StdOut.setFile(args[2]);
        HashSet<String> allprereq = x.getAllPrereqs(takenCourses);
        
        for(String y: x.returnCoursesAndPreReqs().keySet()){
            if(!allprereq.contains(y)){
                if(x.canTakeCourse(y,allprereq)){
                    StdOut.println(y);
                }
            }
        }	
       
    }
    
}
