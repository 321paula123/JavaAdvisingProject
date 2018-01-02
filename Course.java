/**
 * Class Course is a course object with a title, list of prerequisites, a course number, and satisfies a specific degree requirement category.
 *
 * @author Paula Young
 */
public class Course implements Comparable
{
    // instance variables - replace the example below with your own
    private String courseTitle;
    private int credits;
    private String[][] prereqAlternatives;
    private String requirementType;
    private int courseNumber;

    /**
     * Constructor for objects of class Course
     */
    public Course(String title, int credits, String[][] prereqAlternatives, String category, int courseNumber)
    {
        // initialize instance variables
        courseTitle = title;
        this.credits = credits;
        this.prereqAlternatives = prereqAlternatives;
        this.requirementType = category;
        this.courseNumber = courseNumber;
    }
    
    public String[][] getPrerequisites() {
        return this.prereqAlternatives;
    }
    
    public int getCredits() {
        return this.credits;
    }
    
    public String getRequirement() {
        return this.requirementType;
    }
    
    public int getCourseNumber() {
    	return this.courseNumber;
    }
    
    public String getTitle() {
        return this.courseTitle;
    }
    
    // Courses with the same name/title are considered the same.
    public Boolean equals(Course c) {
        
        if (this.courseTitle.equals(c.courseTitle)) {
            return true;
        }
        else {
            return false;
        }
    }
    // This checks if the title of the course, provided in String format, matches the title of the course object.
    public Boolean matches(String name) {
        if (this.courseTitle.equals(name)) {
            return true;
        }
        else {return false;}
    }
    // This is used to sort the courses based on their course number. They are sorted in ascending order.
    public int compareTo(Object o) {
    	
    	if (o instanceof Course) {
    		if (this.equals(o)) {return 0;}
        	
        	else {
        		return (this.getCourseNumber() - ((Course) o).getCourseNumber());
        	}
    	}
    	
    	return -99;
    }
}
