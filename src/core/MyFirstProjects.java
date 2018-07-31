package core;

/**
 * Source program for final assignment
 * Written by Viktoryia Starynskaya
 */
public class MyFirstProjects {
    public static void main(String[] args) {
        double median;

        Student[] oddStudentsArray = {
                new Student("Clark", "Amy", 40),
                new Student("Dyer", "Anne", 13),
                new Student("Lambert", "Karen", 91),
                new Student("Lewis", "Luke", 47),
                new Student("Mackay", "Jacob", 229),
                new Student("Mills", "John", 96),
                new Student("Nash", "Justin", 4),
                new Student("Ross-Rutherford", "David", 6),
                new Student("Smith", "Duncan", 31),
                new Student("Walker", "Ellison", 72),
                new Student("B. White", "Viktar", 52),
                new Student("Young", "Fiona", 56),
                new Student("Reid", "Irene", 91),
                new Student("Duk", "Jan", 113),
                new Student("Freid", "Julia", 20),
        };

        Student[] evenStudentsArray = {
                new Student("Clark", "Amy", 40),
                new Student("Dyer", "Anne", 13),
                new Student("Lambert", "Karen", 91),
                new Student("Lewis", "Luke", 47),
                new Student("Mackay", "Jacob", 229),
                new Student("Mills", "John", 96),
                new Student("Nash", "Justin", 4),
                new Student("Ross-Rutherford", "David", 6),
                new Student("Smith", "Duncan", 31),
                new Student("Walker", "Ellison", 72),
                new Student("B. White", "Viktar", 52),
                new Student("Young", "Fiona", 56),
                new Student("Reid", "Irene", 91),
                new Student("Duk", "Jan", 113),
                new Student("Freid", "Julia", 20),
                new Student("Murray", "Olivia", 99)
        };

        Student[] singleStudentArray = {
                new Student("Clark", "Amy", 40),
        };

        Student[] noStudentsArray = {};


        // Displays the array before calling a sort method
        System.out.println("Before:");
        StudentArrayUtilities.toString(evenStudentsArray);

        // Sorts and displays the array using the default (initial) sort key
        System.out.println("Sorting by default------------------------------\n"
                + "After:");
        StudentArrayUtilities.arraySort(evenStudentsArray);
        StudentArrayUtilities.toString(evenStudentsArray);

        // Change the sort key to first name, sort and display
        System.out.println("Sorting by first name----------------------------\n"
                + "After:");
        Student.setSortKey(Student.SORT_BY_FIRST);
        StudentArrayUtilities.arraySort(evenStudentsArray);
        StudentArrayUtilities.toString(evenStudentsArray);

        //Change the sort key to total score, sort and display
        System.out.println("Sorting by total points---------------------------\n"
                + "After:");
        Student.setSortKey(Student.SORT_BY_POINTS);
        StudentArrayUtilities.arraySort(evenStudentsArray);
        StudentArrayUtilities.toString(evenStudentsArray);

        // setSortKey() to first name;
        // call the getMedianDestructive() method and display the median score;
        // call getSortKey() to make sure that the getMedianDestructive() method
        // preserved the right client's sortKey value;
        Student.setSortKey(Student.SORT_BY_FIRST);
        median = StudentArrayUtilities.getMedianDestructive(evenStudentsArray);
        System.out.println("Median of evenClass: " + median);

        if (Student.getSortKey() == Student.SORT_BY_FIRST) {
            System.out.println("Successfully preserved sort key");
        } else {
            System.out.println("Destroyed sort key");
        }

        median = StudentArrayUtilities.getMedianDestructive(oddStudentsArray);
        System.out.println("Median of oddClass " + median);
        median = StudentArrayUtilities.getMedianDestructive(singleStudentArray);
        System.out.println("Median of smallClass " + median);
        median = StudentArrayUtilities.getMedianDestructive(noStudentsArray);
        System.out.println("Median of noClass " + median);

    }
}
