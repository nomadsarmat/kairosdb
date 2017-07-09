package org.kairosdb.datastore.h2.orm;

import org.agileclick.genorm.runtime.GenOrmConnection;
import org.agileclick.genorm.runtime.GenOrmConstraint;
import org.agileclick.genorm.runtime.GenOrmException;
import org.agileclick.genorm.runtime.GenOrmFieldMeta;
import org.agileclick.genorm.runtime.GenOrmRecord;
import org.agileclick.genorm.runtime.GenOrmRecordFactory;
import org.agileclick.genorm.runtime.GenOrmRecordKey;
import org.agileclick.genorm.runtime.GenOrmResultSet;
import org.agileclick.genorm.runtime.GenOrmString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has been automatically generated by GenORMous.  This file
 * should not be modified.
 */
public class ServiceIndex_base extends GenOrmRecord
{
    protected static final Logger s_logger = LoggerFactory.getLogger(ServiceIndex.class.getName());

    public static final String COL_SERVICE = "service";
    public static final String COL_SERVICE_KEY = "service_key";
    public static final String COL_KEY = "key";
    public static final String COL_VALUE = "value";

    //Change this value to true to turn on warning messages
    private static final boolean WARNINGS = false;
    private static final String SELECT = "SELECT this.\"service\", this.\"service_key\", this.\"key\", this.\"value\" ";
    private static final String FROM = "FROM service_index this ";
    private static final String WHERE = "WHERE ";
    private static final String KEY_WHERE = "WHERE \"service\" = ? AND \"service_key\" = ? AND \"key\" = ?";

    public static final String TABLE_NAME = "service_index";
    public static final int NUMBER_OF_COLUMNS = 4;


    private static final String s_fieldEscapeString = "\"";

    public static final GenOrmFieldMeta SERVICE_FIELD_META = new GenOrmFieldMeta("service", "string", 0, true, false);
    public static final GenOrmFieldMeta SERVICE_KEY_FIELD_META = new GenOrmFieldMeta("service_key", "string", 1, true, false);
    public static final GenOrmFieldMeta KEY_FIELD_META = new GenOrmFieldMeta("key", "string", 2, true, false);
    public static final GenOrmFieldMeta VALUE_FIELD_META = new GenOrmFieldMeta("value", "string", 3, false, false);


    //===========================================================================
    public static ServiceIndexFactoryImpl factory = new ServiceIndexFactoryImpl();

    public static interface ServiceIndexFactory extends GenOrmRecordFactory
    {
        public boolean delete(String service, String serviceKey, String key);

        public ServiceIndex find(String service, String serviceKey, String key);

        public ServiceIndex findOrCreate(String service, String serviceKey, String key);

        /**
         */
        public ResultSet getKeys(String service, String serviceKey);

        /**
         */
        public ResultSet getKeysLike(String service, String serviceKey, String keyPrefix);
    }

