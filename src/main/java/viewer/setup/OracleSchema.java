package viewer.setup;



/**
 * Defines operations for the Oracle database.
 * <p/>
 * <b><code>setUser(String dbUserName)</code>must be set to use.</b>
 */
public class OracleSchema extends Schema {

    protected String getDropConstraintsQuery() {
        checkUser();
        return "select distinct	'alter table \"' || c.table_name || '\" drop constraint \"' || c.constraint_n" +
                "ame || '\"' from user_cons_columns c, user_constraints r where r.constraint_type = 'R' and " +
                "r.owner = '" + user.toUpperCase() + "' and r.constraint_name = c.constraint_name";
    }

    protected String getDropIndicesQuery() {
        checkUser();
        return "select 'drop index \"' || index_name || '\"' from user_indexes where index_name like 'ix%' an" +
                "d table_owner = '" + user.toUpperCase() + "'";
    }

    protected String getDropViewsQuery() {
        return "select 'drop view \"' || view_name || '\"' from user_views";
    }

    protected String getDropTablesQuery() {
        return "select 'drop table \"' || table_name || '\"' from user_tables where table_name not like '%==%'";
    }

    protected String getDropOneTableQuery(String name) {
        return getDropTablesQuery() + " and table_name = '" + name + "'";
    }
}
