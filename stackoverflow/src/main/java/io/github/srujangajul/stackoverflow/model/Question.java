package io.github.srujangajul.stackoverflow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Question {
    private final int id;
    private final User postedBy;
    private String title;
    private String description;
    private List<Answer> answers;
    private int upvoteCount;
    private Set<String> tags;
    private List<Comment> comments;


    public Question(int id, User postedBy, String title, String description){
        this.id = id;
        this.postedBy = postedBy;
        this.title = title;
        this.description = description;
        upvoteCount = 0;
        tags = new HashSet<>();
        answers = new LinkedList<>();
    }

    public boolean addAnswer(Answer answer){
        return this.answers.add(answer);
    }

    public boolean addTag(String tag){
        return this.tags.add(tag);
    }

    public boolean removeAnswer(Answer answer){
        return this.answers.remove(answer);
    }

    public boolean removeTag(String tag){
        return this.tags.remove(tag);
    }

    public synchronized void upvote(){
        this.upvoteCount +=1;
    }

    public synchronized void downvote(){
        this.upvoteCount -=1;
    }

    public List<Answer> getAnswers(){
        this.answers.sort(Comparator.comparingInt(Answer::getUpvoteCount));
        return answers;
    }
}
