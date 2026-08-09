package br.com.viniciusacoelho.project_name.service;

import br.com.viniciusacoelho.project_name.dto.UserDTO;
import br.com.viniciusacoelho.project_name.dto.UserUpdateDTO;
import br.com.viniciusacoelho.project_name.exceptions.AlreadyCreatedException;
import br.com.viniciusacoelho.project_name.exceptions.NotFoundException;
import br.com.viniciusacoelho.project_name.model.User;
import br.com.viniciusacoelho.project_name.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(UserDTO userDTO) {
        existsUserByEmail(userDTO.getEmail());
        existsUserByUsername(userDTO.getUsername());
        existsUserByCpf(userDTO.getCpf());

        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .username(userDTO.getUsername())
                .birthDate(userDTO.getBirthDate())
                .cpf(userDTO.getCpf())
                .cep(userDTO.getCep())
                .password(userDTO.getPassword())
                .build();

        log.info("Usuário cadastrado com sucesso!");
        return userRepository.save(user);
    }

    public List<User> read() {
        if (hasUser()) {
            log.info("Usuários listados com sucesso!");
            return userRepository.findAll();
        }

        log.warn("Nenhum usuário encontrado");
        return null;
    }

    @Transactional // TODO: Search for JPA Dirty Checking
    public User update(Long id, UserUpdateDTO userUpdateDTO) {
        User user = findUserById(id);

        validateUser(user, userUpdateDTO);

        user.setName(userUpdateDTO.name());
        user.setEmail(userUpdateDTO.email());
        user.setUsername(userUpdateDTO.username());
        user.setBirthDate(userUpdateDTO.birthDate());
        user.setCpf(userUpdateDTO.cpf());
        user.setCep(userUpdateDTO.cep());
        user.setPassword(userUpdateDTO.password());

        log.info("Usuário atualizado com sucesso!");
        return user;
    }

    public User updateByUsername(String username) {
        hasUsername(username);
        existsUserByUsername(username);
        User user = findByUsername(username);
        return userRepository.save(user);
    }

    public User delete(Long id) {
        exitsById(id);
        User user = findUserById(id);
        userRepository.delete(user);
        log.info("Usuário deletado com sucesso!");
        return user;
    }

    public User getOne(Long id) {
        log.info("Usuário buscado com sucesso!");
        findUserById(id);
        return userRepository.getOne(id);
//        return userRepository.getReferenceById(id);
    }

    public User findByUsername(String username) {
        hasUsername(username);
        return userRepository.findByUsername(username);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário"));
//                .orElseThrow(() -> new NotFoundException(User.class.getName()));
    }

    private User findUserByEmail(String email) {
        existsUserByEmail(email);
        return userRepository.findByEmail(email);
    }

    private User findUserByUsername(String username) {
        existsUserByUsername(username);
        return userRepository.findByUsername(username);
    }

    private void exitsById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("Usuário");
        }
    }

    private void existsUserByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new AlreadyCreatedException("E-mail");
        }
    }

    private void existsUserByUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new AlreadyCreatedException("Usuário");
        }
    }

    private void existsUserByCpf(String cpf) {
        if (userRepository.existsByCpf(cpf)) {
            throw new AlreadyCreatedException("CPF");
        }
    }

    private boolean hasUser() {
        return userRepository.count() > 0;
    }

    private void hasUsername(String username) {
        if (!userRepository.existsByUsername(username)) {
            throw new NotFoundException("Usuário");
        }
    }

    private void validateUser(User user, UserUpdateDTO userUpdateDTO) {
        if (!userUpdateDTO.email().equalsIgnoreCase(user.getEmail())) {
            existsUserByEmail(userUpdateDTO.email());
        }

        if (!userUpdateDTO.username().equalsIgnoreCase(user.getUsername())) {
            existsUserByUsername(userUpdateDTO.username());
        }

        if (!userUpdateDTO.cpf().equalsIgnoreCase(user.getCpf())) {
            existsUserByCpf(userUpdateDTO.cpf());
        }
    }

}
