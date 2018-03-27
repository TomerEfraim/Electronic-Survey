/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;

import Model.*;
import Viewer.*;
import java.util.List;

/**
 *
 * @author Tomer Efraim
 */
public class QuestionController {

    Survey survey;
    AccessDBHandler adb;
    int qid;

    public QuestionController(Survey s, AccessDBHandler db) {
        survey = s;
        adb = db;
        qid = s.getQuestion(1).getQid();
    }

    public void updateDB() {
        List<Question> questions = survey.getQuestions();
        int pid = survey.getPid();
        for (int i = 1; i < questions.size(); i++) {
            Question q = questions.get(i);
            int reqid = q.getQid();
            System.out.println("reqid" + reqid);
            double ans = (double) (((q.getResid() / (double) q.getAnswerSize()) - 0.5));

            String query = "INSERT INTO Answers (p_id, r_id, Answer) VALUES (" + pid + "," + reqid + "," + ans + ")";
            adb.execute(query);

            query = "SELECT AVG(Answer) FROM Answers WHERE Answers.p_id = " + pid + "  AND Answers.r_id =" + reqid;
            ResultSet avg = adb.executeQuery(query);
            double weight = 0;
            try {
                while (avg.next()) {
                    weight = avg.getDouble(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            query = "UPDATE Weights SET Weight = " + weight + " WHERE p_id =" + pid + " AND r_id=" + reqid;;
            adb.execute(query);
        }
        System.out.println("SUCCESSSSS");
    }

    public void controll() {

    }

    public void finish() {
        ResultFrame rFrame = new ResultFrame();
        //ResultFrame rFrame = new ResultFrame();
        rFrame.setVisible(true);
        ResultController rController = new ResultController(rFrame, adb);
        rController.controll();
    }

}
