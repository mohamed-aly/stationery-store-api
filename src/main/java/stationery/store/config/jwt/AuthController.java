package stationery.store.config.jwt;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stationery.store.config.security.MyUserDetailsService;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    private TokenUtil tokenUtil;

    private JwtDao jwtDao;

    private MyUserDetailsService userService;

    private AuthenticationManager authenticationManager;

    public AuthController(TokenUtil tokenUtil, JwtDao jwtDao, MyUserDetailsService userService, AuthenticationManager authenticationManager) {
        this.tokenUtil = tokenUtil;
        this.jwtDao = jwtDao;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = {"","/"})
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
        String token = tokenUtil.generateToken(userDetails);
        JwtResponse response = new JwtResponse(token);
        return jwtDao.save(response);
    }
}
