# PreReqChecker
College class scheduling can be very tough. The courses and their respective pre requisites can seem like an endless maze. This program is designed to simplify this process and make this process much easier. Some features include giving elible courses one can take, required courses one needs to take, and even schedule planning. 

#### Data Structures Implemented: Directed Graphs, DFS, HashSets, and Linked Lists!


## **Course Structure Input File**
The input file passes in the course structure for the respective university

Course Structure Input File Format:
1. a (int): number of courses in the graph
2. a lines, each with 1 course ID
3. b (int): number of edges in the graph
4. b lines, each with a course ID preceeded by a preReq to it
5. Pass in input file through command line as args[0]

FOR EXAMPLE: Look at adjlist.in file!


## **ValidPreReq.java**
Outputs YES or NO depending on whether a particular course is a valid Pre-Requisite to another course

Input Format: Pass 3 inputs into args
1. Course Structure Input File (formatted as above)
2. PreReq Input File
    1. 1 line containing the proposed advanced course
    2. 1 line containing the proposed prereq to the advanced course
    3. SAMPLE: validprereq.in
3. Desired Output File
                   
## **Eligible.java**
Outputs list of elibile courses to take

Input Format: Pass 3 inputs into args
1. Course Structure File (formatted as above)
2. Courses Taken File
   1. x(int): Number of courses
   2. x lines, each with 1 course ID
   3. SAMPLE: eligible.in
3. Desired Output File

 ## **NeedToTake.java**
 Outputs list of courses needed to take to be eligible to take target course
 
 Input Format: Pass 3 inputs into args
 1. Course Structure File (formatted as above)
 2. Target Input File
    1. One line, containing a target course ID
    2. c (int): Number of courses taken
    3. c lines, each with one course ID taken
    4. SAMPLE: needtotake.in
 3. Desired Output File
   
 ## **SchedulePlan.java**
 Plans out schedule and respective semesters to be eligible to take target course in LEAST amount of time possible
 
 Input Format: Pass 3 inputs into args
 1. Course Structure File (formatted as above)
 2. Target Input File
    1. One line, containing a target course ID
    2. c (int): Number of courses taken
    3. c lines, each with one course ID taken
    4. SAMPLE: scheduleplan.in
 4. Desired Output File
 
 
 

