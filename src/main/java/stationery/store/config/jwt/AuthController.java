package stationery.store.config.jwt;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stationery.store.bundle.user.User;
import stationery.store.bundle.user.UserDAO;
import stationery.store.config.security.MyUserDetailsService;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    private TokenUtil tokenUtil;

    private MyUserDetailsService userService;

    private UserDAO userDAO;

    private AuthenticationManager authenticationManager;

    public AuthController(TokenUtil tokenUtil, MyUserDetailsService userService, UserDAO userDAO, AuthenticationManager authenticationManager) {
        this.tokenUtil = tokenUtil;
        this.userService = userService;
        this.userDAO = userDAO;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = {"", "/"})
    public String signIn(@RequestBody SignInRequest signInRequest) {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) userService.loadUserByUsername(signInRequest.getUsername());
        String token = tokenUtil.generateToken(user);
        return token;
    }
}
