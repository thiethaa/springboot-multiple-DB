package com.thiethaa.multipledbprofile.controller;

import com.thiethaa.multipledbprofile.repository.bookRepo.BookRepository;
import com.thiethaa.multipledbprofile.model.book.Book;
import com.thiethaa.multipledbprofile.model.user.User;
import com.thiethaa.multipledbprofile.repository.userRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class Controller {

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private UserRepository userRepository;

        @PostConstruct
        public void addData2DB() {
            userRepository.saveAll(Stream.of(new User(744, "John"), new User(455, "Pitter")).collect(Collectors.toList()));
            bookRepository.saveAll(
                    Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
        }

        @GetMapping("/getUsers")
        public List<User> getUsers() {
            return userRepository.findAll();
        }

        @GetMapping("/getBooks")
        public List<Book> getBooks() {
            return bookRepository.findAll();
        }
}
