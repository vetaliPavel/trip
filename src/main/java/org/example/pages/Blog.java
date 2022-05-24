package org.example.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.entities.Post;

import java.util.List;

public class Blog extends BasePage {
    public String getBlogPage() {
        return "blog";
    }

    @Property
    private List<Post> allPost;
    @Property
    private Post currentPost;
    @Inject
    private PageRenderLinkSource linkSource;


    void setupRender() {
        allPost = getPosts();
    }


    public Link onActionFromShowPostDetails(long id) {
        return linkSource.createPageRenderLinkWithContext(Single.class, id);
    }
}
