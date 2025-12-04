/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CourseDAO;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;

/**
 *
 * @author quan
 */
public class CourseServices {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private CourseDAO cDao = new CourseDAO();

    public Course createCourse(Course c, int uid) {
        try {
            boolean ok = cDao.isValid(c);
            if (ok) {
                return cDao.createCourse(c, uid);
            }

            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public Course getCourseById(int id) {
        try {
            return cDao.getCourseById(id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public boolean deleteCourse(int id) {
        try {
            return cDao.deleteCourse(id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return false;
        }
    }

    public List<Course> getListCourse(int limit, int offset, String title, String description, int categoryId,
            String status, Date start, Date end) {
        try {
            return cDao.getCourses(limit, offset, title, description, categoryId, status, start, end);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }
}
