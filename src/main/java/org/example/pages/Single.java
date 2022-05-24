package org.example.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.entities.Comment;
import org.example.entities.Post;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class Single extends BasePage {
    @Property
    private Long postId;
    @Inject
    private Session session;
    @Property
    private Post post;
    @Property
    private Comment currentComment;
    @Persist
    @Property
    private Comment newComment;

    void onActivate(long postId) {
        this.postId = postId;
    }

    void onActivate() {
    }

    Long onPassivate() {
        return postId;
    }
    void setupRender() {
        if (postId != null) {
            List<Post> posts = null;
            posts = getPostsById(postId);
            if (posts != null && !posts.isEmpty()) {
                post = posts.get(0);
            }
        }
        newComment = new Comment(post);
    }

    public void onSuccessFromCommentForm(){
        newComment.setDate(new Date());
        saveObject(newComment);
    }

    public String getBackgroundImage() {
        return "background-image:url('" + getImagesPath() + "/postPhoto/" + post.getImage() + "')";
    }
}
