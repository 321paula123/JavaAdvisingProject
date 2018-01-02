import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) {
        
        // Create course object instances to represent courses that are a part of the Computational and Data Sciences
    	// degree program. This includes their title, list of prerequisites, requirement category, and number.
    	// Note: {{"CDS 130"}, {"CDS 101"}} means a student can take either CDS 130 or CDS 101 to meet the prerequisite requirement.
    	// Note: {{"CDS 130","CDS 101"}} would mean a student has to take both CDS 130 and CDS 101 to meet the prerequisite requirement.
        Course cds130 = new Course("CDS 130",3,new String[][]{{}},"core",130);
        Course cds151 = new Course("CDS 151",1,new String[][]{{}},"core",151);
        Course cds230 = new Course("CDS 230",3,new String[][]{{"CDS 130"}},"core",230);
        Course cds301 = new Course("CDS 301",3,new String[][]{{"CDS 101"},{"CDS 130"}},"core",301);
        Course cds302 = new Course("CDS 302",3,new String[][]{{"CDS 101"},{"CDS 130"}},"core",302);
        Course cds303 = new Course("CDS 303",3,new String[][]{{"CDS 101"},{"CDS 130"}},"core",303);
        
        Course cds201 = new Course("CDS 201",3,new String[][]{{}},"extended core",201);
        Course cds205 = new Course("CDS 205",3,new String[][]{{}},"extended core",205);
        Course cds251 = new Course("CDS 251",3,new String[][]{{"CDS 130"}},"extended core",251);
        Course cds292 = new Course("CDS 292",3,new String[][]{{}},"extended core",292);
        Course cds411 = new Course("CDS 411",3,new String[][]{{"MATH 446","CDS 2XX"},{"PHYS 262","CDS 2XX"},{"PHYS 245","CDS 2XX"}},"extended core",411);
        Course cds486 = new Course("CDS 486",3,new String[][]{{}},"extended core",486);
        Course csi500 = new Course("CSI 500",3,new String[][]{{"MATH 114","MATH 203","CDS 130"}}, "extended core", 500);
        
        Course math113 = new Course("MATH 113",3,new String[][]{{}},"math",113);
        Course math114 = new Course("MATH 114",3,new String[][]{{"MATH 113"}},"math",114);
        Course math125 = new Course("MATH 125",3,new String[][]{{}},"math",125);
        Course math203 = new Course("MATH 203",3,new String[][]{{"MATH 114"}},"math",203);
        Course math446 = new Course("MATH 446",3,new String[][]{{"MATH 203","CS 112"}},"math",446);
        
        Course stat250 = new Course("STAT 250",3,new String[][]{{}},"statistics",250);
        Course stat350 = new Course("STAT 350",3,new String[][]{{"STAT 250"},{"STAT 260"}},"statistics",350);
        Course stat344 = new Course("STAT 344",3,new String[][]{{"MATH 114"}},"statistics",344);
        Course stat346 = new Course("STAT 346",3,new String[][]{{"MATH 213"}},"statistics",346);
        
        Course cds2XX = new Course("CDS 2XX",0,new String[][]{{}},"elective",2);
        Course phys262 = new Course("PHYS 262",3,new String[][]{{"PHYS 260"}},"elective",262);
        Course phys245 = new Course("PHYS 245",3,new String[][]{{"PHYS 243"}},"elective",245);
        Course phys260 = new Course("PHYS 260",3,new String[][]{{}},"elective",260);
        Course stat260 = new Course("STAT 260",3,new String[][]{{}},"elective",260);
        Course math213 = new Course("MATH 213",3,new String[][]{{}},"elective",213);
        
        Course cs112 = new Course("CS 112",3,new String[][]{{}},"elective",112);
        Course math214 = new Course("MATH 214",3,new String[][]{{"MATH 213"}},"elective",214);
        Course cds410 = new Course("CDS 410",3,new String[][]{{"MATH 214","MATH 446"}},"elective",410);
        Course cds421 = new Course("CDS 421",3,new String[][]{{"MATH 446"}},"elective",421);
        Course cds461 = new Course("CDS 461",3,new String[][]{{"PHYS 160","CDS 251","MATH 214"},{"PHYS 243","CDS 251","MATH 214"}},"elective",461);
        Course phys160 = new Course("PHYS 160",3,new String[][]{{"MATH 114"}},"elective",160);
        Course phys243 = new Course("PHYS 243",3,new String[][]{{}},"elective",243);
        Course phys308 = new Course("PHYS 308",3,new String[][]{{"PHYS 262","MATH 214"}},"elective",308);
        Course cds487 = new Course("PHYS 487",3,new String[][]{{"PHYS 308"}},"elective",487);
        Course juniorSenior = new Course("Junior/Senior",3,new String[][]{{}},"elective",300);
        Course cds490 = new Course("CDS 490",3,new String[][]{{"Junior/Senior"}},"elective",490);
        Course cds491 = new Course("CDS 491",3,new String[][]{{"Junior/Senior"}},"elective",491);
        
        // Create sets of the course instances created above.
        // allCourses includes any course which meets a requirement for the Computational and Data Sciences program (not including electives).
        Set<Course> allCourses = new HashSet<Course>();  
        // electiveCourses is the set of courses which only count as electives, but may help students meet the prerequisite requirements for courses that satisfy degree requirements.
        Set<Course> electiveCourses = new HashSet<Course>();
        
        // Add courses to allCourses set.
        allCourses.add(cds130);
        allCourses.add(cds151);
        allCourses.add(cds230);
        allCourses.add(cds301);
        allCourses.add(cds302);
        allCourses.add(cds303);
        
        allCourses.add(cds201);
        allCourses.add(cds205);
        allCourses.add(cds251);
        allCourses.add(cds292);
        allCourses.add(cds411);
        allCourses.add(cds486);
        allCourses.add(csi500);
        
        allCourses.add(math113);
        allCourses.add(math114);
        allCourses.add(math125);
        allCourses.add(math203);
        allCourses.add(math446);
        
        allCourses.add(stat250);
        allCourses.add(stat350);
        allCourses.add(stat344);
        allCourses.add(stat346);
        
        // Add courses to the electiveCourses set.
        electiveCourses.add(math213);
        electiveCourses.add(cs112);
        electiveCourses.add(phys262);
        electiveCourses.add(phys245);
        electiveCourses.add(phys260);
        electiveCourses.add(math214);
        electiveCourses.add(cds410);
        electiveCourses.add(cds421);
        electiveCourses.add(phys260);
        electiveCourses.add(phys160);
        electiveCourses.add(phys243);
        electiveCourses.add(phys308);
        electiveCourses.add(cds487);
        electiveCourses.add(cds490);
        electiveCourses.add(cds491);
        
        // Create a set to store the courses that a particular student has already taken - this information is provided in a text document, PastCourses.txt.
        Set<Course> coursesTaken = new HashSet<Course>();
        
        // Create a map to go from String titles of courses to their corresponding course object.
        Map<String,Course> courseText2Object = new HashMap<String,Course>();
        // Load the pairs of titles and course objects. In retrospect, I could have used a for-loop and accessed the title field of each course object to build this map.
        courseText2Object.put("CDS 130",cds130);
        courseText2Object.put("CDS 151",cds151);
        courseText2Object.put("CDS 230",cds230);
        courseText2Object.put("CDS 301",cds301);
        courseText2Object.put("CDS 302",cds302);
        courseText2Object.put("CDS 303",cds303);
        
        courseText2Object.put("CDS 201",cds201);
        courseText2Object.put("CDS 205",cds205);
        courseText2Object.put("CDS 251",cds251);
        courseText2Object.put("CDS 292",cds292);
        courseText2Object.put("CDS 303",cds303);
        
        courseText2Object.put("CDS 486",cds486);
        
        courseText2Object.put("PHYS 262",phys262);
        courseText2Object.put("PHYS 245",phys245);
        courseText2Object.put("PHYS 260",phys260);
        courseText2Object.put("CDS 2XX",cds2XX);
        courseText2Object.put("STAT 260",stat260);
        courseText2Object.put("MATH 213",math213);
        courseText2Object.put("MATH 214",math214);
        courseText2Object.put("CS 112",cs112);
        courseText2Object.put("CDS 410",cds410);
        courseText2Object.put("CDS 421",cds421);
        courseText2Object.put("PHYS 243",phys243);
        courseText2Object.put("PHYS 160",phys160);
        courseText2Object.put("PHYS 308",phys308);
        courseText2Object.put("CDS 487",cds487);
        courseText2Object.put("Junior/Senior",juniorSenior);
        courseText2Object.put("CDS 490",cds490);
        courseText2Object.put("CDS 491",cds491);
        
        courseText2Object.put("MATH 113",math113);
        courseText2Object.put("MATH 114",math114);
        courseText2Object.put("MATH 125",math125);
        courseText2Object.put("MATH 203",math203);
        courseText2Object.put("MATH 446",math446);
        
        courseText2Object.put("STAT 250",stat250);
        courseText2Object.put("STAT 350",stat350);
        courseText2Object.put("STAT 344",stat344);
        courseText2Object.put("STAT 346",stat346);
        
        // Find out what the student has already taken by reading in the text document PastCourses.txt.
        
        // The source I used for writing try-catch-finally with regards to closing the scanner is:
        // https://stackoverflow.com/questions/4092914/java-try-catch-finally-best-practices-while-acquiring-closing-resources
        Scanner input = null;
        
        try {
        	// Open a scanner to read the text file.
        	input = new Scanner(new File("PastCourses.txt"));
            
        	// Iterate through each line of the text file.
            while (input.hasNextLine()) {
                
            	// Remove whitespace from the beginning and end of the line read-in (such as the new line character).
                String name = input.nextLine().trim();
                // Use the courseText2Object map to add the appropriate course to the coursesTaken set.
                coursesTaken.add(courseText2Object.get(name));
            }
        }
        
       catch (IOException e) {System.out.println("File IO Error in PastCourses.txt - make sure its in the right directory");}
       
        // The finally block will always run.
       finally {
    	   // Close the Scanner.
    	   if (input != null) {
    	   input.close();
    	   }
       }
        // Now we know what courses the student user has taken.
        
        // Check if the student has taken a 200 level or higher CDS course.
        Boolean cds200met = false;
        for (Course taken : coursesTaken) {
            if ((taken.getCourseNumber() >= 200) && (taken.getTitle().substring(0, 3).equals("CDS"))) {
            	cds200met = true;
            }
        }
        // To designate that a student has taken a 200 level CDS course, the fictitious course CDS 200met is added to
        // their coursesTaken set.
        if (cds200met) {
        	coursesTaken.add(cds2XX);	
        }
        
        // Determine which courses the student is eligible to take (and store these courses in a set). 
        // This only includes courses that meet degree requirements - not electives that help satisfy prerequisites for possible required courses.
        Set<Course> eligibleCourses = new HashSet<Course>();
        
        // Iterate through all possible courses that meet degree requirements (not including electives), and check to see if the student has satisfied the prerequisites.
        for (Course eachCourse : allCourses) {
            // Get the prerequisite requirements for each course.
            String[][] prereqs = eachCourse.getPrerequisites();
            // Assume the prerequisites are not satisfied initially.
            Boolean meetsAllPrereqs = false;
            
            // Access each of the "or" prerequisite arrays within the 2d prerequisite array. 
            for (String[] prereqList : prereqs) {
                
            	// Assume initially that the student has taken courses to meet one of the required prerequisite sub-arrays. 
            	Boolean option = true;
                
                for(String prereq : prereqList) {
                    // Look for the course in the list of courses taken previously.
                    Boolean courseFound = false;
                    for(Course c : coursesTaken) {
                        if (c.matches(prereq)) {
                            courseFound = true;
                        }
                    }
                    // If one of the courses is not found, that sub-array option of prerequisites is not an option.
                    if (courseFound == false) { option = false;}
                    
                }
                // If the student has taken a combination of prerequisite courses that meets the prerequisite requirement, they can take that class. 
                meetsAllPrereqs = meetsAllPrereqs || option;
                
            }
            // IF the student has met the prerequisite requirements, add the course to the set of eligible courses the student can take next.
            if (meetsAllPrereqs) {
                eligibleCourses.add(eachCourse);
            }
        }
        
        // Initialize the credit totals as 0 for each category of degree requirements.
        int coreCredits = 0;
        int extendedCoreCredits = 0;
        int mathCredits = 0;
        int statisticsCredits = 0;
        int electiveCredits = 0;
        int science_engineeringCredits = 0;
        int upperCredits = 0;
        
        // Remove courses that a student has already taken from the set of courses that they are eligible to take.
        for (Course taken : coursesTaken) {
            eligibleCourses.remove(taken);
        }
        
        // Using the set of courses the student has already taken...
        // Total the numbers of credits the student has achieved towards each degree requirement category.
        for (Course taken : coursesTaken) { 
        	
        	if (taken.getCourseNumber() >= 300) {
        		upperCredits += taken.getCredits();
        	}
            
            if (taken.getRequirement().equals("core")) {
               coreCredits += taken.getCredits();	
            }
            else if (taken.getRequirement().equals("extended core")) {
               extendedCoreCredits += taken.getCredits();	
            }
            else if (taken.getRequirement().equals("math")) {
                mathCredits += taken.getCredits();	
             }
            else if (taken.getRequirement().equals("statistics")) {
                statisticsCredits += taken.getCredits();	
             }
            else if (taken.getRequirement().equals("elective")) {
                electiveCredits += taken.getCredits();	
             }
            else if (taken.getRequirement().equals("science and engineering")) {
                science_engineeringCredits += taken.getCredits();	
             }
            else {System.out.println(taken.getTitle()+" credits were not added to credit totals");
            }
        }
        
        // Source: http://www.xyzws.com/javafaq/how-to-convert-a-hashset-to-an-arraylist/180
        // Source: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
        // Turn the set of eligible courses into an array-list.
        ArrayList<Course> orderedEligibleCourses = new ArrayList<Course>(eligibleCourses);
        
        // Source: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
        // Sort the eligible courses. The course class implements comparator (the compareTo() method is defined).
        Collections.sort(orderedEligibleCourses);
        
        // Print the title of each course the student is eligible to register for based on completion of prerequisites.
        System.out.println("Courses this student can register for, based on satisfied prerequisites:");
        for (Course c : orderedEligibleCourses) {
        	System.out.println(c.getTitle());
        }
        System.out.println();
        
        // Print the numbers of credits the student has completed towards each degree requirement.
        System.out.printf("%-43s %-10d \n" ,"Core Credits Completed: ", coreCredits);
        System.out.printf("%-43s %-10d \n", "Extended Core Credits Completed: " , extendedCoreCredits);
        System.out.printf("%-43s %-10d \n", "Math Credits Completed: ", mathCredits);
        System.out.printf("%-43s %-10d \n", "Statistics Credits Completed: ", statisticsCredits);
        System.out.printf("%-43s %-10d \n", "Elective Credits Completed: ", electiveCredits);
        System.out.printf("%-43s %-10d \n\n", "Science and Engineering Credits Completed: ", science_engineeringCredits);
        System.out.printf("%-43s %-10d \n", "Total Upper Level Credits: ", upperCredits);
    }
}
