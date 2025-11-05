package ru.job4j.resservice.resourceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.resservice.resourceservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
