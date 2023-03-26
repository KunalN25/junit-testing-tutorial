import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockingTests {

    Mocking mocking;

    @Mock
    ApplicationDao applicationDao;


    @BeforeEach
    public void setup() {
//        user = mock(User.class);
        mocking = new Mocking();

    }
    @Test
    @DisplayName("Permission assigned successfully")
    public void assignPermissions() {
        User user = mock(User.class);
        mocking.setUser(user);
        when(user.getRole()).thenReturn("admin");
        when(user.getUsername()).thenReturn("kunal");
        Assertions.assertEquals(1, mocking.assignPermission());

//        Test Method Stubbing for explanation
//        List<String> filteredPosts = new ArrayList<>();
//        filteredPosts.add("Awesome Day");
//        filteredPosts.add("This place is awesome");
//        when(user.getAllPostsContainingWord("awesome")).thenReturn(filteredPosts);
    }

    @Test
    @DisplayName("User updated successfully")
    public void updateUsername() throws Exception {
        User user = new User();
        user.setUsername("kunal");
        lenient().when(applicationDao.getUserById(Mockito.anyString())).thenReturn(user);
        Assertions.assertEquals(1, mocking.updateUsername("3211", "allan"));
    }

    @Test
    @DisplayName("User could not be updated")
    public void updateUsernameError() throws Exception {
        lenient().when(applicationDao.getUserById(Mockito.anyString())).thenReturn(null);
        Assertions.assertThrows(Exception.class, () -> {
            mocking.updateUsername("3412","allan");
        });
    }
}
