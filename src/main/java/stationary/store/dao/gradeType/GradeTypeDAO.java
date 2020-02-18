package stationary.store.dao.gradeType;

import stationary.store.model.GradeLevel;

import java.util.List;

public interface GradeTypeDAO {

    List<GradeLevel> getGradeTypes();

    void saveGradeType(GradeLevel GradeType);

    GradeLevel getGradeType(int id);

    void deleteGradeType(int id);

}
