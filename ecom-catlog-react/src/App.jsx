import { useEffect, useState } from 'react';
import './App.css';
import ProductList from "./components/ProductList";
import CategoryFilter from './components/CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");



  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(res => res.json())
      .then(data => setProducts(data))
      .catch(err => console.error(err));

    fetch('http://localhost:8080/api/categories')
      .then(res => res.json())
      .then(data => setCategories(data))
      .catch(err => console.error(err));
  }, []);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };


  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const filteredProducts = products
  .filter((product) => {
    return (
      (selectedCategory ? product.category?.id === selectedCategory : true) &&
      (searchTerm
        ? product.name.toLowerCase().includes(searchTerm.toLowerCase())
        : true)
    );
  })
  .sort((a, b) => {
    const priceA = Number(a.Price);
    const priceB = Number(b.Price);

    return sortOrder === "asc"
      ? priceA - priceB
      : priceB - priceA;
  });


  return (
    <div className="container">
      <h1 className='my-4'> Product Catlog </h1>
      <div className='row align-items-center mb-4'>
        <div className='col-md-4'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
        </div>
        <div className='col-md-4'>
          <input
            type="text"
            className='form-control'
            placeholder='Search Products...'
            onChange={handleSearchChange}
          />
        </div>
        <div className='col-md-4'>
          <select className='form-select' onChange={(e) => setSortOrder(e.target.value)} >
            <option value='asc'>Sort by Price: Low to High</option>
            <option value='desc'>Sort by Price: High to Low</option>
          </select>
        </div>
      </div>
      {filteredProducts.length > 0 ? (
        <ProductList products={filteredProducts} />
      ) : (
        <p>No Products Found</p>
      )}
    </div>
  );
}

export default App;
