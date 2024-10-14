package ru.andrew.NauJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.repositories.UserRepository;
import ru.andrew.NauJava.services.UserServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        String userName = "Andrew";
        User user = new User();
        user.setName(userName);

        when(userRepository.save(any(User.class))).thenReturn(user);

        String result = userService.createUser(userName);

        assertEquals(userName, result);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testFindById() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        User result = userService.findById(1L);

        assertEquals(1L, result.getId());
        verify(userRepository, times(1)).findById("1");
    }

    @Test
    public void testDeleteById() {
        Long userId = 1L;

        userService.deleteById(userId);

        verify(userRepository, times(1)).deleteById("1");
    }
}
