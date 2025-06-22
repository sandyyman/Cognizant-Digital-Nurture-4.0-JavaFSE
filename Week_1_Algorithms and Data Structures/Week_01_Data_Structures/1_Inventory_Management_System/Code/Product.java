import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product already exists!");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product added!");
        }
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product deleted!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void viewInventory() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Mouse", 25, 299.99);
        Product p2 = new Product(102, "Keyboard", 15, 499.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.updateProduct(101, 30, 279.99);
        inventory.deleteProduct(102);

        inventory.viewInventory();
    }
}