    public static class ServiceIndexFactoryImpl //Inherit interfaces
            implements ServiceIndexFactory
    {
        public static final String CREATE_SQL = "CREATE CACHED TABLE service_index (\n	\"service\" VARCHAR  NOT NULL,\n	\"service_key\" VARCHAR  NOT NULL,\n	\"key\" VARCHAR  NOT NULL,\n	\"value\" VARCHAR  NULL,\n	PRIMARY KEY (\"service\", \"service_key\", \"key\")\n	)";

        private ArrayList<GenOrmFieldMeta> m_fieldMeta;
        private ArrayList<GenOrmConstraint> m_foreignKeyConstraints;

        protected ServiceIndexFactoryImpl()
        {
            m_fieldMeta = new ArrayList<GenOrmFieldMeta>();
            m_fieldMeta.add(SERVICE_FIELD_META);
            m_fieldMeta.add(SERVICE_KEY_FIELD_META);
            m_fieldMeta.add(KEY_FIELD_META);
            m_fieldMeta.add(VALUE_FIELD_META);

            m_foreignKeyConstraints = new ArrayList<GenOrmConstraint>();
        }

        protected ServiceIndex newServiceIndex(java.sql.ResultSet rs)
        {
            ServiceIndex rec = new ServiceIndex();
            ((ServiceIndex_base) rec).initialize(rs);
            return ((ServiceIndex) GenOrmDataSource.getGenOrmConnection().getUniqueRecord(rec));
        }

        //---------------------------------------------------------------------------

        /**
         * Returns a list of the feild meta for the class that this is a factory of
         */
        public List<GenOrmFieldMeta> getFields()
        {
            return (m_fieldMeta);
        }

        //---------------------------------------------------------------------------

        /**
         * Returns a list of foreign key constraints
         */
        public List<GenOrmConstraint> getForeignKeyConstraints()
        {
            return (m_foreignKeyConstraints);
        }

        //---------------------------------------------------------------------------

        /**
         * Returns the SQL create statement for this table
         */
        public String getCreateStatement()
        {
            return (CREATE_SQL);
        }

        //---------------------------------------------------------------------------

        /**
         * Creates a new entry with the specified primary keys.
         */
        public ServiceIndex create(String service, String serviceKey, String key)
        {
            ServiceIndex rec = new ServiceIndex();
            rec.m_isNewRecord = true;

            ((ServiceIndex_base) rec).setService(service);
            ((ServiceIndex_base) rec).setServiceKey(serviceKey);
            ((ServiceIndex_base) rec).setKey(key);


            return ((ServiceIndex) GenOrmDataSource.getGenOrmConnection().getUniqueRecord(rec));
        }
        //---------------------------------------------------------------------------

        /**
         * Creates a new entry that is empty
         */
        public ServiceIndex createRecord()
        {
            ServiceIndex rec = new ServiceIndex();
            rec.m_isNewRecord = true;

            return ((ServiceIndex) GenOrmDataSource.getGenOrmConnection().getUniqueRecord(rec));
        }

        //---------------------------------------------------------------------------

        /**
         * If the table has a primary key that has a key generator this method will
         * return a new table entry with a generated primary key.
         *
         * @return ServiceIndex with generated primary key
         */
        public ServiceIndex createWithGeneratedKey()
        {
            throw new UnsupportedOperationException("ServiceIndex does not support a generated primary key");
        }

        //---------------------------------------------------------------------------

        /**
         * A generic api for finding a record.
         *
         * @param keys This must match the primary key for this record.  If the
         * record has multiple primary keys this parameter must be of type Object[]
         * where each element is the corresponding key.
         * @return ServiceIndex or null if no record is found
         */
        public ServiceIndex findRecord(Object keys)
        {
            Object[] kArr = (Object[]) keys;
            return (find((String) kArr[0], (String) kArr[1], (String) kArr[2]));
        }

        //---------------------------------------------------------------------------

        /**
         * Deletes the record with the specified primary keys.
         * The point of this api is to prevent a hit on the db to see if the record
         * is there.  This call will add a record to the next transaction that is
         * marked for delete.
         *
         * @return Returns true if the record was previous created and existed
         * either in the transaction cache or the db.
         */
        public boolean delete(String service, String serviceKey, String key)
        {
            boolean ret = false;
            ServiceIndex rec = new ServiceIndex();

            ((ServiceIndex_base) rec).initialize(service, serviceKey, key);
            GenOrmConnection con = GenOrmDataSource.getGenOrmConnection();
            ServiceIndex cachedRec = (ServiceIndex) con.getCachedRecord(rec.getRecordKey());

            if (cachedRec != null) {
                ret = true;
                cachedRec.delete();
            }
            else {
                rec = (ServiceIndex) con.getUniqueRecord(rec);  //This adds the record to the cache
                rec.delete();
                ret = rec.flush();
                rec.setIgnored(true); //So the system does not try to delete it again at commmit
            }

            return (ret);
        }

        //---------------------------------------------------------------------------

        /**
         * Find the record with the specified primary keys
         *
         * @return ServiceIndex or null if no record is found
         */
        public ServiceIndex find(String service, String serviceKey, String key)
        {
            ServiceIndex rec = new ServiceIndex();

            //Create temp object and look in cache for it
            ((ServiceIndex_base) rec).initialize(service, serviceKey, key);
            rec = (ServiceIndex) GenOrmDataSource.getGenOrmConnection().getCachedRecord(rec.getRecordKey());

            java.sql.PreparedStatement genorm_statement = null;
            java.sql.ResultSet genorm_rs = null;

            if (rec == null) {
                try {
                    //No cached object so look in db
                    genorm_statement = GenOrmDataSource.prepareStatement(SELECT + FROM + KEY_WHERE);
                    genorm_statement.setString(1, service);
                    genorm_statement.setString(2, serviceKey);
                    genorm_statement.setString(3, key);

                    s_logger.debug(genorm_statement.toString());

                    genorm_rs = genorm_statement.executeQuery();
                    if (genorm_rs.next()) {
                        rec = newServiceIndex(genorm_rs);
                    }
                }
                catch (java.sql.SQLException sqle) {
                    throw new GenOrmException(sqle);
                }
                finally {
                    try {
                        if (genorm_rs != null) {
                            genorm_rs.close();
                        }

                        if (genorm_statement != null) {
                            genorm_statement.close();
                        }
                    }
                    catch (java.sql.SQLException sqle2) {
                        throw new GenOrmException(sqle2);
                    }
                }
            }

            return (rec);
        }

        //---------------------------------------------------------------------------

        /**
         * This is the same as find except if the record returned is null a new one
         * is created with the specified primary keys
         *
         * @return A new or existing record.
         */
        public ServiceIndex findOrCreate(String service, String serviceKey, String key)
        {
            ServiceIndex rec = find(service, serviceKey, key);
            if (rec == null) {
                rec = create(service, serviceKey, key);
            }

            return (rec);
        }

        //---------------------------------------------------------------------------

        /**
         * Convenience method for selecting records.  Ideally this should not be use,
         * instead a custom query for this table should be used.
         *
         * @param where sql where statement.
         */
        public ResultSet select(String where)
        {
            return (select(where, null));
        }

        //---------------------------------------------------------------------------

        /**
         * Convenience method for selecting records.  Ideally this should not be use,
         * instead a custom query for this table should be used.
         *
         * @param where sql where statement.
         * @param orderBy sql order by statement
         */
        public ResultSet select(String where, String orderBy)
        {
            ResultSet rs = null;
            java.sql.Statement stmnt = null;

            try {
                stmnt = GenOrmDataSource.createStatement();
                StringBuilder sb = new StringBuilder();
                sb.append(SELECT);
                sb.append(FROM);
                if (where != null) {
                    sb.append(WHERE);
                    sb.append(where);
                }

                if (orderBy != null) {
                    sb.append(" ");
                    sb.append(orderBy);
                }

                String query = sb.toString();
                rs = new SQLResultSet(stmnt.executeQuery(query), query, stmnt);
            }
            catch (java.sql.SQLException sqle) {
                try {
                    if (stmnt != null) {
                        stmnt.close();
                    }
                }
                catch (java.sql.SQLException sqle2) {
                }

                throw new GenOrmException(sqle);
            }

            return (rs);
        }

        //---------------------------------------------------------------------------

        /**
         */
        public ResultSet getKeys(String service, String serviceKey)
        {
            String query = SELECT + "from service_index this\n				where\n				this.\"service\" = ?\n				and this.\"service_key\" = ?\n				order by this.\"key\" asc";

            java.sql.PreparedStatement genorm_statement = null;

            try {
                genorm_statement = GenOrmDataSource.prepareStatement(query);
                genorm_statement.setString(1, service);
                genorm_statement.setString(2, serviceKey);

                s_logger.debug(genorm_statement.toString());

                ResultSet rs = new SQLResultSet(genorm_statement.executeQuery(), query, genorm_statement);

                return (rs);
            }
            catch (java.sql.SQLException sqle) {
                try {
                    if (genorm_statement != null) {
                        genorm_statement.close();
                    }
                }
                catch (java.sql.SQLException sqle2) {
                }

                if (s_logger.isDebugEnabled()) {
                    sqle.printStackTrace();
                }
                throw new GenOrmException(sqle);
            }
        }

        //---------------------------------------------------------------------------

        /**
         */
        public ResultSet getKeysLike(String service, String serviceKey, String keyPrefix)
        {
            String query = SELECT + "from service_index this\n				where\n				this.\"service\" = ?\n				AND this.\"service_key\" = ?\n				AND this.\"key\" LIKE ?\n				ORDER BY this.\"key\" asc";

            java.sql.PreparedStatement genorm_statement = null;

            try {
                genorm_statement = GenOrmDataSource.prepareStatement(query);
                genorm_statement.setString(1, service);
                genorm_statement.setString(2, serviceKey);
                genorm_statement.setString(3, keyPrefix);

                s_logger.debug(genorm_statement.toString());

                ResultSet rs = new SQLResultSet(genorm_statement.executeQuery(), query, genorm_statement);

                return (rs);
            }
            catch (java.sql.SQLException sqle) {
                try {
                    if (genorm_statement != null) {
                        genorm_statement.close();
                    }
                }
                catch (java.sql.SQLException sqle2) {
                }

                if (s_logger.isDebugEnabled()) {
                    sqle.printStackTrace();
                }
                throw new GenOrmException(sqle);
            }
        }

        public ResultSet getServiceKeys(String service)
        {
            String query = "SELECT DISTINCT this.\"service\", this.\"service_key\" from service_index this where this.\"service\" = ?	order by this.\"service_key\" asc";

            java.sql.PreparedStatement genorm_statement = null;

            try {
                genorm_statement = GenOrmDataSource.prepareStatement(query);
                genorm_statement.setString(1, service);

                s_logger.debug(genorm_statement.toString());

                return new SQLResultSet(genorm_statement.executeQuery(), query, genorm_statement);
            }
            catch (java.sql.SQLException sqle) {
                try {
                    if (genorm_statement != null) {
                        genorm_statement.close();
                    }
                }
                catch (java.sql.SQLException sqle2) {
                }

                if (s_logger.isDebugEnabled()) {
                    sqle.printStackTrace();
                }
                throw new GenOrmException(sqle);
            }
        }


        //---------------------------------------------------------------------------

        /**
         * Calls all query methods with test parameters.
         */
        public void testQueryMethods()
        {
            ResultSet rs;
            System.out.println("ServiceIndex.getKeys");
            rs = getKeys("foo", "foo");
            rs.close();
            System.out.println("ServiceIndex.getKeysLike");
            rs = getKeysLike("foo", "foo", "key%");
            rs.close();

        }
    }

