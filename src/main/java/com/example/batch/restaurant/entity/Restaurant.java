package com.example.batch.restaurant.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Restaurant {

    private Long id;
    private String serviceName;
    private String serviceId;
    private String localCode;
    private String managementNumber;
    private LocalDate permitDate;
    private LocalDate cancelPermitDate;
    private String businessStatusCode;
    private String businessStatusName;
    private String detailedBusinessStatusCode;
    private String detailedBusinessStatusName;
    private LocalDate closeDate;
    private LocalDate suspendStartDate;
    private LocalDate suspendEndDate;
    private LocalDate reopenDate;
    private String phone;
    private Double area;
    private String postalCode;
    private String fullAddress;
    private String roadAddress;
    private String roadPostalCode;
    private String businessName;
    private LocalDateTime lastModified;
    private String dataUpdateType;
    private LocalDateTime dataUpdateDate;
    private String businessTypeName;
    private Double coordinateX;
    private Double coordinateY;
    private String hygieneBusinessTypeName;
    private Integer maleEmployeeCount;
    private Integer femaleEmployeeCount;
    private String businessAreaTypeName;
    private String gradeTypeName;
    private String waterSupplyTypeName;
    private Integer totalEmployeeCount;
    private Integer headOfficeEmployeeCount;
    private Integer factoryOfficeEmployeeCount;
    private Integer factorySalesEmployeeCount;
    private Integer factoryProductionEmployeeCount;
    private String buildingOwnershipTypeName;
    private Double guaranteeAmount;
    private Double monthlyRentAmount;
    private String multiUseFacilityYn;
    private Double totalFacilitySize;
    private String traditionalBusinessNumber;
    private String traditionalBusinessMainFood;
    private String homepage;

}