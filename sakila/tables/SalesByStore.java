/*
 * This file is generated by jOOQ.
 */
package sakila.tables;


import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import sakila.Public;
import sakila.tables.records.SalesByStoreRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SalesByStore extends TableImpl<SalesByStoreRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.sales_by_store</code>
     */
    public static final SalesByStore SALES_BY_STORE = new SalesByStore();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SalesByStoreRecord> getRecordType() {
        return SalesByStoreRecord.class;
    }

    /**
     * The column <code>public.sales_by_store.store</code>.
     */
    public final TableField<SalesByStoreRecord, String> STORE = createField(DSL.name("store"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.sales_by_store.manager</code>.
     */
    public final TableField<SalesByStoreRecord, String> MANAGER = createField(DSL.name("manager"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.sales_by_store.total_sales</code>.
     */
    public final TableField<SalesByStoreRecord, BigDecimal> TOTAL_SALES = createField(DSL.name("total_sales"), SQLDataType.NUMERIC, this, "");

    private SalesByStore(Name alias, Table<SalesByStoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private SalesByStore(Name alias, Table<SalesByStoreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("create view \"sales_by_store\" as  SELECT (((c.city)::text || ','::text) || (cy.country)::text) AS store,\n    (((m.first_name)::text || ' '::text) || (m.last_name)::text) AS manager,\n    sum(p.amount) AS total_sales\n   FROM (((((((payment p\n     JOIN rental r ON ((p.rental_id = r.rental_id)))\n     JOIN inventory i ON ((r.inventory_id = i.inventory_id)))\n     JOIN store s ON ((i.store_id = s.store_id)))\n     JOIN address a ON ((s.address_id = a.address_id)))\n     JOIN city c ON ((a.city_id = c.city_id)))\n     JOIN country cy ON ((c.country_id = cy.country_id)))\n     JOIN staff m ON ((s.manager_staff_id = m.staff_id)))\n  GROUP BY cy.country, c.city, s.store_id, m.first_name, m.last_name\n  ORDER BY cy.country, c.city;"));
    }

    /**
     * Create an aliased <code>public.sales_by_store</code> table reference
     */
    public SalesByStore(String alias) {
        this(DSL.name(alias), SALES_BY_STORE);
    }

    /**
     * Create an aliased <code>public.sales_by_store</code> table reference
     */
    public SalesByStore(Name alias) {
        this(alias, SALES_BY_STORE);
    }

    /**
     * Create a <code>public.sales_by_store</code> table reference
     */
    public SalesByStore() {
        this(DSL.name("sales_by_store"), null);
    }

    public <O extends Record> SalesByStore(Table<O> child, ForeignKey<O, SalesByStoreRecord> key) {
        super(child, key, SALES_BY_STORE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public SalesByStore as(String alias) {
        return new SalesByStore(DSL.name(alias), this);
    }

    @Override
    public SalesByStore as(Name alias) {
        return new SalesByStore(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SalesByStore rename(String name) {
        return new SalesByStore(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SalesByStore rename(Name name) {
        return new SalesByStore(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, BigDecimal> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
