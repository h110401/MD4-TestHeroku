package rikkei.academy.security8.api;

import org.springframework.web.bind.annotation.*;
import rikkei.academy.security8.dto.request.LoginDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthApi {
    @GetMapping("login")
    public String login(
//            @RequestBody
//            LoginDTO loginDTO
    ) {
        return "<h1>Logging in<h1>";
    }
}
