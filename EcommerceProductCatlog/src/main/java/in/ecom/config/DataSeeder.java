package in.ecom.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ecom.model.Category;
import in.ecom.model.Product;
import in.ecom.repository.CategoryRepository;
import in.ecom.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
//		clear all existing data
		productRepository.deleteAll();
		categoryRepository.deleteAll();

//		Create categories

		Category electronics = new Category();
		electronics.setName("Electronics");

		Category clothing = new Category();
		clothing.setName("Clothing");

		Category home = new Category();
		home.setName("Home and Kitchen");

		categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

//		create product

		Product phone = new Product();
		phone.setName("Smart Phone");
		phone.setDescription("this is a Smart Phone");
		phone.setPrice(699.990);
		phone.setImageUrl("https://placehold.co/600x400");
		phone.setCategory(electronics);

		Product laptop = new Product();
		laptop.setName("Smart laptop");
		laptop.setDescription("this is a Smart laptop");
		laptop.setPrice(699.990);
		laptop.setImageUrl("https://placehold.co/600x400");
		laptop.setCategory(electronics);

		Product PSIV = new Product();
		PSIV.setName("Smart PSIV");
		PSIV.setDescription("this is a Smart PSIV");
		PSIV.setPrice(699.990);
		PSIV.setImageUrl("https://placehold.co/600x400");
		PSIV.setCategory(electronics);

		Product threePieceSuit = new Product();
		threePieceSuit.setName("Three Piece Suit");
		threePieceSuit.setDescription("this is a Three Piece Traditional Sit for Men");
		threePieceSuit.setPrice(19999.00);
		threePieceSuit.setImageUrl("https://placehold.co/600x400");
		threePieceSuit.setCategory(clothing);

		Product Saree = new Product();
		Saree.setName("Lehenga");
		Saree.setDescription("this is a Traditional saree for Women");
		Saree.setPrice(18999.00);
		Saree.setImageUrl("https://placehold.co/600x400");
		Saree.setCategory(clothing);

		Product Lehenga = new Product();
		Lehenga.setName("Lehenga");
		Lehenga.setDescription("this is a Traditional Lehenga for Women");
		Lehenga.setPrice(15999.00);
		Lehenga.setImageUrl("https://placehold.co/600x400");
		Lehenga.setCategory(clothing);

		Product knife = new Product();
		knife.setName("Super Knife");
		knife.setDescription("this is a Knife Killing SomeOne");
		knife.setPrice(159.00);
		knife.setImageUrl("https://placehold.co/600x400");
		knife.setCategory(home);

		productRepository.saveAll(Arrays.asList(phone, laptop, PSIV, threePieceSuit, Saree, Lehenga, knife));

	}

}
