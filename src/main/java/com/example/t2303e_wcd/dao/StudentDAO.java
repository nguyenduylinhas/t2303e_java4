package com.example.t2303e_wcd.dao;

import com.example.t2303e_wcd.database.Database;
import com.example.t2303e_wcd.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class  StudentDAO implements DAOInterface<Student>{
    @Override
    public List<Student> all() {
        String sql = "SELECT * FROM students";
        ArrayList<Student> list = new ArrayList<>();
        try {
            Database db = Database.createInstance();
            ResultSet rs = db.getStatement().executeQuery(sql);
            while (rs.next()){
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("telephone"),
                        rs.getInt("class_id"),
                        rs.getString("subject")
                ));
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public boolean create(Student student) {
        String sql = "INSERT INTO students(name,email,address,telephone,class_id,subject) VALUES(?,?,?,?,?)";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPrepareStatement(sql);
            prst.setString(1,student.getName());
            prst.setString(2,student.getEmail());
            prst.setString(3,student.getAddress());
            prst.setString(4,student.getTelephone());
            prst.setInt(5,student.getClass_id());
            prst.setString(6,student.getSubject());
            prst.execute();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        String sql = "UPDATE student set name=?, email=?, address=?, telephone=?, subject=? WHERE id=?";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPrepareStatement(sql);
            prst.setString(1,student.getName());
            prst.setString(2,student.getEmail());
            prst.setString(3,student.getAddress());
            prst.setString(4,student.getTelephone());
            prst.setInt(5,student.getId());
            prst.setString(6,student.getSubject());
            prst.execute();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }

    @Override
    public <K> Student find(K id) {
        return null;
    }

}
