package com.example.abu.quizapp;

/**
 * Created by Abu on 9/17/2016.
 */
public class ReportCard {
    private int mathScore;
    private int englishScore;
    private int scienceScore;
    private String grade;
    public static final double NUMBER_OF_COURSES = 3.0;

    public ReportCard(int mathScore, int englishScore, int scienceScore) {
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.scienceScore = scienceScore;
        instantiateGrade();
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getScienceScore() {
        return scienceScore;
    }

    public void setScienceScore(int scienceScore) {
        this.scienceScore = scienceScore;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void instantiateGrade() {
        String grade;
        int sum = mathScore + englishScore + scienceScore;
        double percentage = sum / NUMBER_OF_COURSES;

        if (percentage >= 90.0) {
            grade = "A";
        } else if (percentage < 90.0 && percentage >= 80.0) {
            grade = "B";
        } else if (percentage < 80.0 && percentage >= 70.0) {
            grade = "C";
        } else if (percentage < 70.0 && percentage >= 60.0) {
            grade = "D";
        } else if (percentage < 60.0) {
            grade = "Fail";
        } else {
            grade = "error";
        }
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ReportCard Details" + '\n' +
                "The Grade of the following score is written below  " + '\n' +
                "Maths Score  " + mathScore + '\n' +
                "English Score  " + englishScore + '\n' +
                "Science Score  " + scienceScore + '\n' +
                "GRADE  " + grade;
    }

//    public static void main(String[] args) {
//        ReportCard reportCard = new ReportCard(100, 100, 80);
//        System.out.println(reportCard);
//    }
}
