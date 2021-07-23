package service;

import controller.PostController;
import model.Label;
import model.Post;

import java.util.Date;

import java.util.List;
import java.util.Set;

public class PostService {

    private PostController postController = new PostController();

    public Post save(String postContent, Set<Label> labelList, Date createDate){
        postController.setPostContent(postContent);
        postController.setPostLabels(labelList);
        postController.setCreated(createDate);

        return postController.savePost();
    }

    public Post update(Long id, String postContent,Set<Label> labelList, Date updateDate){
        postController.setPostId(id);
        postController.setPostContent(postContent);
        postController.setPostLabels(labelList);
        postController.setUpdated(updateDate);

        return postController.updatePost();
    }

    public Post getById(Long id){
        return postController.getByIdPost(id);
    }

    public List<Post> getAll(){
        return postController.getAllLebels();
    }

    public void deleteById(Long id){
        postController.deleteByidPost(id);
    }
}
