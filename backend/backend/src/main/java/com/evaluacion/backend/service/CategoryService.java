package com.evaluacion.backend.service;

import com.evaluacion.backend.entity.Category;
import com.evaluacion.backend.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
    public Category updateCategory(Long id, Category category) {
        Optional<Category> categoryToUpdate = categoryRepository.findById(id);

        if (categoryToUpdate.isPresent()) {
            Category categoryInDb = categoryToUpdate.get();
            categoryInDb.setName(category.getName());

            return categoryInDb;
        }
        return null;
    }

    public String deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Category with ID #" + id + " deleted successfully.";
        }
        return "Category with ID #" + id + " not found.";
    }
}
