package viewer.setup;



/**
 * Defines operations for the Postgres database.
 * <p/>
 * <b><code>setUser(String dbUserName)</code>must be set to use.</b>
 */
public class PostgresSchema extends Schema {
    protected String getDropConstraintsQuery() {
        return null;
    }

    protected String getDropIndicesQuery() {
        return null;
    }

    protected String getDropViewsQuery() {
        return null;
    }

    protected String getDropTablesQuery() {
        checkUser();
        return "select 'drop table \"' || c.relname || '\" cascade' from pg_class c, pg_user u where u.usen" +
                "ame = '" + user + "' and u.usesysid = c.relowner and c.relkind = 'r'";
    }

    protected String getDropOneTableQuery(String name) {
        return getDropTablesQuery() + " and c.relname ='" + name + "'";
    }
}
