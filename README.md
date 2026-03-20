# Productos Proyecto

## Como Instalar y ejecutar
Abre la carpeta de products donde se encuentra el backend. Para ejecutarlo necesitaras tener docker instalado.

Ejecuta el comando
```bash
docker compose up --build
```

Ahora abre la carpeta de products-frontend
para ejecutarlo necesitaras tener instalado npm.

Ejecuta los siguientes comandos
```bash
npm install
npm run dev
```

Abre la url del frontend en el navegador, verás una tabla vacia y un formulario para añadir productos, llena el formulario con algunos productos y veras como van apareciendo item en la tabla.

Tienes la opcion de eliminar un producto, tambien puedes actualizarlo si en el formulario poner el nombre del producto a actualizar y los valores que deseas cambiar.

## Backend Endpoints
**GET /api/productos** obtener todos los productos
**POST /api/productos** Crear o actualizar un producto
**POST /api/productos/{id}** Eliminar un producto por su id