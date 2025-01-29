public class Company {
    private String companyName;
    private short foundationYear;
    private String address;
    private String founderName;
    private long yearlyRevenueInDollars;
    private String emailAddress;

    public Company(String companyName, short foundationYear, String address, String founderName, long yearlyRevenueInDollars, String emailAddress) {
        this.companyName = companyName;
        this.foundationYear = foundationYear;
        this.address = address;
        this.founderName = founderName;
        this.yearlyRevenueInDollars = yearlyRevenueInDollars;
        this.emailAddress = emailAddress;
    }

    Company(){     }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public short getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(short foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFoundersName() {
        return founderName;
    }

    public void setFoundersName(String founderName) {
        this.founderName = founderName;
    }

    public long getYearlyRevenueInDollars() {
        return yearlyRevenueInDollars;
    }

    public void setYearlyRevenueInDollars(long yearlyRevenueInDollars) {
        this.yearlyRevenueInDollars = yearlyRevenueInDollars;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return  "\ncompanyName = " + companyName +
                "\nfoundationYear = " + foundationYear +
                "\naddress = " + address +
                "\nfoundersName = " + founderName +
                "\nyearlyRevenue = " + yearlyRevenueInDollars +
                "\nemailAddress = " + emailAddress ;
    }
}