package vn.iotstar.Services.Impl;

import vn.iotstar.Services.CategoryService_23110187;
import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Users_23110187;
import vn.iotstar.Repository.CategoryRepository_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl_23110187 implements CategoryService_23110187 {

    @Autowired
    private CategoryRepository_23110187 categoryRepository;

    @Override
    public List<Category_23110187> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category_23110187> findAll(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Category_23110187> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Page<Category_23110187> searchByCategoryName(String keyword, int page, int size) {
        return categoryRepository.findByCategoryNameContainingIgnoreCase(keyword, PageRequest.of(page, size));
    }

    @Override
    public Category_23110187 save(Category_23110187 category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category_23110187> findByUser(Users_23110187 user) {
        return categoryRepository.findByUser(user);
    }

    @Override
    public Page<Category_23110187> findByUser(Users_23110187 user, int page, int size) {
        return categoryRepository.findByUser(user, PageRequest.of(page, size));
    }
    
    @Override
    public List<Category_23110187> findAllCategoriesWithVideos() {
        // @EntityGraph trong repository đã load luôn videos
        return categoryRepository.findAll();
    }
}
