import { useState, useEffect } from "react";
import api from "../services/api";
import ProductForm from "../components/ProductForm";
import ProductsTable from "../components/ProductsTable";

const Products = () => {
    const [products, setProducts] = useState([]);
    useEffect(() => {
        api.get("/api/productos")
            .then(response => {
                setProducts(response.data);
            }).catch(error => {
                console.error("Error fetching products:", error);
            });
    }, []);

    const handleAddProduct = (product) => {
        api.post("/api/productos", product)
            .then(response => {
                if (products.some(p => p.id === response.data.id)) {
                    setProducts(products.map(p => p.id === response.data.id ? response.data : p));
                    return;
                }
                setProducts([...products, response.data]);
            }).catch(error => {
                console.error("Error adding product:", error);
            });
    };

    const hanleDeleteProduct = (productId) => {
        api.post(`/api/productos/${productId}`)
            .then(() => {
                setProducts(products.filter(product => product.id !== productId));
            }).catch(error => {
                console.error("Error deleting product:", error);
            }
        );
    }

    return (
        <div>
            <h1>Products</h1>
            <ProductsTable products={products} onDeleteProduct={hanleDeleteProduct} />
            <ProductForm onAddProduct={handleAddProduct}
            />
        </div>
    );
}

export default Products;