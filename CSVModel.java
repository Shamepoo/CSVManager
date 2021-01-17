public class CSVModel {
    private String id;
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String gender;
    private String postAddress;
    private String contactTelephoneNumber;
    private String healthCondition;
    private String allergyInformation;
    private String membershipType;
    private String dateOfStartingMembership;
    private String membershipDuration;
    private String dateOfEndingMembership;
    private String amountOfFeePaid;
    private String age;
    private String responser;

    public String getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(String membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    public String getResponser() {
        return responser;
    }

    public void setResponser(String responser) {
        this.responser = responser;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.age = DateUtil.calculateAgeByDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getContactTelephoneNumber() {
        return contactTelephoneNumber;
    }

    public void setContactTelephoneNumber(String contactTelephoneNumber) {
        this.contactTelephoneNumber = contactTelephoneNumber;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getAllergyInformation() {
        return allergyInformation;
    }

    public void setAllergyInformation(String allergyInformation) {
        this.allergyInformation = allergyInformation;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getDateOfStartingMembership() {
        return dateOfStartingMembership;
    }

    public void setDateOfStartingMembership(String dateOfStartingMembership) {
        this.dateOfStartingMembership = dateOfStartingMembership;
    }

    public String getDateOfEndingMembership() {
        return dateOfEndingMembership;
    }

    public void setDateOfEndingMembership(String dateOfEndingMembership) {
        this.dateOfEndingMembership = dateOfEndingMembership;
    }


    public String getAmountOfFeePaid() {
        return amountOfFeePaid;
    }

    public void setAmountOfFeePaid(String amountOfFeePaid) {
        this.amountOfFeePaid = amountOfFeePaid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return id + "," + lastName + "," + firstName + "," + dateOfBirth + "," + gender + "," + postAddress + "," +
                contactTelephoneNumber + "," + healthCondition + "," + allergyInformation + "," + membershipType + "," +
                dateOfStartingMembership + "," + membershipDuration + "," + dateOfEndingMembership + "," + amountOfFeePaid + "," + age + "," +
                responser + "\n";
    }
}
