package com.gek.micros.backend.core.controller;

import com.gek.micros.data.model.project.User;
import com.gek.micros.backend.core.dto.PasswordDTO;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthApi {

    void refreshToken (HttpServletRequest request, HttpServletResponse response) throws IOException;

    ResponseEntity<?> changePassword (PasswordDTO dto);

    ResponseEntity<?> resetPassword (Long userId);

    User getMe();
}
