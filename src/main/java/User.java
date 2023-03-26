import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private String role;


    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    private List<String> posts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPosts() {
        return posts;
    }

    public void initializePosts() { posts = new ArrayList<>(); }

    public void addPost(String post) {
        posts.add(post);
    }

    public List<String> getAllPostsContainingWord(String word) {
        List<String> filteredPosts = new ArrayList<>();
        for(String post: posts) {
            if(post.contains(word))
                filteredPosts.add(post);
        }
        return filteredPosts;
    }
}
