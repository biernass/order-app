package pl.mb.soft.orderapp.dto;

public class CustomerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String customerType;

    private String login;

    private String password;

    public CustomerDto(){}

    public CustomerDto(Long id, String firstName, String lastName, String email,
                       String customerType, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerType = customerType;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
