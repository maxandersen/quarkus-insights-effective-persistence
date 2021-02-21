/*
 * This file is generated by jOOQ.
 */
package sakila.tables.records;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.TableRecordImpl;

import sakila.tables.RewardsReport;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RewardsReportRecord extends TableRecordImpl<RewardsReportRecord> implements Record10<Integer, Short, String, String, String, Short, Boolean, LocalDate, LocalDateTime, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.rewards_report.customer_id</code>.
     */
    public void setCustomerId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.rewards_report.customer_id</code>.
     */
    public Integer getCustomerId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.rewards_report.store_id</code>.
     */
    public void setStoreId(Short value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.rewards_report.store_id</code>.
     */
    public Short getStoreId() {
        return (Short) get(1);
    }

    /**
     * Setter for <code>public.rewards_report.first_name</code>.
     */
    public void setFirstName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.rewards_report.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.rewards_report.last_name</code>.
     */
    public void setLastName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.rewards_report.last_name</code>.
     */
    public String getLastName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.rewards_report.email</code>.
     */
    public void setEmail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.rewards_report.email</code>.
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.rewards_report.address_id</code>.
     */
    public void setAddressId(Short value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.rewards_report.address_id</code>.
     */
    public Short getAddressId() {
        return (Short) get(5);
    }

    /**
     * Setter for <code>public.rewards_report.activebool</code>.
     */
    public void setActivebool(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.rewards_report.activebool</code>.
     */
    public Boolean getActivebool() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>public.rewards_report.create_date</code>.
     */
    public void setCreateDate(LocalDate value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.rewards_report.create_date</code>.
     */
    public LocalDate getCreateDate() {
        return (LocalDate) get(7);
    }

    /**
     * Setter for <code>public.rewards_report.last_update</code>.
     */
    public void setLastUpdate(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.rewards_report.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>public.rewards_report.active</code>.
     */
    public void setActive(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.rewards_report.active</code>.
     */
    public Integer getActive() {
        return (Integer) get(9);
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, Short, String, String, String, Short, Boolean, LocalDate, LocalDateTime, Integer> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, Short, String, String, String, Short, Boolean, LocalDate, LocalDateTime, Integer> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RewardsReport.REWARDS_REPORT.CUSTOMER_ID;
    }

    @Override
    public Field<Short> field2() {
        return RewardsReport.REWARDS_REPORT.STORE_ID;
    }

    @Override
    public Field<String> field3() {
        return RewardsReport.REWARDS_REPORT.FIRST_NAME;
    }

    @Override
    public Field<String> field4() {
        return RewardsReport.REWARDS_REPORT.LAST_NAME;
    }

    @Override
    public Field<String> field5() {
        return RewardsReport.REWARDS_REPORT.EMAIL;
    }

    @Override
    public Field<Short> field6() {
        return RewardsReport.REWARDS_REPORT.ADDRESS_ID;
    }

    @Override
    public Field<Boolean> field7() {
        return RewardsReport.REWARDS_REPORT.ACTIVEBOOL;
    }

    @Override
    public Field<LocalDate> field8() {
        return RewardsReport.REWARDS_REPORT.CREATE_DATE;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return RewardsReport.REWARDS_REPORT.LAST_UPDATE;
    }

    @Override
    public Field<Integer> field10() {
        return RewardsReport.REWARDS_REPORT.ACTIVE;
    }

    @Override
    public Integer component1() {
        return getCustomerId();
    }

    @Override
    public Short component2() {
        return getStoreId();
    }

    @Override
    public String component3() {
        return getFirstName();
    }

    @Override
    public String component4() {
        return getLastName();
    }

    @Override
    public String component5() {
        return getEmail();
    }

    @Override
    public Short component6() {
        return getAddressId();
    }

    @Override
    public Boolean component7() {
        return getActivebool();
    }

    @Override
    public LocalDate component8() {
        return getCreateDate();
    }

    @Override
    public LocalDateTime component9() {
        return getLastUpdate();
    }

    @Override
    public Integer component10() {
        return getActive();
    }

    @Override
    public Integer value1() {
        return getCustomerId();
    }

    @Override
    public Short value2() {
        return getStoreId();
    }

    @Override
    public String value3() {
        return getFirstName();
    }

    @Override
    public String value4() {
        return getLastName();
    }

    @Override
    public String value5() {
        return getEmail();
    }

    @Override
    public Short value6() {
        return getAddressId();
    }

    @Override
    public Boolean value7() {
        return getActivebool();
    }

    @Override
    public LocalDate value8() {
        return getCreateDate();
    }

    @Override
    public LocalDateTime value9() {
        return getLastUpdate();
    }

    @Override
    public Integer value10() {
        return getActive();
    }

    @Override
    public RewardsReportRecord value1(Integer value) {
        setCustomerId(value);
        return this;
    }

    @Override
    public RewardsReportRecord value2(Short value) {
        setStoreId(value);
        return this;
    }

    @Override
    public RewardsReportRecord value3(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public RewardsReportRecord value4(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public RewardsReportRecord value5(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public RewardsReportRecord value6(Short value) {
        setAddressId(value);
        return this;
    }

    @Override
    public RewardsReportRecord value7(Boolean value) {
        setActivebool(value);
        return this;
    }

    @Override
    public RewardsReportRecord value8(LocalDate value) {
        setCreateDate(value);
        return this;
    }

    @Override
    public RewardsReportRecord value9(LocalDateTime value) {
        setLastUpdate(value);
        return this;
    }

    @Override
    public RewardsReportRecord value10(Integer value) {
        setActive(value);
        return this;
    }

    @Override
    public RewardsReportRecord values(Integer value1, Short value2, String value3, String value4, String value5, Short value6, Boolean value7, LocalDate value8, LocalDateTime value9, Integer value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RewardsReportRecord
     */
    public RewardsReportRecord() {
        super(RewardsReport.REWARDS_REPORT);
    }

    /**
     * Create a detached, initialised RewardsReportRecord
     */
    public RewardsReportRecord(Integer customerId, Short storeId, String firstName, String lastName, String email, Short addressId, Boolean activebool, LocalDate createDate, LocalDateTime lastUpdate, Integer active) {
        super(RewardsReport.REWARDS_REPORT);

        setCustomerId(customerId);
        setStoreId(storeId);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAddressId(addressId);
        setActivebool(activebool);
        setCreateDate(createDate);
        setLastUpdate(lastUpdate);
        setActive(active);
    }
}
