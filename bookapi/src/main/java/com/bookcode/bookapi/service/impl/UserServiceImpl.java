package com.bookcode.bookapi.service.impl;
import com.bookcode.bookapi.repository.UserRepository;
import com.bookcode.bookapi.model.User;
import com.bookcode.bookapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
    @Override
    public User login(String name, String password) {
        return userRepository.login(name,password);
    }
}
