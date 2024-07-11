package io.github.srujangajul.stackoverflow.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class StackOverFlow {
    private Map<Integer, Question> questions;

    public StackOverFlow(){
        this.questions = new HashMap<>();
    }

    public void addQuestion(Question question){
        this.questions.put(question.getId(), question);
    }

    public void removeQuestion(Question question){
        this.questions.remove(question.getId());
    }

    public boolean addAnswer(int questionId, Answer answer){
        Question question = this.questions.get(questionId);
        if(question!=null){
            return question.addAnswer(answer);
        }
        return false;
    }

    public List<Question> search(String string){

        return questions.values().stream()
                .filter(
                        question ->
                                question.getTitle().contains(string) ||
                                question.getDescription().contains(string) ||
                                question.getTags().contains(string) ||
                                question.getPostedBy().getName().equalsIgnoreCase(string)
                        )
                .collect(Collectors.toList());
    }

    public void upvote(int questionId){
        Question question = this.questions.get(questionId);
        if(question!=null){
            question.upvote();
        }
    }

}
