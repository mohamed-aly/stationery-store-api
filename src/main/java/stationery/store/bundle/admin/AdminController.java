package stationery.store.bundle.admin;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/save")
    Admin newAdmin(@RequestBody Admin admin) {
        return adminService.addNewAdmin(admin);
    }

}
	

	

















