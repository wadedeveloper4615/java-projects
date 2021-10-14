package com.wade.homepage.dto;

import java.util.HashSet;
import java.util.Objects;

import com.wade.homepage.model.Role;
import com.wade.homepage.model.User;

public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;
    private Role role;

    public UserRegistrationDto() {
        super();
    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password, String passwordConfirm, Role role) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserRegistrationDto other = (UserRegistrationDto) obj;
        return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password) && Objects.equals(passwordConfirm, other.passwordConfirm) && Objects.equals(role, other.role);
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public Role getRole() {
        return role;
    }

    public User getUser() {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setPasswordConfirm(passwordConfirm);
        HashSet<Role> hashSet = new HashSet<>();
        hashSet.add(role);
        user.setRoles(hashSet);
        return user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, password, passwordConfirm, role);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", role=" + role + "]";
    }
}
