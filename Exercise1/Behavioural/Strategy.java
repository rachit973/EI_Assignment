// Strategy Pattern

/**
 * PaymentStrategy interface defines the contract for all payment strategies.
 * This is the core of the Strategy pattern.
 */
interface PaymentStrategy {
    void pay(int amount);
}

/**
 * CreditCardPayment implements the PaymentStrategy for credit card payments.
 */
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

/**
 * PayPalPayment implements the PaymentStrategy for PayPal payments.
 */
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

/**
 * ShoppingCart is the context class that uses the PaymentStrategy.
 * It allows for switching between different payment strategies at runtime.
 */
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    /**
     * Sets the payment strategy to be used.
     * @param paymentStrategy The payment strategy to be used for checkout.
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Processes the checkout using the currently set payment strategy.
     * @param amount The amount to be paid.
     */
    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

/**
 * Strategy class demonstrates the usage of the Strategy pattern.
 */
public class Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Use credit card payment
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(500);

        // Switch to PayPal payment
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(1500);
    }
}
