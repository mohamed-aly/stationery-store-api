package stationary.store.service.gradeLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.gradeLevel.GradeLevelDAO;
import stationary.store.model.GradeLevel;

import java.util.List;


@Service
public class GradeLevelServiceImpl implements GradeLevelService {

    // need to inject GradeLevel dao
    @Autowired
    private GradeLevelDAO gradeLevelDAO;

    @Override
    @Transactional
    public List<GradeLevel> getGradeLevels() {
        return gradeLevelDAO.getGradeLevels();
    }

    @Override
    @Transactional
    public void saveGradeLevel(GradeLevel theGradeLevel) {

        gradeLevelDAO.saveGradeLevel(theGradeLevel);
    }

    @Override
    @Transactional
    public GradeLevel getGradeLevel(int theId) {

        return gradeLevelDAO.getGradeLevel(theId);
    }

    @Override
    @Transactional
    public void deleteGradeLevel(int theId) {

        gradeLevelDAO.deleteGradeLevel(theId);
    }
}





