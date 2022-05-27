package prereqchecker;
import java.util.*;

public class NewClass {
	private HashMap<String, ArrayList<String>> coursesAndPreReqs;
	private HashMap<String, Boolean> marked;
    HashSet<String> directAndIndirectPrerequisites;
    HashSet<String> allPrereqs;
    HashSet<String> needtoTake;

	// constructor
	public NewClass() {
		coursesAndPreReqs = new HashMap<String, ArrayList<String>>();
		marked = new HashMap<String, Boolean>();
	}
	
	// method to add courses
    public void add(String course){
        coursesAndPreReqs.put(course, new ArrayList<String>());
        marked.put(course, false);
    }

    public HashMap<String, ArrayList<String>> returnCoursesAndPreReqs(){
        return coursesAndPreReqs;
    }

	// method to update / add to a course's prereqs   
  // given a courseID and a prerequisite
  public void update(String course, String prereqs){
    coursesAndPreReqs.get(course).add(prereqs);
}

public HashSet<String> getDirectAndIndirectPrerequisites(String courseID){
    directAndIndirectPrerequisites = new HashSet<String>();
    for(int i = 0; i<coursesAndPreReqs.get(courseID).size(); i++){
        directAndIndirectPrerequisites.add(coursesAndPreReqs.get(courseID).get(i));
        DFS(coursesAndPreReqs.get(courseID).get(i), directAndIndirectPrerequisites);
    }
    return directAndIndirectPrerequisites;
}

public HashSet<String> getSet(){
    return directAndIndirectPrerequisites;
}

public HashSet<String> getAllPrereqs(ArrayList<String> takenCourses){
    allPrereqs = new HashSet<String>();
    for(int i = 0; i<takenCourses.size(); i++){
        marked.replace(takenCourses.get(i), true);
        allPrereqs.add(takenCourses.get(i));
        for(int m = 0; m<coursesAndPreReqs.get(takenCourses.get(i)).size(); m++){
            allPrereqs.add(coursesAndPreReqs.get(takenCourses.get(i)).get(m));
            DFS(coursesAndPreReqs.get(takenCourses.get(i)).get(m), allPrereqs);
        }
    }
    return allPrereqs;
}

public HashSet<String> needtake(String CourseID, ArrayList<String> takenCourses){
    HashSet<String> takenCourseAndPreReq = getAllPrereqs(takenCourses);
    HashSet<String> targetPreReqs = getDirectAndIndirectPrerequisites(CourseID);
    targetPreReqs.removeAll(takenCourseAndPreReq);
    return targetPreReqs;
}

public void DFS(String courseID, HashSet<String> set){
    marked.replace(courseID, true);
    set.add(courseID);
    for(int i = 0; i<coursesAndPreReqs.get(courseID).size(); i++){
        if(marked.get(coursesAndPreReqs.get(courseID).get(i)) == false){
            DFS(coursesAndPreReqs.get(courseID).get(i), set);
        }
    }
}

public  boolean canTakeCourse(String courseID, HashSet<String> takenCourses){
    for(int i = 0; i<coursesAndPreReqs.get(courseID).size(); i++){
        if(!takenCourses.contains(coursesAndPreReqs.get(courseID).get(i))){
            return false;
        }
    }
    return true;
}

public HashMap<Integer, HashSet<String>> planSchedule(String target, ArrayList<String> takenCourses){
    HashSet<String> needtoTake = needtake(target, takenCourses);
    HashMap<Integer, HashSet<String>> plan = new HashMap<Integer, HashSet<String>>();
    int semCount = 1;
    HashSet<String> prereqs;
    HashSet<String> semsesterCourses = new HashSet<String>();
    while(!needtoTake.isEmpty()){
        for(String i: needtoTake){
            prereqs=needtake(i, takenCourses);
            if(prereqs.isEmpty()){
                semsesterCourses.add(i);
            }
        }
        if(!semsesterCourses.isEmpty()){
            HashSet<String> addCourses = new HashSet<String>();
            for(String i: semsesterCourses){
                addCourses.add(i);
            }
            plan.put(semCount, addCourses);
            semCount++;
            needtoTake.removeAll(addCourses);
            takenCourses.addAll(addCourses);
            semsesterCourses.clear();
        }
    }
    return plan;
}

    public  String toString(){
        String listRepresentation = "";
        for(String courseId: coursesAndPreReqs.keySet()){
            listRepresentation += courseId;
            for(int i = 0; i<coursesAndPreReqs.get(courseId).size(); i++){
                listRepresentation += " " + coursesAndPreReqs.get(courseId).get(i);
            }
            listRepresentation += "\n";
        }
        return listRepresentation;
    }
}
