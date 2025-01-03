import java.util.Scanner;

public class zom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: User Login
        String[] usernames = {"user1", "user2", "user3"};
        String[] passwords = {"pass1", "pass2", "pass3"};

        System.out.println("Welcome to Zomato App");
        int userIndex = -1;
        float discount = 0.0f;

        while (userIndex == -1) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i].equals(enteredUsername) && passwords[i].equals(enteredPassword)) {
                    userIndex = i;
                    break;
                }
            }

            if (userIndex == -1) {
                System.out.println("Invalid credentials! Try again or enter 0 to exit.");
                System.out.print("Enter 0 to exit or any other key to retry: ");
                String exitChoice = scanner.nextLine();
                if (exitChoice.equals("0")) {
                    return;
                }
            }
        }

        System.out.println("Login successful! Welcome, " + usernames[userIndex] + "\n");

        // Step 2: Hotel Selection
        System.out.println("Choose a hotel:");
        System.out.println("1. Annapoorna\n2. KFG\n3. McDonald's\n4. Saravana Bhavan\n5. Domino's");
        System.out.print("Enter your choice (1-5): ");
        int hotelChoice = scanner.nextInt();
        String hotelName = "";

        switch (hotelChoice) {
            case 1:
                hotelName = "Annapoorna";
                break;
            case 2:
                hotelName = "KFG";
                break;
            case 3:
                hotelName = "McDonald's";
                break;
            case 4:
                hotelName = "Saravana Bhavan";
                break;
            case 5:
                hotelName = "Domino's";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Annapoorna.");
                hotelName = "Annapoorna";
        }

        // Step 3: Food Selection
        String[] dishes = new String[10];
        int[] quantities = new int[10];
        int[] prices = new int[10];
        int orderCount = 0;

        int foodChoice = -1; // Initialize properly to avoid uninitialized variable error
        while (foodChoice != 0) {
            System.out.println("Choose the food you like (Enter 0 to exit):");
            System.out.println("1. Dosa - Rs. 50\n2. Idly - Rs. 30\n3. Parotta - Rs. 40\n4. Chapatti - Rs. 35");
            System.out.print("Enter your choice (0-4): ");
            foodChoice = scanner.nextInt();

            if (foodChoice == 0) break;

            String dish = "";
            int price = 0;

            switch (foodChoice) {
                case 1:
                    dish = "Dosa";
                    price = 50;
                    break;
                case 2:
                    dish = "Idly";
                    price = 30;
                    break;
                case 3:
                    dish = "Parotta";
                    price = 40;
                    break;
                case 4:
                    dish = "Chapatti";
                    price = 35;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            dishes[orderCount] = dish;
            quantities[orderCount] = quantity;
            prices[orderCount] = price * quantity;
            orderCount++;
        }

        // Step 4: Coupon Code
        String[] couponCodes = {"X32WD", "FSDFB423", "SBI4R3", "DISCOUNT7"};
        System.out.print("Do you have a coupon code? (yes/no): ");
        String hasCoupon = scanner.next();

        int temp1;
        boolean validCoupon = false; // Declare here to make it accessible throughout the method

        if (hasCoupon.equals("yes")) {
            System.out.print("Enter the coupon code: ");
            String enteredCoupon = scanner.next();

            for (temp1 = 0; temp1 < couponCodes.length; temp1++) {
                if (enteredCoupon.equals(couponCodes[temp1])) {
                    validCoupon = true;
                    discount = 7.0f;
                    System.out.println("Coupon code accepted.");
                    break;
                }
            }

            if (!validCoupon) {
                System.out.println("Invalid coupon code.");
            }
        }

        // Final Bill Display
        System.out.println("\nFinal Bill:");
        System.out.println("Order ID: " + ((int) (Math.random() * 10000) + 1));
        System.out.println("User ID: " + usernames[userIndex]);
        System.out.println("Hotel: " + hotelName);
        System.out.println("\nDish\tQty\tPrice");

        int totalCost = 0;
        for (int j = 0; j < orderCount; j++) {
            System.out.println(dishes[j] + "\t" + quantities[j] + "\t" + prices[j]);
            totalCost += prices[j];
        }

        if (validCoupon) {
            float discountAmount = (totalCost * discount) / 100;
            totalCost -= discountAmount;
            System.out.println("Discount Applied: Rs. " + discountAmount + " (" + discount + "%)");
        }

        System.out.println("\nTotal:\t\tRs. " + totalCost);
        System.out.println("\nThank you for using Zomato App. Goodbye!");

        scanner.close();
    }
}
