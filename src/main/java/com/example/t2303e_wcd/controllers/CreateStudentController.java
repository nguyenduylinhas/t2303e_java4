package com.example.t2303e_wcd.controllers;

import com.example.t2303e_wcd.dao.ClassDAO;
import com.example.t2303e_wcd.dao.StudentDAO;
import com.example.t2303e_wcd.dao.SubjectDAO;
import com.example.t2303e_wcd.entity.Classroom;
import com.example.t2303e_wcd.entity.Student;
import com.example.t2303e_wcd.entity.Subject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static sun.java2d.cmm.ColorTransform.In;

@WebServlet(value = "/create-student")
public class CreateStudentController extends HttpServlet {
    private StudentDAO _studentDAO;
    private ClassDAO _classDAO;
    private SubjectDAO _subjectDAO;

    @Override
    public void init() throws ServletException {
        _studentDAO = new StudentDAO();
        _classDAO = new ClassDAO();
        _subjectDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Classroom> classes = _classDAO.all();
        req.setAttribute("classes",classes);
        List<Subject> subjects = _subjectDAO.all();
        req.setAttribute("subjects",subjects);

        RequestDispatcher dispatcher = req.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student(
                null,
                req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("address"),
                req.getParameter("telephone"),
                Integer.getInteger(req.getParameter("class_id")),
                req.getParameter("subject")
        );
        if(_studentDAO.create(s)){
            resp.sendRedirect("student");
            return;
        }
        resp.sendRedirect("create-student");
    }
}
