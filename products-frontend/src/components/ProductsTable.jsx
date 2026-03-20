const ProductsTable = ({ products, onDeleteProduct }) => {
    return (
        <table className="products-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {products?.map((product) => (
                    <tr key={product.id}>
                        <td>{product.name}</td>
                        <td>{product.price}</td>
                        <td>{product.stock}</td>
                        <td>
                            <button onClick={() => onDeleteProduct(product.id)}>Delete</button>
                        </td>
                    </tr>

                ))}
            </tbody>
        </table>
    );
}

export default ProductsTable;