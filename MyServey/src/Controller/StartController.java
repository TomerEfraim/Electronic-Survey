/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import Model.*;
import Viewer.*;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Tomer Efraim
 */
public class StartController {

    public StartFrame sFrame;
    AccessDBHandler adb;
    Survey survey;
    HashMap<String, Integer> partyToPID;

    private ActionListener partyListListener;
    private ActionListener startButtonListener;
    private ActionListener simulateButtonListener;

    public StartController(String URL, String title, String description, StartFrame sf) {
		sFrame = sf;
        adb = new AccessDBHandler(URL);
		survey = new Survey(title, description, readQuestions());
        partyToPID = readParties();
        sFrame.surveyDescription.setText(survey.getDescription());
        sFrame.surveyDescription.setEditable(false);
        survey.setPid(1);
    }
    
    private Vector<Question> readQuestions() {
        ResultSet requirements = adb.executeQuery("SELECT * FROM Requirements");
		Vector<Question> questions = new Vector<>();
        questions.add(new Question(0, ""));
		try {
				while (requirements.next()) {
			questions.add(new Question(requirements.getInt(2), requirements.getString(3)));		
				}
		} catch (SQLException e) {
				e.printStackTrace();
		}
        return questions;
    }
    
    private HashMap<String, Integer> readParties() {
        ResultSet result = adb.executeQuery("SELECT * FROM Parties");
		HashMap<String, Integer> parties = new HashMap<>();
			try {
				while (result.next()) {
			parties.put(result.getString(3), result.getInt(2));		
				}
		} catch (SQLException e) {
				e.printStackTrace();
		}
        return parties;
    }

    public void controll() {

        partyListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                partyListActionPerformed();
            }
        };

        startButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed();
            }
        };

        simulateButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulateButtonActionPerformed();
            }
        };

        sFrame.startButton.addActionListener(startButtonListener);
        sFrame.simulateButton.addActionListener(simulateButtonListener);
        sFrame.partyList.addActionListener(partyListListener);
    }

    private void startButtonActionPerformed() {
        System.out.println("inside start");
        if (survey.getPid() != -1) {
            sFrame.setVisible(false);
            QuestionFrame qFrame = new QuestionFrame();
            qFrame.setVisible(true);
            QuestionManualController controller = new QuestionManualController(survey, adb, qFrame);
            controller.controll();
        }
    }

    private void simulateButtonActionPerformed() {
        System.out.println("inside sim");
        if (survey.getPid() != -1) {
            sFrame.setVisible(false);
            QuestionSimulatorController simulator = new QuestionSimulatorController(survey, adb);
            simulator.controll();
        }
    }

    private void partyListActionPerformed() {
        String partyName = (String)sFrame.partyList.getSelectedItem();
        System.out.println("party name = " + partyName);
        
        int pid  = partyToPID.get(partyName);
        System.out.println("pid = " + pid);
        
        survey.setPid(pid);
    }

}
