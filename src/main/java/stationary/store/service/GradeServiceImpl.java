package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.GradeDAO;
import stationary.store.model.Grade;

import java.util.List;


@Service
public class GradeServiceImpl implements GradeService {

    // need to inject Grade dao
    @Autowired
    private GradeDAO gradeDAO;

    @Override
    @Transactional
    public List<Grade> getGrades() {
        return gradeDAO.getGrades();
    }

    @Override
    @Transactional
    public void saveGrade(Grade theGrade) {

        gradeDAO.saveGrade(theGrade);
    }

    @Override
    @Transactional
    public Grade getGrade(int theId) {

        return gradeDAO.getGrade(theId);
    }

    @Override
    @Transactional
    public void deleteGrade(int theId) {

        gradeDAO.deleteGrade(theId);
    }
}





