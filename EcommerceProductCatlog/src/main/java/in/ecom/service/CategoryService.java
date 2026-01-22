package in.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ecom.model.Category;
import in.ecom.repository.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
}
