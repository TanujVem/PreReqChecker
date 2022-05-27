package prereqchecker;

import java.util.*;

/**
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
 * SchedulePlanInputFile name is passed through the command line as args[1]
 * Read from SchedulePlanInputFile with the format:
 * 1. One line containing a course ID
 * 2. c (int): number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * SchedulePlanOutputFile name is passed through the command line as args[2]
 * Output to SchedulePlanOutputFile with the format:
 * 1. One line containing an int c, the number of semesters required to take the course
 * 2. c lines, each with space separated course ID's
 */
public class SchedulePlan {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.SchedulePlan <adjacency list INput file> <schedule plan INput file> <schedule plan OUTput file>");
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
        String targetCourse = StdIn.readString();
        int numTaken = StdIn.readInt();
        ArrayList<String> takenCourses = new ArrayList<String>();
        for(int i=0; i<numTaken; i++){
            takenCourses.add(StdIn.readString());
        }
        StdOut.setFile(args[2]);
        HashMap<Integer, HashSet<String>> plan = x.planSchedule(targetCourse, takenCourses);
        int semSize = plan.size();
        StdOut.println(semSize);
        for(int i: plan.keySet()){
            for(String m: plan.get(i)){
                StdOut.print(m + " ");
            }
            StdOut.println();
        }


	// WRITE YOUR CODE HERE

    }
}
