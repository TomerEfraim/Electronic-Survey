/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import Viewer.*;
import javax.swing.JRadioButton;

/**
 *
 * @author Tomer Efraim
 */
public class QuestionManualController extends QuestionController {
    
    QuestionFrame questionFrame;
    JRadioButton selectedButton;
    boolean next;
   
    
    private ActionListener nextButtonListener;
    private ActionListener finishButtonListener;
    private ActionListener answerButton0Listener;
    private ActionListener answerButton1Listener;
    private ActionListener answerButton2Listener;
    private ActionListener answerButton3Listener;
    private ActionListener answerButton4Listener;
    private ActionListener answerButton5Listener;
    private ActionListener answerButton6Listener;
    private ActionListener answerButton7Listener;
    private ActionListener answerButton8Listener;
    private ActionListener answerButton9Listener;
    private ActionListener answerButton10Listener;
    
    
    public QuestionManualController(Survey s, AccessDBHandler a, QuestionFrame qFrame) {
        super(s, a);
        questionFrame = qFrame;
        selectedButton = null;
        questionFrame.finishButton.setEnabled(false);
        questionFrame.nextButton.setEnabled(false);
        next = true;
        showDescriptionFormat();
    }
    
    private void goNextQuestion() {
        if (next) {
            qid++;
        }
    }
    
    private void nextOrFinish() {
        if (qid+1 >= survey.getQuestionSize()) {
            next = false;
            questionFrame.nextButton.setEnabled(false);
            questionFrame.finishButton.setEnabled(true);
        } else {
            questionFrame.nextButton.setEnabled(true);
        }
        
    }
        
    private void checkSelected() {
        if (selectedButton != null) {
            selectedButton.setSelected(false);
        }
    }
    
    private void showDescriptionFormat() {
        String sqid = new Integer(qid).toString();
        String description = survey.getQuestion(qid).getDescription();
        questionFrame.questionDescriptionArea.setText(sqid + ". " + description);
        questionFrame.questionDescriptionArea.setEditable(false);
    }
    
    @Override
    public void controll() {
        
        nextButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButtonActionPerformed();
            }
        };
        finishButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finishButtonActionPerformed();
            }
        };
        answerButton0Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton0ActionPerformed();
            }
        };
        answerButton1Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton1ActionPerformed();
            }
        };
        answerButton2Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton2ActionPerformed();
            }
        };
        answerButton3Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton3ActionPerformed();            
            }
        };
        answerButton4Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton4ActionPerformed();            
            }
        };
        answerButton5Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton5ActionPerformed();            
            }
        };
        answerButton6Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton6ActionPerformed();            
            }
        };
        answerButton7Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton7ActionPerformed();            
            }
        };
        answerButton8Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton8ActionPerformed();            
            }
        };
        answerButton9Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton9ActionPerformed();            
            }
        };
        answerButton10Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerButton10ActionPerformed();            
            }
        };
        questionFrame.nextButton.addActionListener(nextButtonListener);
        questionFrame.finishButton.addActionListener(finishButtonListener);
        questionFrame.answerButton0.addActionListener(answerButton0Listener);
        questionFrame.answerButton1.addActionListener(answerButton1Listener);
        questionFrame.answerButton2.addActionListener(answerButton2Listener);
        questionFrame.answerButton3.addActionListener(answerButton3Listener);
        questionFrame.answerButton4.addActionListener(answerButton4Listener);
        questionFrame.answerButton5.addActionListener(answerButton5Listener);
        questionFrame.answerButton6.addActionListener(answerButton6Listener);
        questionFrame.answerButton7.addActionListener(answerButton7Listener);
        questionFrame.answerButton8.addActionListener(answerButton8Listener);
        questionFrame.answerButton9.addActionListener(answerButton9Listener);
        questionFrame.answerButton10.addActionListener(answerButton10Listener);  
    }
    
    private void nextButtonActionPerformed() {
        checkSelected();
        goNextQuestion();
        if (next == true) {
            showDescriptionFormat();
        }
        questionFrame.nextButton.setEnabled(false);
    }
    
    private void finishButtonActionPerformed() {     
        if (questionFrame.finishButton.isEnabled()) {
            super.updateDB();
            questionFrame.setVisible(false);
            super.finish();
        }
    } 

    private void answerButton0ActionPerformed() {
        checkSelected();
        selectedButton = questionFrame.answerButton0;
        
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 0);
        nextOrFinish();
    }                                             

    private void answerButton1ActionPerformed() {
        checkSelected();
        selectedButton = questionFrame.answerButton1;
        
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 1);
        nextOrFinish();
    }                                             

    private void answerButton2ActionPerformed() {  
        checkSelected();
        selectedButton = questionFrame.answerButton2;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 2);
        nextOrFinish();
    }                                             

    private void answerButton3ActionPerformed() {  
        checkSelected();
        selectedButton = questionFrame.answerButton3;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 3);
        nextOrFinish();
    }                                             

    private void answerButton4ActionPerformed() {  
        checkSelected();
        selectedButton = questionFrame.answerButton4;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 4);
        nextOrFinish();
    }                                             

    private void answerButton5ActionPerformed() {   
        checkSelected();
        selectedButton = questionFrame.answerButton5;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 5);
        nextOrFinish();
    }                                             

    private void answerButton6ActionPerformed() {   
        checkSelected();
        selectedButton = questionFrame.answerButton6;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 6);
        nextOrFinish();
    }                                             

    private void answerButton7ActionPerformed() { 
        checkSelected();
        selectedButton = questionFrame.answerButton7;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 7);
        nextOrFinish();
    }                                             

    private void answerButton8ActionPerformed() {  
        checkSelected();
        selectedButton = questionFrame.answerButton8;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 8);
        nextOrFinish();
    }                                             

    private void answerButton9ActionPerformed() {  
        checkSelected();
        selectedButton = questionFrame.answerButton9;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 9);
        nextOrFinish();
    }                                             

    private void answerButton10ActionPerformed() { 
        checkSelected();
        selectedButton = questionFrame.answerButton10;
        selectedButton.setSelected(true); //////////////////////////////////
        survey.answer(qid, 10);
        nextOrFinish();
    }                                              

}
