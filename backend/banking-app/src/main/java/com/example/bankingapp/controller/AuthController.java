// package com.example.bankingapp.controller;

// import com.example.bankingapp.model.User;
// import com.example.bankingapp.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
//         String username = loginRequest.get("username");
//         String password = loginRequest.get("password");

//         User user = userService.authenticate(username, password);
//         if (user != null) {
//             return ResponseEntity.ok("Login successful");
//         } else {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//         }
//     }
// }


package com.example.bankingapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(Authentication authentication) {
        // Spring Security handles the authentication before this method is called
        // If we reach here, authentication was successful
        // authentication.getName() will give you the authenticated username
        return ResponseEntity.ok("Login successful");
    }
}