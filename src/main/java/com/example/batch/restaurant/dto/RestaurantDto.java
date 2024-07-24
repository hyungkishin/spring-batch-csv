package com.example.batch.restaurant.dto;

import com.example.batch.restaurant.entity.Restaurant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Optional;

import com.example.batch.restaurant.entity.Restaurant;
import com.example.batch.restaurant.util.StringToTypeConverter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
public class RestaurantDto {

    private String id;
    private String serviceName;
    private String serviceId;
    private String localCode;
    private String managementNumber;
    private String permitDate;
    private String cancelPermitDate;
    private String businessStatusCode;
    private String businessStatusName;
    private String detailedBusinessStatusCode;
    private String detailedBusinessStatusName;
    private String closeDate;
    private String suspendStartDate;
    private String suspendEndDate;
    private String reopenDate;
    private String phone;
    private String area;
    private String postalCode;
    private String fullAddress;
    private String roadAddress;
    private String roadPostalCode;
    private String businessName;
    private String lastModified;
    private String dataUpdateType;
    private String dataUpdateDate;
    private String businessTypeName;
    private String coordinateX;
    private String coordinateY;
    private String hygieneBusinessTypeName;
    private String maleEmployeeCount;
    private String femaleEmployeeCount;
    private String businessAreaTypeName;
    private String gradeTypeName;
    private String waterSupplyTypeName;
    private String totalEmployeeCount;
    private String headOfficeEmployeeCount;
    private String factoryOfficeEmployeeCount;
    private String factorySalesEmployeeCount;
    private String factoryProductionEmployeeCount;
    private String buildingOwnershipTypeName;
    private String guaranteeAmount;
    private String monthlyRentAmount;
    private String multiUseFacilityYn;
    private String totalFacilitySize;
    private String traditionalBusinessNumber;
    private String traditionalBusinessMainFood;
    private String homepage;

    public Restaurant toEntity() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(StringToTypeConverter.parseLong(this.id).orElse(null));
        restaurant.setServiceName(this.serviceName);
        restaurant.setServiceId(this.serviceId);
        restaurant.setLocalCode(this.localCode);
        restaurant.setManagementNumber(this.managementNumber);
        restaurant.setPermitDate(StringToTypeConverter.parseLocalDate(this.permitDate).orElse(null));
        restaurant.setCancelPermitDate(StringToTypeConverter.parseLocalDate(this.cancelPermitDate).orElse(null));
        restaurant.setBusinessStatusCode(this.businessStatusCode);
        restaurant.setBusinessStatusName(this.businessStatusName);
        restaurant.setDetailedBusinessStatusCode(this.detailedBusinessStatusCode);
        restaurant.setDetailedBusinessStatusName(this.detailedBusinessStatusName);
        restaurant.setCloseDate(StringToTypeConverter.parseLocalDate(this.closeDate).orElse(null));
        restaurant.setSuspendStartDate(StringToTypeConverter.parseLocalDate(this.suspendStartDate).orElse(null));
        restaurant.setSuspendEndDate(StringToTypeConverter.parseLocalDate(this.suspendEndDate).orElse(null));
        restaurant.setReopenDate(StringToTypeConverter.parseLocalDate(this.reopenDate).orElse(null));
        restaurant.setPhone(this.phone);
        restaurant.setArea(StringToTypeConverter.parseDouble(this.area).orElse(null));
        restaurant.setPostalCode(this.postalCode);
        restaurant.setFullAddress(this.fullAddress);
        restaurant.setRoadAddress(this.roadAddress);
        restaurant.setRoadPostalCode(this.roadPostalCode);
        restaurant.setBusinessName(this.businessName);
        restaurant.setLastModified(StringToTypeConverter.parseLocalDateTime(this.lastModified).orElse(null));
        restaurant.setDataUpdateType(this.dataUpdateType);
        restaurant.setDataUpdateDate(StringToTypeConverter.parseLocalDateTime(this.dataUpdateDate).orElse(null));
        restaurant.setBusinessTypeName(this.businessTypeName);
        restaurant.setCoordinateX(StringToTypeConverter.parseDouble(this.coordinateX).orElse(null));
        restaurant.setCoordinateY(StringToTypeConverter.parseDouble(this.coordinateY).orElse(null));
        restaurant.setHygieneBusinessTypeName(this.hygieneBusinessTypeName);
        restaurant.setMaleEmployeeCount(StringToTypeConverter.parseInteger(this.maleEmployeeCount).orElse(null));
        restaurant.setFemaleEmployeeCount(StringToTypeConverter.parseInteger(this.femaleEmployeeCount).orElse(null));
        restaurant.setBusinessAreaTypeName(this.businessAreaTypeName);
        restaurant.setGradeTypeName(this.gradeTypeName);
        restaurant.setWaterSupplyTypeName(this.waterSupplyTypeName);
        restaurant.setTotalEmployeeCount(StringToTypeConverter.parseInteger(this.totalEmployeeCount).orElse(null));
        restaurant.setHeadOfficeEmployeeCount(StringToTypeConverter.parseInteger(this.headOfficeEmployeeCount).orElse(null));
        restaurant.setFactoryOfficeEmployeeCount(StringToTypeConverter.parseInteger(this.factoryOfficeEmployeeCount).orElse(null));
        restaurant.setFactorySalesEmployeeCount(StringToTypeConverter.parseInteger(this.factorySalesEmployeeCount).orElse(null));
        restaurant.setFactoryProductionEmployeeCount(StringToTypeConverter.parseInteger(this.factoryProductionEmployeeCount).orElse(null));
        restaurant.setBuildingOwnershipTypeName(this.buildingOwnershipTypeName);
        restaurant.setGuaranteeAmount(StringToTypeConverter.parseDouble(this.guaranteeAmount).orElse(null));
        restaurant.setMonthlyRentAmount(StringToTypeConverter.parseDouble(this.monthlyRentAmount).orElse(null));
        restaurant.setMultiUseFacilityYn(this.multiUseFacilityYn);
        restaurant.setTotalFacilitySize(StringToTypeConverter.parseDouble(this.totalFacilitySize).orElse(null));
        restaurant.setTraditionalBusinessNumber(this.traditionalBusinessNumber);
        restaurant.setTraditionalBusinessMainFood(this.traditionalBusinessMainFood);
        restaurant.setHomepage(this.homepage);
        return restaurant;
    }
}