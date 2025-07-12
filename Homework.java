
/*
 * COP 3330 Summer 2025
 * Student Name: Yevgeniy An
 * 
 * This file contains the three classes you need to complete.
 * Only add your code below the TODO comments.
 * Do not modify any other parts of this file.
 */

class Utility {
    
    // TODO: Complete the Utility class

    /**
     * Converts a StudentList into a 2D array for UI display.
     * Each row represents a student with: name, status, total credits, and tuition due.
     *
     * @param list The StudentList containing student data
     * @return 2D String array formatted for table display
     */
    public static String[][] studentListToArray(BaseList list) {
        int size = list.size();
        String[][] data = new String[size][4];

        for (int i = 0; i < size; i++) {
            Student s = (Student) list.get(i);
            data[i][0] = s.getName();
            data[i][1] = s.getStatus();
            data[i][2] = Integer.toString(s.getTotalCredit());
            data[i][3] = String.format("%.2f", s.getTuitionDue());
        }

        return data;
    }

    /**
     * Converts a CourseList into a 2D array for UI display.
     * Each row represents a course with: code, title, and credit hours.
     *
     * @param list The CourseList containing course data
     * @return 2D String array formatted for table display
     */
    public static String[][] courseListToArray(CourseList list) {
        int size = list.size();
        String[][] data = new String[size][3];

        for (int i = 0; i < size; i++) {
            Course c = (Course) list.get(i);
            data[i][0] = c.getCode();
            data[i][1] = c.getTitle();
            data[i][2] = Integer.toString(c.getCredit());
        }

        return data;
    }
    
}


class StudentList extends BaseList  {
    
    // TODO: Complete the StudentList class

    /**
     * Finds the first student matching the search key
     *
     * @param key Search query string
     * @return First matching Student or null if not found
     */
    @Override
    public Student findMatch(String key) {
        // Iterate through all students
        for (int i = 0; i < size; i++) {
            Student s = (Student) get(i);
            // Check if student matches search key
            if (s.isMatch(key)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Returns new StudentList containing students matching search key
     *
     * @param key Search query string
     * @return StudentList of matching students
     */
    @Override
    public StudentList query(String key) {
        StudentList result = new StudentList();
        // Iterate through all students
        for (int i = 0; i < size; i++) {
            Student s = (Student) get(i);
            // Add matching students to result list
            if (s.isMatch(key)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Checks if student exists in the list
     *
     * @param obj Student object to check
     * @return true if student exists, false otherwise
     */
    @Override
    public boolean contains(Object obj) {
        // Verify object is a Student
        if (!(obj instanceof Student)) {
            return false;
        }
        Student target = (Student) obj;
        // Iterate through all students
        for (int i = 0; i < size; i++) {
            Student s = (Student) get(i);
            // Check if students are equal
            if (s.isEqual(target)) {
                return true;
            }
        }
        return false;
    }
}


class CourseList extends BaseList {
    
    // TODO: Complete the CourseList class

    /**
     * Finds the first course matching the search key
     *
     * @param key Search query string
     * @return First matching Course or null if not found
     */
    @Override
    public Course findMatch(String key) {
        // Iterate through all courses
        for (int i = 0; i < size; i++) {
            Course c = (Course) get(i);
            // Check if course matches search key
            if (c.isMatch(key)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Returns new CourseList containing courses matching search key
     *
     * @param key Search query string
     * @return CourseList of matching courses
     */
    @Override
    public CourseList query(String key) {
        CourseList result = new CourseList();
        // Iterate through all courses
        for (int i = 0; i < size; i++) {
            Course c = (Course) get(i);
            // Add matching courses to result list
            if (c.isMatch(key)) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Checks if course exists in the list
     *
     * @param obj Course object to check
     * @return true if course exists, false otherwise
     */
    @Override
    public boolean contains(Object obj) {
        // Verify object is a Course
        if (!(obj instanceof Course)) {
            return false;
        }
        Course target = (Course) obj;
        // Iterate through all courses
        for (int i = 0; i < size; i++) {
            Course c = (Course) get(i);
            // Check if courses are equal
            if (c.isEqual(target)) {
                return true;
            }
        }
        return false;
    }
    
}
