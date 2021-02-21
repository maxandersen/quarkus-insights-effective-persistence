/*
 * This file is generated by jOOQ.
 */
package sakila.tables;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Check;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import sakila.Indexes;
import sakila.Keys;
import sakila.Public;
import sakila.tables.records.PaymentP2007_02Record;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PaymentP2007_02 extends TableImpl<PaymentP2007_02Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.payment_p2007_02</code>
     */
    public static final PaymentP2007_02 PAYMENT_P2007_02 = new PaymentP2007_02();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PaymentP2007_02Record> getRecordType() {
        return PaymentP2007_02Record.class;
    }

    /**
     * The column <code>public.payment_p2007_02.payment_id</code>.
     */
    public final TableField<PaymentP2007_02Record, Integer> PAYMENT_ID = createField(DSL.name("payment_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.payment_p2007_02.customer_id</code>.
     */
    public final TableField<PaymentP2007_02Record, Short> CUSTOMER_ID = createField(DSL.name("customer_id"), SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_02.staff_id</code>.
     */
    public final TableField<PaymentP2007_02Record, Short> STAFF_ID = createField(DSL.name("staff_id"), SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_02.rental_id</code>.
     */
    public final TableField<PaymentP2007_02Record, Integer> RENTAL_ID = createField(DSL.name("rental_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_02.amount</code>.
     */
    public final TableField<PaymentP2007_02Record, BigDecimal> AMOUNT = createField(DSL.name("amount"), SQLDataType.NUMERIC(5, 2).nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_02.payment_date</code>.
     */
    public final TableField<PaymentP2007_02Record, LocalDateTime> PAYMENT_DATE = createField(DSL.name("payment_date"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    private PaymentP2007_02(Name alias, Table<PaymentP2007_02Record> aliased) {
        this(alias, aliased, null);
    }

    private PaymentP2007_02(Name alias, Table<PaymentP2007_02Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.payment_p2007_02</code> table reference
     */
    public PaymentP2007_02(String alias) {
        this(DSL.name(alias), PAYMENT_P2007_02);
    }

    /**
     * Create an aliased <code>public.payment_p2007_02</code> table reference
     */
    public PaymentP2007_02(Name alias) {
        this(alias, PAYMENT_P2007_02);
    }

    /**
     * Create a <code>public.payment_p2007_02</code> table reference
     */
    public PaymentP2007_02() {
        this(DSL.name("payment_p2007_02"), null);
    }

    public <O extends Record> PaymentP2007_02(Table<O> child, ForeignKey<O, PaymentP2007_02Record> key) {
        super(child, key, PAYMENT_P2007_02);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IDX_FK_PAYMENT_P2007_02_CUSTOMER_ID, Indexes.IDX_FK_PAYMENT_P2007_02_STAFF_ID);
    }

    @Override
    public Identity<PaymentP2007_02Record, Integer> getIdentity() {
        return (Identity<PaymentP2007_02Record, Integer>) super.getIdentity();
    }

    @Override
    public List<ForeignKey<PaymentP2007_02Record, ?>> getReferences() {
        return Arrays.<ForeignKey<PaymentP2007_02Record, ?>>asList(Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_CUSTOMER_ID_FKEY, Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_STAFF_ID_FKEY, Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_RENTAL_ID_FKEY);
    }

    private transient Customer _customer;
    private transient Staff _staff;
    private transient Rental _rental;

    public Customer customer() {
        if (_customer == null)
            _customer = new Customer(this, Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_CUSTOMER_ID_FKEY);

        return _customer;
    }

    public Staff staff() {
        if (_staff == null)
            _staff = new Staff(this, Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_STAFF_ID_FKEY);

        return _staff;
    }

    public Rental rental() {
        if (_rental == null)
            _rental = new Rental(this, Keys.PAYMENT_P2007_02__PAYMENT_P2007_02_RENTAL_ID_FKEY);

        return _rental;
    }

    @Override
    public List<Check<PaymentP2007_02Record>> getChecks() {
        return Arrays.<Check<PaymentP2007_02Record>>asList(
              Internal.createCheck(this, DSL.name("payment_p2007_02_payment_date_check"), "(((payment_date >= '2007-02-01 00:00:00'::timestamp without time zone) AND (payment_date < '2007-03-01 00:00:00'::timestamp without time zone)))", true)
        );
    }

    @Override
    public PaymentP2007_02 as(String alias) {
        return new PaymentP2007_02(DSL.name(alias), this);
    }

    @Override
    public PaymentP2007_02 as(Name alias) {
        return new PaymentP2007_02(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PaymentP2007_02 rename(String name) {
        return new PaymentP2007_02(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PaymentP2007_02 rename(Name name) {
        return new PaymentP2007_02(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Short, Short, Integer, BigDecimal, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
