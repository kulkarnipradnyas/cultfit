package com.authentication.authservice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)

    private String email;
    private String workEmailId;
    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @Column(name = "otp_email")
    private String otpEmail;

    @Column(name = "otp_email_expiry")
    private LocalDateTime otpEmailExpiry;

    @Column(name = "otp_phone")
    private String otpPhone;

    @Column(name = "otp_phone_expiry")
    private LocalDateTime otpPhoneExpiry;

// LAZY = fetch when needed, EAGER = fetch immediately
// CascadeType.ALL- all operation propagation from user to roles
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",
    joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id")// id from role table
    ,inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))//id from user table
    private Set<Role> roles;

}
