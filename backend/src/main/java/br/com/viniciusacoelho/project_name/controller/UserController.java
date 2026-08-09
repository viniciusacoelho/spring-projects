package br.com.viniciusacoelho.project_name.controller;

import br.com.viniciusacoelho.project_name.dto.UserDTO;
import br.com.viniciusacoelho.project_name.dto.UserUpdateDTO;
import br.com.viniciusacoelho.project_name.model.User;
import br.com.viniciusacoelho.project_name.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @GetMapping("/read")
    public ResponseEntity<List<User>> read() {
        return ResponseEntity.ok(userService.read());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getOne(id));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        return ResponseEntity.ok(userService.update(id, userUpdateDTO));
    }

//    @PutMapping("/update/{username}")
//    public ResponseEntity<User> updateByUsername(@PathVariable("username") String username, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
//        return ResponseEntity.ok(userService.updateByUsername(username));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

}
