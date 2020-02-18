package stationary.store.service;

import stationary.store.model.Grade;

import java.util.List;


public interface GradeService {

    List<Grade> getGrades();

    void saveGrade(Grade theGrade);

    Grade getGrade(int theId);

    void deleteGrade(int theId);

}
