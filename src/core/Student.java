package core;

class Student {
    // private data
    private String lastName;
    private String firstName;
    private int totalPoints;

    // defaults
    public static final String DEFAULT_NAME = "zz-error";
    public static final int DEFAULT_POINTS = 0;

    // static constants
    public static final int MAX_POINTS = 1000;
    public static final int SORT_BY_FIRST = 88;
    public static final int SORT_BY_LAST = 98;
    public static final int SORT_BY_POINTS = 108;

    private static int sortKey = SORT_BY_LAST;

    // a mutator for the member sortKey
    public static boolean setSortKey(int key) {
        if (key == SORT_BY_FIRST || key == SORT_BY_LAST || key == SORT_BY_POINTS) {
            sortKey = key;
            return true;
        }
        return false;
    }

    // an accessor for sortKey
    public static int getSortKey() {
        return sortKey;
    }

    // constructor requires parameters - no default supplied
    public Student(String last, String first, int points) {
        if (!setLastName(last)) {
            lastName = DEFAULT_NAME;
        }
        if (!setFirstName(first)) {
            firstName = DEFAULT_NAME;
        }
        if (!setPoints(points)) {
            totalPoints = DEFAULT_POINTS;
        }
    }

    String getLastName() {
        return lastName;
    }

    String getFirstName() {
        return firstName;
    }

    int getTotalPoints() {
        return totalPoints;
    }

    boolean setLastName(String last) {
        if (!validString(last))
            return false;
        lastName = last;
        return true;
    }

    boolean setFirstName(String first) {
        if (!validString(first))
            return false;
        firstName = first;
        return true;
    }

    boolean setPoints(int pts) {
        if (!validPoints(pts))
            return false;
        totalPoints = pts;
        return true;
    }

    static int compareTwoStudents(Student firstStud, Student secondStud) {
        int value;

        switch (sortKey) {
            case SORT_BY_LAST:
                value = firstStud.lastName.compareToIgnoreCase(secondStud.lastName);
                break;
            case SORT_BY_FIRST:
                value = firstStud.firstName.compareToIgnoreCase(secondStud.firstName);
                break;
            case SORT_BY_POINTS:
                value = firstStud.totalPoints - secondStud.totalPoints;
                break;
            default:
                value = 0;
        }
        return value;
    }

    public String toString() {
        String resultString;

        resultString = " " + lastName
                + ", " + firstName
                + " points: " + totalPoints
                + "\n";
        return resultString;
    }

    private static boolean validString(String testStr) {
        return testStr != null && Character.isLetter(testStr.charAt(0));
    }

    private static boolean validPoints(int testPoints) {
        return testPoints >= 0 && testPoints <= MAX_POINTS;
    }
}