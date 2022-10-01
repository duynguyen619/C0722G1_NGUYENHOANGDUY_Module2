package ss17_regex.validate_classname;

public class ValidateClassname {
    private static final String CLASSNAME_REGEX = "[CAP][0-9]{4}[GHIKLM]";
    public static boolean validate(String regex){
        return regex.matches(CLASSNAME_REGEX);
    }
    public static void main(String[] args) {
        String str1 = "M0318G";
        String str2 = "C0318G";
        System.out.println(validate(str1));
        System.out.println(validate(str2));
    }
}
