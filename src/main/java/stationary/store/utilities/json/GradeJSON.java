package stationary.store.utilities.json;

public class GradeJSON {
    private int gradeId;
    private int grade;

    public GradeJSON(int gradeId, int grade) {
        this.gradeId = gradeId;
        this.grade = grade;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
