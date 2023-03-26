import java.util.List;

public class ApplicationDao {
    public User getUserById(String id) {
        if(id.equals("3412"))
            return null;
//        Make database query and return a list of users
        User user = new User();
        user.setUsername("mark");
        user.setPassword("name123");
        user.initializePosts();
        user.addPost("It's a beautiful day");
        return user;
    }

    public void save(User user) throws Exception {
//        Save entry into db
//        throws exception if user obj is null
        if(user == null)
            throw new Exception("The user is null");
        System.out.println("User saved successfully");
    }
}
