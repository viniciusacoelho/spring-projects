package br.com.viniciusacoelho.project_name;

import br.com.viniciusacoelho.project_name.model.User;
import br.com.viniciusacoelho.project_name.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    @Autowired
    private UserService userService;

    @Test
    void shouldBeTrue() {
        User user = userService.getOne(1L);
        String username = userService.getOne(1L).getUsername();
        assertEquals("viniciusacoelho", username);
    }

}