    //===========================================================================
    public static interface ResultSet extends GenOrmResultSet
    {
        public ArrayList<ServiceIndex> getArrayList(int maxRows);

        public ArrayList<ServiceIndex> getArrayList();

        public ServiceIndex getRecord();

        public ServiceIndex getOnlyRecord();
    }

    //===========================================================================
    private static class SQLResultSet
            implements ResultSet
    {
        private java.sql.ResultSet m_resultSet;
        private java.sql.Statement m_statement;
        private String m_query;
        private boolean m_onFirstResult;

        //------------------------------------------------------------------------
        protected SQLResultSet(java.sql.ResultSet resultSet, String query, java.sql.Statement statement)
        {
            m_resultSet = resultSet;
            m_statement = statement;
            m_query = query;
            m_onFirstResult = false;
        }

        //------------------------------------------------------------------------

        /**
         * Closes any underlying java.sql.Result set and java.sql.Statement
         * that was used to create this results set.
         */
        public void close()
        {
            try {
                m_resultSet.close();
                m_statement.close();
            }
            catch (java.sql.SQLException sqle) {
                throw new GenOrmException(sqle);
            }
        }

        //------------------------------------------------------------------------

        /**
         * Returns the reults as an ArrayList of Record objects.
         * The Result set is closed within this call
         *
         * @param maxRows if the result set contains more than this param
         * then an exception is thrown
         */
        public ArrayList<ServiceIndex> getArrayList(int maxRows)
        {
            ArrayList<ServiceIndex> results = new ArrayList<ServiceIndex>();
            int count = 0;

            try {
                if (m_onFirstResult) {
                    count++;
                    results.add(factory.newServiceIndex(m_resultSet));
                }

                while (m_resultSet.next() && (count < maxRows)) {
                    count++;
                    results.add(factory.newServiceIndex(m_resultSet));
                }

                if (m_resultSet.next()) {
                    throw new GenOrmException("Bound of " + maxRows + " is too small for query [" + m_query + "]");
                }
            }
            catch (java.sql.SQLException sqle) {
                sqle.printStackTrace();
                throw new GenOrmException(sqle);
            }

            close();
            return (results);
        }

        //------------------------------------------------------------------------

        /**
         * Returns the reults as an ArrayList of Record objects.
         * The Result set is closed within this call
         */
        public ArrayList<ServiceIndex> getArrayList()
        {
            ArrayList<ServiceIndex> results = new ArrayList<ServiceIndex>();

            try {
                if (m_onFirstResult) {
                    results.add(factory.newServiceIndex(m_resultSet));
                }

                while (m_resultSet.next()) {
                    results.add(factory.newServiceIndex(m_resultSet));
                }
            }
            catch (java.sql.SQLException sqle) {
                sqle.printStackTrace();
                throw new GenOrmException(sqle);
            }

            close();
            return (results);
        }

        //------------------------------------------------------------------------

        /**
         * Returns the underlying java.sql.ResultSet object
         */
        public java.sql.ResultSet getResultSet()
        {
            return (m_resultSet);
        }

        //------------------------------------------------------------------------

        /**
         * Returns the current record in the result set
         */
        public ServiceIndex getRecord()
        {
            return (factory.newServiceIndex(m_resultSet));
        }

        //------------------------------------------------------------------------

        /**
         * This call expects only one record in the result set.  If multiple records
         * are found an excpetion is thrown.
         * The ResultSet object is automatically closed by this call.
         */
        public ServiceIndex getOnlyRecord()
        {
            ServiceIndex ret = null;

            try {
                if (m_resultSet.next()) {
                    ret = factory.newServiceIndex(m_resultSet);
                }

                if (m_resultSet.next()) {
                    throw new GenOrmException("Multiple rows returned in call from ServiceIndex.getOnlyRecord");
                }
            }
            catch (java.sql.SQLException sqle) {
                throw new GenOrmException(sqle);
            }

            close();
            return (ret);
        }

        //------------------------------------------------------------------------

        /**
         * Returns true if there is another record in the result set.
         */
        public boolean next()
        {
            boolean ret = false;
            m_onFirstResult = true;
            try {
                ret = m_resultSet.next();
            }
            catch (java.sql.SQLException sqle) {
                throw new GenOrmException(sqle);
            }

            return (ret);
        }
    }

