/*package com.johannad.appStel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Aquí deberías validar las credenciales contra tu servicio de usuarios o base de datos
            // Supongamos que tienes un servicio UserService para manejar usuarios
            User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

            if (user != null) {
                // Si el usuario es autenticado correctamente, genera un token JWT
                String token = jwtService.generateToken(user);

                // Devuelve el token en la respuesta
                return ResponseEntity.ok(new LoginResponse(token, user.getRole().getNombreRol()));
            } else {
                // Si las credenciales son inválidas, devuelve un error 401 Unauthorized
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar iniciar sesión");
        }
    }
}*/
