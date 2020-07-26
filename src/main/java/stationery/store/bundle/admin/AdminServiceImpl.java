package stationery.store.bundle.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationery.store.exceptions.EmailExistsException;


import java.util.Set;


@Slf4j
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminDAO adminDAO;

    private PasswordEncoder passwordEncoder;

    public AdminServiceImpl(AdminDAO adminDAO, PasswordEncoder passwordEncoder) {
        this.adminDAO = adminDAO;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public Admin addNewAdmin(Admin admin)  {

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminDAO.save(admin);
    }

    @Override
    public Set<Admin> findAll() {
        return null;
    }

    @Override
    public Admin findById(Long aLong) {
        return null;
    }

    @Override
    public Admin save(Admin object) {
        return null;
    }

    @Override
    public void delete(Admin object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}