    //===========================================================================

    private GenOrmString m_service;
    private GenOrmString m_serviceKey;
    private GenOrmString m_key;
    private GenOrmString m_value;


    private List<GenOrmRecordKey> m_foreignKeys;

    public List<GenOrmRecordKey> getForeignKeys()
    {
        return (m_foreignKeys);
    }


    //---------------------------------------------------------------------------

    /**
     */
    public String getService()
    {
        return (m_service.getValue());
    }

    public ServiceIndex setService(String data)
    {
        boolean changed = m_service.setValue(data);

        //Add the now dirty record to the transaction only if it is not previously dirty
        if (changed) {
            if (m_dirtyFlags.isEmpty()) {
                GenOrmDataSource.getGenOrmConnection().addToTransaction(this);
            }

            m_dirtyFlags.set(SERVICE_FIELD_META.getDirtyFlag());

            if (m_isNewRecord) //Force set the prev value
            {
                m_service.setPrevValue(data);
            }
        }

        return ((ServiceIndex) this);
    }


    //---------------------------------------------------------------------------

    /**
     */
    public String getServiceKey()
    {
        return (m_serviceKey.getValue());
    }

    public ServiceIndex setServiceKey(String data)
    {
        boolean changed = m_serviceKey.setValue(data);

        //Add the now dirty record to the transaction only if it is not previously dirty
        if (changed) {
            if (m_dirtyFlags.isEmpty()) {
                GenOrmDataSource.getGenOrmConnection().addToTransaction(this);
            }

            m_dirtyFlags.set(SERVICE_KEY_FIELD_META.getDirtyFlag());

            if (m_isNewRecord) //Force set the prev value
            {
                m_serviceKey.setPrevValue(data);
            }
        }

        return ((ServiceIndex) this);
    }


