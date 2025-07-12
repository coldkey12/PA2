
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
     * Converts a BaseList containing Student objects into a 2D String array for tabular display.
     * Each row represents a student with four columns:
     *   [0] Student name
     *   [1] Student status (Undergraduate/Graduate)
     *   [2] Total credit hours enrolled
     *   [3] Total tuition due (formatted to two decimal places)
     *
     * @param list The BaseList containing Student objects to convert
     * @return 2D String array where each row represents a student's data
     */
    public static String[][] studentListToArray(BaseList list) {
        int size = list.size(); // This is how many students are in the list
        String[][] data = new String[size][4]; // Creates 2D array with appropriate dimensions: [students] x [4 attributes]

        // Each student in the list
        for (int i = 0; i < size; i++) {
            // Retrieve student at current index (cast from Object to Student)
            Student s = (Student) list.get(i);

            // Populate each column with student info
            data[i][0] = s.getName();                            // Student name
            data[i][1] = s.getStatus();                           // Student status
            data[i][2] = Integer.toString(s.getTotalCredit());     // Total credits as string
            data[i][3] = String.format("%.2f", s.getTuitionDue()); // Tuition formatted to two decimals
        }

        return data;
    }

    /**
     * Converts a CourseList into a 2D String array for tabular display.
     * Each row represents a course with three columns:
     *   [0] Course code (e.g., "COP3330")
     *   [1] Course title
     *   [2] Credit hours (as string)
     *
     * @param list The CourseList containing Course objects to convert
     * @return 2D String array where each row represents a course's data
     */
    public static String[][] courseListToArray(CourseList list) {
        int size = list.size();// Num of courses in the list
        String[][] data = new String[size][3]; // Creates 2D array with appropriate dimensions: [courses] x [3 attributes]

        // Each course in the list
        for (int i = 0; i < size; i++) {
            // Retrieve course at current index (cast from Object to Course)
            Course c = (Course) list.get(i);

            // Populate each column with relevant course information
            data[i][0] = c.getCode();                     // Course code
            data[i][1] = c.getTitle();                    // Course title
            data[i][2] = Integer.toString(c.getCredit());  // Credit hours as string
        }

        return data;
    }
}

class StudentList extends BaseList {

    // TODO: Complete the StudentList class

    /**
     * Searches for the first Student in the list that matches the given search key.
     * Matching is determined by the Student's isMatch() method which checks if
     * the key appears in the student's name (case-insensitive).
     *
     * @param key The search string to match against student names
     * @return The first matching Student object, or null if no match found
     */
    @Override
    public Student findMatch(String key) {
        for (int i = 0; i < size; i++) { // Iterate through all students in the list
            Student s = (Student) get(i); // Retrieve student at current index

            // Check if student matches search key using their isMatch implementation
            if (s.isMatch(key)) {
                return s;  // Return first matching student found
            }
        }
        return null;  // Return null if no matches found
    }

    /**
     * Creates a new StudentList containing all students that match the search key.
     * This method performs a case-insensitive search of student names.
     *
     * @param key The search string to match against student names
     * @return A new StudentList containing only matching students
     */
    @Override
    public StudentList query(String key) {
        StudentList result = new StudentList();// Create new StudentList to hold search results

        // Iterate through all students in current list
        for (int i = 0; i < size; i++) {
            Student s = (Student) get(i);

            // Add student to results if it matches search key
            if (s.isMatch(key)) {
                result.add(s);
            }
        }
        return result;  // Return populated result list
    }

    /**
     * Checks if the specified Student exists in the list.
     * Equality is determined by the Student's isEqual() method which compares
     * student names for exact match (case-sensitive).
     *
     * @param obj The Student object to check for existence in the list
     * @return true if identical student exists, false otherwise
     * @throws IllegalArgumentException if obj is not a Student
     */
    @Override
    public boolean contains(Object obj) {
        if (!(obj instanceof Student)) { // Verify input is a Student object
            return false;
        }

        Student target = (Student) obj; // Cast to Student type for proper comparison

        // Iterate through all students in list
        for (int i = 0; i < size; i++) {
            Student s = (Student) get(i);

            // Check for exact match using student's equality logic
            if (s.isEqual(target)) {
                return true;
            }
        }
        return false;  // No match found
    }
}

class CourseList extends BaseList {

    // TODO: Complete the CourseList class

    /**
     * Searches for the first Course in the list that matches the given search key.
     * Matching is determined by the Course's isMatch() method which checks if
     * the key appears in either the course code or title (case-insensitive).
     *
     * @param key The search string to match against course codes/titles
     * @return The first matching Course object, or null if no match found
     */
    @Override
    public Course findMatch(String key) {
        for (int i = 0; i < size; i++) { // Iterate through all courses in the list
            Course c = (Course) get(i);

            if (c.isMatch(key)) { // Check if course matches search key using its isMatch implementation
                return c;  // Return first matching course found
            }
        }
        return null;  // Return null if no matches found
    }

    /**
     * Creates a new CourseList containing all courses that match the search key.
     * This performs a case-insensitive search of course codes and titles.
     *
     * @param key The search string to match against course codes/titles
     * @return A new CourseList containing only matching courses
     */
    @Override
    public CourseList query(String key) {
        CourseList result = new CourseList(); // Create new CourseList to hold search results

        for (int i = 0; i < size; i++) { // Iterate through all courses in current list
            Course c = (Course) get(i);

            if (c.isMatch(key)) {
                result.add(c);// Add course to results if it matches search key
            }
        }
        return result;  // Return populated result list
    }

    /**
     * Checks if the specified Course exists in the list.
     * Equality is determined by the Course's isEqual() method which compares
     * course code, title, and credit hours for exact match (case-sensitive).
     *
     * @param obj The Course object to check for existence in the list
     * @return true if identical course exists, false otherwise
     * @throws IllegalArgumentException if obj is not a Course
     */
    @Override
    public boolean contains(Object obj) {
        if (!(obj instanceof Course)) { // Verify input is a Course object
            return false;
        }

        Course target = (Course) obj; // Cast to Course type for proper comparison

        for (int i = 0; i < size; i++) {// Iterate through all courses in list
            Course c = (Course) get(i);

            if (c.isEqual(target)) { // Check for exact match using course's equality logic
                return true;
            }
        }
        return false;  // No match found
    }
}
