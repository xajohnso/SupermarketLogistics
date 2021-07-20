package person;

import java.util.Scanner;

import product.Shelf;

public class Cashier {

	private double cashRegister;
	
	public double getMoney() {
		return cashRegister;
	}
	
	public void addMoney(Shopper shopper, Shelf shelf) {
		double money = shopper.getItems(shelf);
		shopper.removeCash(money);
		cashRegister = cashRegister + money;
		System.out.println("Thank you! Have a good day.");
	}
	
	public void checkOut(Shopper shopper, Shelf shelf, Scanner scanner) {
		boolean em = shopper.getWallet() > shopper.getItems(shelf);
		shopper.printCart();
		System.out.println("Total: $" + shopper.getItems(shelf));
		System.out.println("Would you like to remove anything? 1) Yes 2) No");
		switch(scanner.nextInt()) {
		case 1:
			shopper.removeItems(scanner);
		break;
		
		case 2:
			if (em == true) {
				addMoney(shopper, shelf);
			} else {
				System.out.println("Not enough money. Please remove an item.");
				shopper.removeItems(scanner);
				addMoney(shopper, shelf);
			}
		break;
		
		default:
		break;
		}
	}
}
