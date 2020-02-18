package stationary.store.dao.daos;

import stationary.store.model.Grade;

import java.util.List;

public interface GradeDAO {

    List<Grade> getGrades();

    void saveGrade(Grade Grade);

    Grade getGrade(int id);

    void deleteGrade(int id);

}
