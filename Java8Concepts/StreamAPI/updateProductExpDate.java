package StreamAPI;
import java.time.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class updateProductExpDate 
{
    public static void main(String[] args)
    {
        List<Product> list;
        Scanner sc;
        int id;String name;
        try
        {   
            list=new LinkedList<>();
            sc=new Scanner(System.in).useDelimiter("\n");
            for(int i=0;i<3;i++)
            {
                System.out.println("Enter product ID : ");
                id=sc.nextInt();
                System.out.println("Enter product NAME : ");
                name=sc.next();
                System.out.println("Enter Expiry year, month and date ( YYYY MM DD ) : ");
                list.add(new Product(id,name,LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt())));
            }
            list.stream().filter(product->product.productExpDate.isBefore(LocalDate.now())).forEach(product->{
                LocalDate date=product.productExpDate;
                product.productExpDate=date.plusDays(6);
            });
            list.forEach(product->{
                System.out.println(product.productID+" "+product.productName+" "+product.productExpDate);
            });
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
