package poppop.oauth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import poppop.oauth.dto.UserDTO;
import poppop.oauth.service.UserService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final UserService userService;

    @GetMapping("/join")
    public String joinPage() {

        return "joinPage";
    }

    @PostMapping("/join")
    @ResponseBody
    public String join(@RequestBody UserDTO dto) {

        userService.join(dto);

        return "ok";
    }
}
