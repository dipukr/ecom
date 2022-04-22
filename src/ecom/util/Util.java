package ecom.util;

import java.util.List;

import ecom.model.Product;

public class Util {

	public static int getTotalPrice(List<Product> products) {
		int total = 0;
		for (Product product: products)
			total = total + product.getPrice();
		return total;
	}
}
