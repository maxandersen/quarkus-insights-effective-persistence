/*
 * This file is generated by jOOQ.
 */
package sakila.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import sakila.tables.City;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CityRecord extends UpdatableRecordImpl<CityRecord> implements Record4<Integer, String, Short, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.city.city_id</code>.
     */
    public void setCityId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.city.city_id</code>.
     */
    public Integer getCityId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.city.city</code>.
     */
    public void setCity(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.city.city</code>.
     */
    public String getCity() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.city.country_id</code>.
     */
    public void setCountryId(Short value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.city.country_id</code>.
     */
    public Short getCountryId() {
        return (Short) get(2);
    }

    /**
     * Setter for <code>public.city.last_update</code>.
     */
    public void setLastUpdate(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.city.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Short, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Short, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return City.CITY.CITY_ID;
    }

    @Override
    public Field<String> field2() {
        return City.CITY.CITY_;
    }

    @Override
    public Field<Short> field3() {
        return City.CITY.COUNTRY_ID;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return City.CITY.LAST_UPDATE;
    }

    @Override
    public Integer component1() {
        return getCityId();
    }

    @Override
    public String component2() {
        return getCity();
    }

    @Override
    public Short component3() {
        return getCountryId();
    }

    @Override
    public LocalDateTime component4() {
        return getLastUpdate();
    }

    @Override
    public Integer value1() {
        return getCityId();
    }

    @Override
    public String value2() {
        return getCity();
    }

    @Override
    public Short value3() {
        return getCountryId();
    }

    @Override
    public LocalDateTime value4() {
        return getLastUpdate();
    }

    @Override
    public CityRecord value1(Integer value) {
        setCityId(value);
        return this;
    }

    @Override
    public CityRecord value2(String value) {
        setCity(value);
        return this;
    }

    @Override
    public CityRecord value3(Short value) {
        setCountryId(value);
        return this;
    }

    @Override
    public CityRecord value4(LocalDateTime value) {
        setLastUpdate(value);
        return this;
    }

    @Override
    public CityRecord values(Integer value1, String value2, Short value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CityRecord
     */
    public CityRecord() {
        super(City.CITY);
    }

    /**
     * Create a detached, initialised CityRecord
     */
    public CityRecord(Integer cityId, String city, Short countryId, LocalDateTime lastUpdate) {
        super(City.CITY);

        setCityId(cityId);
        setCity(city);
        setCountryId(countryId);
        setLastUpdate(lastUpdate);
    }
}
