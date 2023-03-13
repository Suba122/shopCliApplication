package Database;

public class sqlQuery {
    public static String category_table = """
                    CREATE TABLE Category (
                      category_id INT PRIMARY KEY,
                      category_name VARCHAR(255)
                    );
                    """;
    public static String product_table = """
                    CREATE TABLE Product (
                      product_id INT PRIMARY KEY,
                      category_id INT,
                      product_name VARCHAR(255),
                      price DECIMAL(10, 2),
                      FOREIGN KEY (category_id) REFERENCES Category(category_id)
                    );
                    """;
    public static String purchase_table = """
                    CREATE TABLE Purchase (
                      purchase_id INT PRIMARY KEY,
                      product_id INT,
                      purchase_quantity INT,
                      purchase_cost DECIMAL(10, 2),
                      purchase_date DATE NOT NULL DEFAULT CURRENT_DATE,
                      FOREIGN KEY (product_id) REFERENCES Product(product_id)
                    );
                    """;
    public static String sales_table = """
                    CREATE TABLE Sales (
                      sales_id INT PRIMARY KEY,
                      product_id INT,
                      sales_quantity INT,
                      sales_price DECIMAL(10, 2),
                      sales_date DATE NOT NULL DEFAULT CURRENT_DATE,
                      FOREIGN KEY (product_id) REFERENCES Product(product_id)
                    );
                    """;
}
