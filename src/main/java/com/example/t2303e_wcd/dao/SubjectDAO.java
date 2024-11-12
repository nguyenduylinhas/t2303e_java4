package com.example.t2303e_wcd.dao;

import com.example.t2303e_wcd.database.Database;
import com.example.t2303e_wcd.entity.Classroom;
import com.example.t2303e_wcd.entity.Subject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements DAOInterface<Subject> {
    @Override

        public List<Subject> all() {
            String sql = "SELECT * FROM subjects";
            ArrayList<Subject> list = new ArrayList<>();
            try {
                Database db = Database.createInstance();
                ResultSet rs = db.getStatement().executeQuery(sql);
                while (rs.next()){
                    list.add(new Subject(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("hours")
                    ));
                }
            }catch (Exception e){

            }
            return list;
        }


    @Override
    public boolean create(Subject subject) {
        return false;
    }

    @Override
    public boolean update(Subject subject) {
        return false;
    }

    @Override
    public boolean delete(Subject subject) {
        return false;
    }

    @Override
    public <K> Subject find(K id) {
        return null;
    }
}
