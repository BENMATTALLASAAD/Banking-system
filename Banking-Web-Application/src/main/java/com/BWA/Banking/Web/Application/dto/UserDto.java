package com.BWA.Banking.Web.Application.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import com.BWA.Banking.Web.Application.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    
    private Long id;

    private String userFirstname;

    private String userLastname;

    private String email;
    
    private String password;

    private Date birthday;

    private String gender;
    
    private String adress;

    private String phoneNumber;

    private Role role;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
