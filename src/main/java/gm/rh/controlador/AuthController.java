package gm.rh.controlador;

import gm.rh.modelo.LoginRequest;
import gm.rh.modelo.RegisterRequest;
import gm.rh.servicio.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) { // recibe JSON
        if (request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Faltan datos"));
        }
        String message = authService.registerUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(Collections.singletonMap("message", message));
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam String token) {
        return ResponseEntity.ok(authService.verifyUser(token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) { // recibe JSON
        if (request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Faltan datos"));
        }

        String token = authService.loginUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}

