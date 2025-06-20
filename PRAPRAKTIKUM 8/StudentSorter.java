import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class StudentSorter {
    public static class Student {
        String name;
        Map<String, Integer> courseGrades;

        public Student(String name) {
            // Please provide your solution in the space below
            this.name = name;
            this.courseGrades = new HashMap<>();
        }

        public void addCourseGrade(String course, int grade) {
            // Please provide your solution in the space below
            courseGrades.put(course, grade);
        }

        public double getGPA() {
           // Please provide your solution in the space below
            if(courseGrades.isEmpty()){
                return 0.0;
           }
           double total = 0.0;
           for(int grade : courseGrades.values()){
            total+=grade;
           } 
           return total/courseGrades.size();
        }

        public String getName() {
            return name;
            // Please provide your solution in the space below
        }
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            // Please provide your solution in the space below
            return Double.compare(s1.getGPA(), s2.getGPA());
        }
    }

    public static List<Student> sortStudentsByGPA(List<Student> students) {
        // Please provide your solution in the space below
        List<Student> copy = new ArrayList<>(students);
        Collections.sort(copy, new StudentComparator());
        return copy;
    }
}