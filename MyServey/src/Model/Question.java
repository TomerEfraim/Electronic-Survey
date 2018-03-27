/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tomer Efraim
 */
public class Question {
        
    private static final int SCALE_SIZE = 11; // a scale from 0 to 10
    private int qid;
    private int resid; // id of the answer the user chose 
    private String description;
    private int[] answers; 
    
    public Question(int qid, String description) {
        this.qid = qid;
        this.resid = -1;
        this.description = description;
        this.answers = new int[SCALE_SIZE];
        initScale();
    }
    
    private void initScale() {
    	for (int i = 0; i  <SCALE_SIZE; ++i) {
    		answers[i] = i;
    	}
    }

    public int getQid() {
        return qid;
    }
    
    public int getResid() {
    	return resid;
    }

    public String getDescription() {
        return description;
    }
    
    public int getAnswerSize(){
        return SCALE_SIZE-1;
    }
    
    public int getAnswer(int aid) {
        return answers[aid];
    }
    
    public void setQid(int qid) {
        this.qid = qid;
    }
    
    public void setResid(int resid) {
        this.resid = resid;
    }
   
    public void setDescription(String description) {
        this.description = description;
    }
    
}
