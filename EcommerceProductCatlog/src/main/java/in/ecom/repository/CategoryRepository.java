package in.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.ecom.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
