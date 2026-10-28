package com.example.myspringbootprojectsession7.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CandidateCreateDTO {

    @NotBlank(message = "fullName không được để trống")
    @Size(min = 5, max = 50, message = "fullName phải có từ 5 đến 50 ký tự")
    private String fullName;

    @NotBlank(message = "email không được để trống")
    @Email(message = "email không đúng định dạng")
    private String email;

    @NotNull(message = "age không được để trống")
    @Min(value = 18, message = "age phải từ 18 tuổi trở lên")
    private Integer age;

    @NotNull(message = "yearsOfExperience không được để trống")
    @Min(value = 0, message = "yearsOfExperience không được âm")
    private Integer yearsOfExperience;

    public CandidateCreateDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
