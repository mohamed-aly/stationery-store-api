package stationery.store.bundle.user;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;


@RestController
@Validated
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Map<UserType, List<User>> getUsers() {

        Set<User> users = userService.findAll();
        Map<UserType, List<User>> usersPerType = users.stream()
                .collect(groupingBy(User::getUserType));

        return usersPerType;
    }


}
	

	

















