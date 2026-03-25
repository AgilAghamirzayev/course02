package l05.arrays.strings.inclass.inclass;

public class Student3DExample {

    public static void main(String[] args) {

        int noOfStudents = 2;
        int subjects = 4;
        int totalSemesters = 5;
        String[] subjectNames = {"Mathematics", "Physics", "Chemistry", "Computer Science"};

        // Student 1 data
        int[][] student1 = {
                {88, 76, 90, 82, 98},   // Mathematics
                {82, 96, 92, 72, 99},   // Physics
                {86, 66, 94, 93, 100},  // Chemistry
                {85, 86, 97, 92, 97}    // Computer Science
        };

        // Student 2 data
        int[][] student2 = {
                {78, 85, 70, 72, 88},
                {62, 92, 82, 91, 91},
                {76, 72, 93, 87, 82},
                {55, 83, 87, 71, 100}
        };

        // 3D array: students × subjects × semesters
        int[][][] studentArray = new int[noOfStudents][subjects][totalSemesters];

        // Store data
        studentArray[0] = student1;
        studentArray[1] = student2;

        printAllData(studentArray, subjectNames);

        System.out.println();
        printAveragePerStudent(studentArray);

        System.out.println();
        findBestSubject(studentArray, subjectNames);
    }

    public static void printAllData(int[][][] data, String[] subjectNames) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Student " + (i + 1) + ":");

            for (int j = 0; j < data[i].length; j++) {
                String subject = j < subjectNames.length ? subjectNames[j] : "Subject " + j;
                System.out.print("  " + subject + ": ");

                for (int k = 0; k < data[i][j].length; k++) {
                    System.out.print(data[i][j][k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printAveragePerStudent(int[][][] data) {

        for (int i = 0; i < data.length; i++) {

            int sum = 0;
            int count = 0;

            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length; k++) {
                    sum += data[i][j][k];
                    count++;
                }
            }

            double avg = (double) sum / count;
            System.out.println("Student " + (i + 1) + " average: " + avg);
        }
    }

    public static void findBestSubject(int[][][] data, String[] subjectNames) {

        for (int i = 0; i < data.length; i++) {

            int bestSubject = -1;
            double bestAvg = 0;

            for (int j = 0; j < data[i].length; j++) {

                int sum = 0;

                for (int k = 0; k < data[i][j].length; k++) {
                    sum += data[i][j][k];
                }

                double avg = (double) sum / data[i][j].length;

                if (avg > bestAvg) {
                    bestAvg = avg;
                    bestSubject = j;
                }
            }

            String subject = bestSubject >= 0 && bestSubject < subjectNames.length
                    ? subjectNames[bestSubject]
                    : "Subject " + bestSubject;
            System.out.println("Student " + (i + 1) + " best subject: " + subject);
        }
    }

}
