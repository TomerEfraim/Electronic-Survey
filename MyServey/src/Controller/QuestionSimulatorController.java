/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.*;

/**
 *
 * @author Tomer Efraim
 */
public class QuestionSimulatorController extends QuestionController {
    
    public QuestionSimulatorController(Survey s, AccessDBHandler db) {
        super(s, db);
    }
    
    @Override
    public void controll() {
        simulate();
    }
    
     
    private void simulate() {
        int numQuestions = survey.getQuestionSize();
        while (qid + 1 < numQuestions) {   
            survey.answer(qid, (int)((Math.random()*10)-0.5));
            qid++;
        }
        super.updateDB();
        super.finish();
    }
    
}
