package com.exam.service.impl;

import com.exam.models.Exam.Category;
import com.exam.repo.CategoryRepository;
import com.exam.service.CategoryService;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        this.categoryRepository.deleteById(category.getCid());
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long CategoryId) {
        return  this.categoryRepository.findById(CategoryId).get();
    }

    @Override
    public void deleteCategory(Long CategoryId) {
        this.categoryRepository.deleteById(CategoryId);
    }
}
