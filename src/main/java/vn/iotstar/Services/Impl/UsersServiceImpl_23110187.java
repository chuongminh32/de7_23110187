package vn.iotstar.Services.Impl;

import vn.iotstar.Services.UsersService_23110187;
import vn.iotstar.entity.Users_23110187;
import vn.iotstar.Repository.UsersRepository_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl_23110187 implements UsersService_23110187 {

    @Autowired
    private UsersRepository_23110187 usersRepository;

    @Override
    public List<Users_23110187> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Page<Users_23110187> findAll(int page, int size) {
        return usersRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Users_23110187> findById(String username) {
        return usersRepository.findById(username);
    }

    @Override
    public Optional<Users_23110187> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Page<Users_23110187> findByAdmin(Boolean admin, int page, int size) {
        return usersRepository.findByAdmin(admin, PageRequest.of(page, size));
    }

    @Override
    public Page<Users_23110187> findByActive(Boolean active, int page, int size) {
        return usersRepository.findByActive(active, PageRequest.of(page, size));
    }

    @Override
    public Users_23110187 save(Users_23110187 user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteById(String username) {
        usersRepository.deleteById(username);
    }
}
