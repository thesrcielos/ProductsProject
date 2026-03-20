import { useState } from "react";

const ProductForm = ({ onAddProduct }) => {
    const [productName, setProductName] = useState("");
    const [price, setPrice] = useState(0.01);
    const [stock, setStock] = useState(1);

    const handleSubmit = (e) => {
        e.preventDefault();
        const product = {
            name: productName,
            price: parseFloat(price),
            stock: parseInt(stock)
        };
        onAddProduct(product);
        setPrice(0);
        setStock(0);
        setProductName("");
        e.target.reset();
    }

  return (
    <div className="product-form">
        <h2>Product Form</h2>
        <form onSubmit={handleSubmit}> 
            <div className="form-group">
                <label htmlFor="productName">Product Name</label>
                <input placeholder="name" type="text" id="productName" name="productName" value={productName} onChange={(e) => setProductName(e.target.value)} />
            </div>
            <div className="form-group">
                <label htmlFor="price">Price</label>
                <input type="number" id="price" min={0.01} step={0.01} name="price" value={price} onChange={(e) => setPrice(e.target.value)} />
            </div>
            <div className="form-group">
                <label htmlFor="stock">Stock</label>
                <input type="number" id="stock" min={1} name="stock" value={stock} onChange={(e) => setStock(e.target.value)} />
            </div>
            <button type="submit">Add Product</button>
        </form>
    </div>
  );
}

export default ProductForm;