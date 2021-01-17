public final class ValidateUtil {
    public static boolean isNotLegal(
            String lastName,
            String firstName,
            String gender,
            String dateOfBirth,
            String contactTelephoneNumber,
            String membershipType,
            String dateOfStartingMembership,
            String membershipDuration,
            String responsor

    ) {
        if (!membershipType.equals("Visitor")) {
            if (!DateUtil.isLegal(dateOfBirth) || !DateUtil.isLegal((dateOfStartingMembership)) || lastName.equals("") || firstName.equals("") || contactTelephoneNumber.equals("")
                    || gender.equals(Tips.PLEASE_SELECT) || membershipType.equals(Tips.PLEASE_SELECT) || membershipDuration.equals(Tips.PLEASE_SELECT)) {
                return true;

            } else {
                return membershipType.equals("Famliy Member") && responsor == null;
            }
        }
        return false;
    }

    public static boolean isUnder12(String memberType, String age) {
        if (memberType.equals("") || age.equals("")) {
            return false;
        }
        return memberType.equals("Visitor") && Integer.parseInt(age) < 12;
    }

    public static boolean isAbove18(String memberType, String age) {
        if (memberType.equals("") || age.equals("")) {
            return false;
        }
        if (!memberType.equals("Visitor")) {
            return Integer.parseInt(age) >= 18;
        }
        return true;
    }
}
