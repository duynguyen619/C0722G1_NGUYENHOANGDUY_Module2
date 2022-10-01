package ss17_regex.phone_validate;

public class PhoneValidate {
    private static final String PHONENUMBER_REGEX = "^[(][0-9]{2}[)]-[(]0[0-9]{9}[)]$";

    private static boolean validate(String regex) {
        return regex.matches(PHONENUMBER_REGEX);
    }
    public static void main(String[] args) {
        String str1 = "(84)-(0978489648)";
        String str2 = "(a8)-(22222222)";
        System.out.println(validate(str1));
        System.out.println(validate(str2));
    }
}
