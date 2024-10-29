package ru.andrew.NauJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.andrew.NauJava.config.SpringSecurityConfig;
import ru.andrew.NauJava.models.Role;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.repositories.RoleRepository;
import ru.andrew.NauJava.repositories.UserRepository;
import ru.andrew.NauJava.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private SpringSecurityConfig springSecurityConfig;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(springSecurityConfig.getPasswordEncoder()).thenReturn(passwordEncoder);
    }

    @Test
    void createUser_ShouldSaveUser_WhenUserIsValid() {
        String username = "testUser";
        String password = "testPassword";
        String roleName = "USER";

        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");
        when(roleRepository.findByName(roleName)).thenReturn(Optional.empty());
        when(roleRepository.save(any(Role.class))).thenReturn(new Role());

        userService.createUser(username, password, List.of(roleName));

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void findById_ShouldReturnUser_WhenUserExists() {
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("existingUser");
        mockUser.setRoles(Set.of());

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        User user = userService.findById(userId);

        assertEquals("existingUser", user.getName());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void findById_ShouldReturnEmptyUser_WhenUserDoesNotExist() {
        Long userId = 999L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        User user = userService.findById(userId);

        assertNotNull(user);
        assertNull(user.getId());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void deleteById_ShouldInvokeDeleteOnUserRepository_WhenUserExists() {
        Long userId = 1L;

        userService.deleteById(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }
}
