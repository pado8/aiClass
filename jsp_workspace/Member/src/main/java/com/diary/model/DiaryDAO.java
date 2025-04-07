package com.diary.model;

import java.sql.SQLException;
import com.diary.util.DBConnPool;

public class DiaryDAO extends DBConnPool {

    public DiaryDAO() {
        super();
    }
    
    public int insertDiary(DiaryVO diary) {
        int result = 0;
        String sql = "INSERT INTO diary(no, weather, title, content, wdate) " +
                     "VALUES(seq_diary.nextval, ?, ?, ?, sysdate)";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, diary.getWeather());
            psmt.setString(2, diary.getTitle());
            psmt.setString(3, diary.getContent());
            result = psmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println("일기 등록 중 예외 발생");
        }
        return result;
    }
}
