/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import constant.httpStatus;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.User;

/**
 *
 * @author quan
 */
public class AuthUtils {

    public static void doAuthorize(HttpServletRequest req, HttpServletResponse resp, User u, int roleAccepted)
            throws ServletException, IOException {
        if (u.getRole_id() != roleAccepted) {
            resp.sendError(httpStatus.FORBIDDEN.getCode(), httpStatus.FORBIDDEN.getMessage());
            return;
        }
    }
}
