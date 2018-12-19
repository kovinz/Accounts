package com.company.Clients;

public class Client {
  private final String firstName;
  private final String secondName;
  private final String address;
  private final String passportId;

  public Client(String firstName, String secondName, String address, String passportId) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.address = address;
    this.passportId = passportId;
  }

  private Client(Builder builder) {
    firstName = builder.firstName;
    secondName = builder.secondName;
    address = builder.address;
    passportId = builder.passportId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getAddress() {
    return address;
  }

  public String getPassportId() {
    return passportId;
  }

  @Override
  public String toString() {
    return "Clients{" +
            "firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", address='" + address + '\'' +
            ", passportId='" + passportId + '\'' +
            '}';
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String firstName;
    private String secondName;
    private String address;
    private String passportId;

    private Builder() {
    }

    public Builder withFirstName(String val) {
      firstName = val;
      return this;
    }

    public Builder withSecondName(String val) {
      secondName = val;
      return this;
    }

    public Builder withAddress(String val) {
      address = val;
      return this;
    }

    public Builder withPassportId(String val) {
      passportId = val;
      return this;
    }

    public Client build() {
      return new Client(this);
    }
  }
}
