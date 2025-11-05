package ru.job4j.resservice.resourceservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.resservice.resourceservice.model.User;
import ru.job4j.resservice.resourceservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long adduser(String userName) {
        User user = new User(null, userName);
        return userRepository.save(user).getId();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
