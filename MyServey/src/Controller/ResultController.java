/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Viewer.*;
import Model.*;

/**
 *
 * @author Tomer Efraim
 */
public class ResultController {
    
    ResultFrame resultFrame;
    AccessDBHandler adb;
    int currentPID;
    int currentQID;
	
    private ActionListener partyListListener;
    private ActionListener requirementListListener;
    private ActionListener showButtonListener;
	
    public ResultController(ResultFrame rFrame, AccessDBHandler db) {
        resultFrame = rFrame;
        adb = db;
        currentPID = 1;
        currentQID = 1;
    }
    
    public void controll() {
		
        partyListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                partyListActionPerformed();
            }
        };

        requirementListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requirementListActionPerformed();
            }
        };

        showButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showButtonActionPerformed();
            }
        };
        
        	
        resultFrame.partyList.addActionListener(partyListListener);
	resultFrame.requirementList.addActionListener(requirementListListener);
	resultFrame.showButton.addActionListener(showButtonListener);
        
        
        resultFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                adb.close();
                System.exit(0);
            }
        });
    }

    private void partyListActionPerformed() {
        currentPID = resultFrame.partyList.getSelectedIndex()+1;
        System.out.println("question name = " + resultFrame.partyList.getSelectedItem());
        System.out.println("pid = " + currentPID);
    }
	
    private void requirementListActionPerformed() {
        currentQID = resultFrame.requirementList.getSelectedIndex()+1;
        System.out.println("question name = " + resultFrame.requirementList.getSelectedItem());
        System.out.println("qid = " + currentQID);
        resultFrame.showButton.setEnabled(true);
    }
	
    private void showButtonActionPerformed() {
        if (currentPID != -1 && currentQID != -1) {
            try {
                String query = "SELECT Weight FROM Weights WHERE p_id=" + currentPID + " AND r_id=" + currentQID;
                ResultSet res = adb.executeQuery(query);
                while (res.next()) { 
                    String weight =  res.getString(1);
                    System.out.println(weight);
                    resultFrame.weightTextArea.setText(weight);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }   
        }
    }
    
    
    
}
