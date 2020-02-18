package stationary.store.dao.gradeLevel;

import stationary.store.model.GradeLevel;

import java.util.List;

public interface GradeLevelDAO {

    List<GradeLevel> getGradeLevels();

    void saveGradeLevel(GradeLevel GradeLevel);

    GradeLevel getGradeLevel(int id);

    void deleteGradeLevel(int id);

}