    //---------------------------------------------------------------------------

    /**
     */
    public String getKey()
    {
        return (m_key.getValue());
    }

    public ServiceIndex setKey(String data)
    {
        boolean changed = m_key.setValue(data);

        //Add the now dirty record to the transaction only if it is not previously dirty
        if (changed) {
            if (m_dirtyFlags.isEmpty()) {
                GenOrmDataSource.getGenOrmConnection().addToTransaction(this);
            }

            m_dirtyFlags.set(KEY_FIELD_META.getDirtyFlag());

            if (m_isNewRecord) //Force set the prev value
            {
                m_key.setPrevValue(data);
            }
        }

        return ((ServiceIndex) this);
    }


    //---------------------------------------------------------------------------

    /**
     */
    public String getValue()
    {
        return (m_value.getValue());
    }

    public ServiceIndex setValue(String data)
    {
        boolean changed = m_value.setValue(data);

        //Add the now dirty record to the transaction only if it is not previously dirty
        if (changed) {
            if (m_dirtyFlags.isEmpty()) {
                GenOrmDataSource.getGenOrmConnection().addToTransaction(this);
            }

            m_dirtyFlags.set(VALUE_FIELD_META.getDirtyFlag());

            if (m_isNewRecord) //Force set the prev value
            {
                m_value.setPrevValue(data);
            }
        }

        return ((ServiceIndex) this);
    }

