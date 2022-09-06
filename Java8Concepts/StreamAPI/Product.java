package StreamAPI;
import java.time.LocalDate;
class Product
{
    int productID;
    String productName;
    LocalDate productExpDate;
    public Product(int productID, String productName, LocalDate productExpDate) {
        this.productID = productID;
        this.productName = productName;
        this.productExpDate = productExpDate;
    }
}
