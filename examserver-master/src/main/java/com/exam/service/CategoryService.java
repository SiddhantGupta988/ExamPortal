package com.exam.service;

import com.exam.models.Exam.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long CategoryId);
    public void deleteCategory(Long CategoryId);


}