    public boolean isValueNull()
    {
        return (m_value.isNull());
    }

    public ServiceIndex setValueNull()
    {
        boolean changed = m_value.setNull();

        if (changed) {
            if (m_dirtyFlags.isEmpty()) {
                GenOrmDataSource.getGenOrmConnection().addToTransaction(this);
            }

            m_dirtyFlags.set(VALUE_FIELD_META.getDirtyFlag());
        }

        return ((ServiceIndex) this);
    }


    //---------------------------------------------------------------------------
    protected void initialize(String service, String serviceKey, String key)
    {
        m_service.setValue(service);
        m_service.setPrevValue(service);
        m_serviceKey.setValue(serviceKey);
        m_serviceKey.setPrevValue(serviceKey);
        m_key.setValue(key);
        m_key.setPrevValue(key);

    }

    //---------------------------------------------------------------------------
    protected void initialize(java.sql.ResultSet rs)
    {
        try {
            if (s_logger.isDebugEnabled()) {
                java.sql.ResultSetMetaData meta = rs.getMetaData();
                for (int I = 1; I <= meta.getColumnCount(); I++) {
                    s_logger.debug("Reading - " + meta.getColumnName(I) + " : " + rs.getString(I));
                }
            }
            m_service.setValue(rs, 1);
            m_serviceKey.setValue(rs, 2);

            if (rs.getFetchSize() > 2) {
                m_key.setValue(rs, 3);
                m_value.setValue(rs, 4);
            }

        }
        catch (java.sql.SQLException sqle) {
            throw new GenOrmException(sqle);
        }
    }

    //---------------------------------------------------------------------------
    /*package*/ ServiceIndex_base()
    {
        super(TABLE_NAME);
        m_logger = s_logger;
        m_foreignKeys = new ArrayList<GenOrmRecordKey>();
        m_dirtyFlags = new java.util.BitSet(NUMBER_OF_COLUMNS);


        m_service = new GenOrmString(SERVICE_FIELD_META);
        addField(COL_SERVICE, m_service);

        m_serviceKey = new GenOrmString(SERVICE_KEY_FIELD_META);
        addField(COL_SERVICE_KEY, m_serviceKey);

        m_key = new GenOrmString(KEY_FIELD_META);
        addField(COL_KEY, m_key);

        m_value = new GenOrmString(VALUE_FIELD_META);
        addField(COL_VALUE, m_value);

        GenOrmRecordKey foreignKey;
    }

    //---------------------------------------------------------------------------
    @Override
    public GenOrmConnection getGenOrmConnection()
    {
        return (GenOrmDataSource.getGenOrmConnection());
    }

    //---------------------------------------------------------------------------
    @Override
    public String getFieldEscapeString()
    {
        return (s_fieldEscapeString);
    }

    //---------------------------------------------------------------------------
    @Override
    public void setMTS()
    {
    }

    //---------------------------------------------------------------------------
    @Override
    public void setCTS()
    {
    }

    //---------------------------------------------------------------------------
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("service=\"");
        sb.append(m_service.getValue());
        sb.append("\" ");
        sb.append("service_key=\"");
        sb.append(m_serviceKey.getValue());
        sb.append("\" ");
        sb.append("key=\"");
        sb.append(m_key.getValue());
        sb.append("\" ");
        sb.append("value=\"");
        sb.append(m_value.getValue());
        sb.append("\" ");


        return (sb.toString().trim());
    }

    //===========================================================================


}
	
	