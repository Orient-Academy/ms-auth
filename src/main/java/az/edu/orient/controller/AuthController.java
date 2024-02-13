package az.edu.orient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.edu.orient.model.AuthRequest;
import az.edu.orient.model.AuthResponse;
import az.edu.orient.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping
  public AuthResponse auth(@RequestBody AuthRequest request) {
      return authService.authResponse(request);
  }

}
