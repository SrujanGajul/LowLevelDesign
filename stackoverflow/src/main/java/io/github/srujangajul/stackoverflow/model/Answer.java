package io.github.srujangajul.stackoverflow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Answer {
    private final int id;
    private final User postedBy;
    private String description;
    private int upvoteCount;
    private Set<String> tags;
    private List<Comment> comments;

    public Answer(int id, User postedBy, String description){
        this.id = id;
        this.postedBy = postedBy;
        this.description = description;
        upvoteCount = 0;
        tags = new HashSet<>();
        comments = new LinkedList<>();
    }

    public boolean addTag(String tag){
        return this.tags.add(tag);
    }

    public boolean removeTag(String tag){
        return this.tags.remove(tag);
    }

    public boolean addComment(Comment comment){
        return this.comments.add(comment);
    }

    public boolean removeComment(Comment comment){
        return this.comments.remove(comment);
    }

    public synchronized void upvote(){
        this.upvoteCount +=1;
    }

    public synchronized void downvote(){
        this.upvoteCount -=1;
    }
}
