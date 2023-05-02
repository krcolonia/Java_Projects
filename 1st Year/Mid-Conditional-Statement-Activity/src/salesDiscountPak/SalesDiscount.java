package salesDiscountPak;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalesDiscount {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		DecimalFormat priceFormat=new DecimalFormat("###,###,###.00");
		
		String productName;
		double productPrice=0, discountPrice=0, netPrice=0;
		
		System.out.print("Enter product: ");
		productName = input.nextLine();
		
		System.out.print("Enter price: ");
		productPrice = input.nextDouble();
		
		System.out.println("");
		
		if((productPrice>0)&&(productPrice<=10000))
		{
			discountPrice=productPrice*0.00;
			netPrice=productPrice-discountPrice;
			
			System.out.println("Price of " + productName + " is " + priceFormat.format(productPrice));
			System.out.println("Discount is " + priceFormat.format(discountPrice));
			System.out.println("Net Price is " + priceFormat.format(netPrice));
		}
		else if((productPrice>10000)&&(productPrice<=20000))
		{
			discountPrice=productPrice*0.05;
			netPrice=productPrice-discountPrice;
			
			System.out.println("Price of " + productName + " is " + priceFormat.format(productPrice));
			System.out.println("Discount is " + priceFormat.format(discountPrice));
			System.out.println("Net Price is " + priceFormat.format(netPrice));
		}
		else if((productPrice>20000)&&(productPrice<=50000))
		{
			discountPrice=productPrice*0.10;
			netPrice=productPrice-discountPrice;
			
			System.out.println("Price of " + productName + " is " + priceFormat.format(productPrice));
			System.out.println("Discount is " + priceFormat.format(discountPrice));
			System.out.println("Net Price is " + priceFormat.format(netPrice));
		}
		else if((productPrice>50000)&&(productPrice<=100000))
		{
			discountPrice=productPrice*0.15;
			netPrice=productPrice-discountPrice;
			
			System.out.println("Price of " + productName + " is " + priceFormat.format(productPrice));
			System.out.println("Discount is " + priceFormat.format(discountPrice));
			System.out.println("Net Price is " + priceFormat.format(netPrice));
		}
		else
		{
			discountPrice=productPrice*0.20;
			netPrice=productPrice-discountPrice;
			
			System.out.println("Price of " + productName + " is " + priceFormat.format(productPrice));
			System.out.println("Discount is " + priceFormat.format(discountPrice));
			System.out.println("Net Price is " + priceFormat.format(netPrice));
		}
	}

}
