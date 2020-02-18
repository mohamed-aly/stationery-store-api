package stationary.store.service;

import stationary.store.model.GradeLevel;

import java.util.List;


public interface GradeLevelService {

    List<GradeLevel> getGradeLevels();

    void saveGradeLevel(GradeLevel theGradeLevel);

    GradeLevel getGradeLevel(int theId);

    void deleteGradeLevel(int theId);

}
