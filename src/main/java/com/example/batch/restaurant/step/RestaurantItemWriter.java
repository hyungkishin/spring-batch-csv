package com.example.batch.restaurant.step;

import com.example.batch.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
@Component
public class RestaurantItemWriter implements ItemWriter<Restaurant> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RestaurantItemWriter(@Qualifier("restaurantDataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void write(Chunk<? extends Restaurant> chunk) {
        for (Restaurant restaurant : chunk) {
            jdbcTemplate.update("INSERT INTO restaurant (service_name, service_id, local_code, management_number, permit_date, cancel_permit_date, business_status_code, business_status_name, detailed_business_status_code, detailed_business_status_name, close_date, suspend_start_date, suspend_end_date, reopen_date, phone, area, postal_code, full_address, road_address, road_postal_code, business_name, last_modified, data_update_type, data_update_date, business_type_name, coordinate_x, coordinate_y, hygiene_business_type_name, male_employee_count, female_employee_count, business_area_type_name, grade_type_name, water_supply_type_name, total_employee_count, head_office_employee_count, factory_office_employee_count, factory_sales_employee_count, factory_production_employee_count, building_ownership_type_name, guarantee_amount, monthly_rent_amount, multi_use_facility_yn, total_facility_size, traditional_business_number, traditional_business_main_food, homepage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    restaurant.getServiceName(), restaurant.getServiceId(), restaurant.getLocalCode(), restaurant.getManagementNumber(), restaurant.getPermitDate(), restaurant.getCancelPermitDate(), restaurant.getBusinessStatusCode(), restaurant.getBusinessStatusName(), restaurant.getDetailedBusinessStatusCode(), restaurant.getDetailedBusinessStatusName(), restaurant.getCloseDate(), restaurant.getSuspendStartDate(), restaurant.getSuspendEndDate(), restaurant.getReopenDate(), restaurant.getPhone(), restaurant.getArea(), restaurant.getPostalCode(), restaurant.getFullAddress(), restaurant.getRoadAddress(), restaurant.getRoadPostalCode(), restaurant.getBusinessName(), restaurant.getLastModified(), restaurant.getDataUpdateType(), restaurant.getDataUpdateDate(), restaurant.getBusinessTypeName(), restaurant.getCoordinateX(), restaurant.getCoordinateY(), restaurant.getHygieneBusinessTypeName(), restaurant.getMaleEmployeeCount(), restaurant.getFemaleEmployeeCount(), restaurant.getBusinessAreaTypeName(), restaurant.getGradeTypeName(), restaurant.getWaterSupplyTypeName(), restaurant.getTotalEmployeeCount(), restaurant.getHeadOfficeEmployeeCount(), restaurant.getFactoryOfficeEmployeeCount(), restaurant.getFactorySalesEmployeeCount(), restaurant.getFactoryProductionEmployeeCount(), restaurant.getBuildingOwnershipTypeName(), restaurant.getGuaranteeAmount(), restaurant.getMonthlyRentAmount(), restaurant.getMultiUseFacilityYn(), restaurant.getTotalFacilitySize(), restaurant.getTraditionalBusinessNumber(), restaurant.getTraditionalBusinessMainFood(), restaurant.getHomepage());
        }
    }
}