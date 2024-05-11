package com.evaluacion.backend.controller;

import com.evaluacion.backend.entity.Category;
import com.evaluacion.backend.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/create")
    public Category createCategory(Category category) {
        if(category != null) {
            return categoryService.createCategory(category);
        }
        return null;
    }
    @GetMapping("/{id}")
    public Category findCategoryById(@RequestParam Long id) {
        return categoryService.findCategoryById(id);
    }
    @GetMapping
    public List<Category> listCategories() {
        return categoryService.listCategories();
    }
    @PutMapping("/{id}")
    public Category updateCategory(@RequestParam Long id, @RequestBody Category category) {
        if(category != null) {
            return categoryService.updateCategory(id, category);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(@RequestParam Long id) {
        return categoryService.deleteCategory(id);
    }
}
