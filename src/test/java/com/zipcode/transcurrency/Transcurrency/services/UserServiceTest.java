package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.User;
import com.zipcode.transcurrency.Transcurrency.repositories.IUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    //Mock instance of UserService
    @InjectMocks
    private UserService userService;

//    Another way of generating mock instance
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserById() throws Exception {

        User userTest = new User("Tom", "SuperTom");
        userTest.setId(1L);

        when(userRepository.findOne(1L)).thenReturn(userTest);
        User newUser = userService.getUser(1L);

        Long id = 1L;

        assertEquals(id, newUser.getId());
        assertEquals("Tom", newUser.getName());
    }

    @Test
    public void getAllUsersTest() throws Exception {

        User user1 = new User();
        List<User> userData = new ArrayList<>();
        userData.add(user1);

        when(userRepository.findAll()).thenReturn(userData);
        List<User> users = userService.getAllUsers();

        assertEquals(users.size(), 1);
    }

    @Test(expected = RuntimeException.class)
    public void addUserTest() throws Exception {

        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        User userTest = new User();

        userService.addUser(userTest);

        verify(userRepository, times(1)).save(userTest);
        verify(userRepository).save(any(User.class));

    }

    @Test
    public void addUserWithVerificationTest() throws Exception{

        when(userRepository.save(any(User.class))).thenReturn(new User());
        User user1 = new User();

        assertThat(userService.addUserWithVerification(user1), is(notNullValue()));
    }

    //verifying userService is asked to do deleteUserById()
    @Test
    public void deleteUserById() throws Exception {

        User userTest = new User("Tom", "SuperTom");
        userTest.setId(1L);

        Long id = 1L;
        userService.deleteUser(id);
        verify(userService, times(1)).deleteUser(1L);
    }

}