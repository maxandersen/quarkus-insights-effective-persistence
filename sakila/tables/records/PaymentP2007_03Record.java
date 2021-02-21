/*
 * This file is generated by jOOQ.
 */
package sakila.tables.records;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.TableRecordImpl;

import sakila.tables.PaymentP2007_03;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PaymentP2007_03Record extends TableRecordImpl<PaymentP2007_03Record> implements Record6<Integer, Short, Short, Integer, BigDecimal, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.payment_p2007_03.payment_id</code>.
     */
    public void setPaymentId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.payment_p2007_03.payment_id</code>.
     */
    public Integer getPaymentId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.payment_p2007_03.customer_id</code>.
     */
    public void setCustomerId(Short value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.payment_p2007_03.customer_id</code>.
     */
    public Short getCustomerId() {
        return (Short) get(1);
    }

    /**
     * Setter for <code>public.payment_p2007_03.staff_id</code>.
     */
    public void setStaffId(Short value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.payment_p2007_03.staff_id</code>.
     */
    public Short getStaffId() {
        return (Short) get(2);
    }

    /**
     * Setter for <code>public.payment_p2007_03.rental_id</code>.
     */
    public void setRentalId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.payment_p2007_03.rental_id</code>.
     */
    public Integer getRentalId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.payment_p2007_03.amount</code>.
     */
    public void setAmount(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.payment_p2007_03.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>public.payment_p2007_03.payment_date</code>.
     */
    public void setPaymentDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.payment_p2007_03.payment_date</code>.
     */
    public LocalDateTime getPaymentDate() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Short, Short, Integer, BigDecimal, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Short, Short, Integer, BigDecimal, LocalDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return PaymentP2007_03.PAYMENT_P2007_03.PAYMENT_ID;
    }

    @Override
    public Field<Short> field2() {
        return PaymentP2007_03.PAYMENT_P2007_03.CUSTOMER_ID;
    }

    @Override
    public Field<Short> field3() {
        return PaymentP2007_03.PAYMENT_P2007_03.STAFF_ID;
    }

    @Override
    public Field<Integer> field4() {
        return PaymentP2007_03.PAYMENT_P2007_03.RENTAL_ID;
    }

    @Override
    public Field<BigDecimal> field5() {
        return PaymentP2007_03.PAYMENT_P2007_03.AMOUNT;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return PaymentP2007_03.PAYMENT_P2007_03.PAYMENT_DATE;
    }

    @Override
    public Integer component1() {
        return getPaymentId();
    }

    @Override
    public Short component2() {
        return getCustomerId();
    }

    @Override
    public Short component3() {
        return getStaffId();
    }

    @Override
    public Integer component4() {
        return getRentalId();
    }

    @Override
    public BigDecimal component5() {
        return getAmount();
    }

    @Override
    public LocalDateTime component6() {
        return getPaymentDate();
    }

    @Override
    public Integer value1() {
        return getPaymentId();
    }

    @Override
    public Short value2() {
        return getCustomerId();
    }

    @Override
    public Short value3() {
        return getStaffId();
    }

    @Override
    public Integer value4() {
        return getRentalId();
    }

    @Override
    public BigDecimal value5() {
        return getAmount();
    }

    @Override
    public LocalDateTime value6() {
        return getPaymentDate();
    }

    @Override
    public PaymentP2007_03Record value1(Integer value) {
        setPaymentId(value);
        return this;
    }

    @Override
    public PaymentP2007_03Record value2(Short value) {
        setCustomerId(value);
        return this;
    }

    @Override
    public PaymentP2007_03Record value3(Short value) {
        setStaffId(value);
        return this;
    }

    @Override
    public PaymentP2007_03Record value4(Integer value) {
        setRentalId(value);
        return this;
    }

    @Override
    public PaymentP2007_03Record value5(BigDecimal value) {
        setAmount(value);
        return this;
    }

    @Override
    public PaymentP2007_03Record value6(LocalDateTime value) {
        setPaymentDate(value);
        return this;
    }

    @Override
    public PaymentP2007_03Record values(Integer value1, Short value2, Short value3, Integer value4, BigDecimal value5, LocalDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PaymentP2007_03Record
     */
    public PaymentP2007_03Record() {
        super(PaymentP2007_03.PAYMENT_P2007_03);
    }

    /**
     * Create a detached, initialised PaymentP2007_03Record
     */
    public PaymentP2007_03Record(Integer paymentId, Short customerId, Short staffId, Integer rentalId, BigDecimal amount, LocalDateTime paymentDate) {
        super(PaymentP2007_03.PAYMENT_P2007_03);

        setPaymentId(paymentId);
        setCustomerId(customerId);
        setStaffId(staffId);
        setRentalId(rentalId);
        setAmount(amount);
        setPaymentDate(paymentDate);
    }
}
