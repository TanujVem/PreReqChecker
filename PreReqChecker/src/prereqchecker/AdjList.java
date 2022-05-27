package prereqchecker;

import java.util.HashMap;

public class AdjList {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }

        int numcourses = StdIn.readInt();
        NewClass x = new NewClass();
        for(int i = 0; i<numcourses; i++){
            x.add(StdIn.readString());
        }
        int numprereqs = StdIn.readInt();
        for(int i = 0; i<numprereqs; i++){
            x.update(StdIn.readString(), StdIn.readString());
        }

        StdOut.print(x.toString());
	
    }
}
