package core;

class StudentArrayUtilities {
    public static void toString(Student[] data) {
        String output = "";

        for (int k = 0; k < data.length; k++) {
            output += " " + data[k].toString();
        }
        System.out.println(output);
    }

    private static boolean floatLargestToTop(Student[] data, int top) {
        boolean changed = false;
        Student temp;

        for (int k = 0; k < top; k++) {
            if (Student.compareTwoStudents(data[k], data[k + 1]) > 0) {
                temp = data[k];
                data[k] = data[k + 1];
                data[k + 1] = temp;
                changed = true;
            }
        }
        return changed;
    }


    public static void arraySort(Student[] array) {
        for (int k = 0; k < array.length; k++) {
            if (!floatLargestToTop(array, array.length - 1 - k)) {
                return;
            }
        }
    }

    // Computes and returns the median of the total scores of all the students
    // in the array
    public static double getMedianDestructive(Student[] array) {
        double average;
        int mid, clientSortKey;

        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0].getTotalPoints();
        }

        clientSortKey = Student.getSortKey();

        Student.setSortKey(Student.SORT_BY_POINTS);
        arraySort(array);

        Student.setSortKey(clientSortKey);

        mid = array.length / 2;

        if (array.length % 2 == 1) {
            return array[mid].getTotalPoints();
        }

        average = (array[mid].getTotalPoints() +
                array[mid + 1].getTotalPoints()) / 2;

        return average;
    }
}
