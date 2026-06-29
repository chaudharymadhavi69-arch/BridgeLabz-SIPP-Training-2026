interface CouponValidator {   // no 'public'
    boolean validateCoupon(String code);
    static boolean isLengthValid(String code) {
        return code.length() >= 5 && code.length() <= 10;
    }
}
class ShoppingCart implements CouponValidator {
    
    public boolean validateCoupon(String code) {
        return code.startsWith("SAVE") && CouponValidator.isLengthValid(code);
    }
}
public class Main {
    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "DISCOUNT50", "SAVE2026", "HELLO", "SAVE"};
        ShoppingCart cart = new ShoppingCart();
        for (String code : coupons) {
            if (cart.validateCoupon(code)) {
                System.out.println(code + " → Valid");
            } else {
                System.out.println(code + " → Invalid");
            }
        }
    }
}
