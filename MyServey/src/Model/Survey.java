/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Tomer Efraim
 */
public class Survey {
    private int pid;
    private String title;
    private String description;
    private List<Question> questions;

    public Survey(String title, String description, List<Question> questions) {
        this.pid = -1;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }
    
    public int getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public Question getQuestion(int qid) {
        System.out.println("get question #" + qid);
        return questions.get(qid);
    }

    public List<Question> getQuestions() {
        return questions;
    }
    
    public int getQuestionSize() {
        return questions.size();
    }

    public void setPid(int pid) {
    	this.pid = pid;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }  
    
    public void addQuestion(Question question){
        this.questions.add(question);
    }
    
    public void answer(int qid, int resid) {
        System.out.println("questions size = " + questions.size());
    	questions.get(qid).setResid(resid);
    }   
    
}
