package viewer.setup;


/**
 * Defines operations for the Derby database.
 * <p/>
 * <b><code>setUser(String dbUserName)</code>must be set to use.</b>
 */
public class DerbySchema extends Schema {
    protected String getDropConstraintsQuery() {
        checkUser();
        return "select 'alter table \"' || t.tablename || '\" drop constraint \"' || c.constraintname || '\"' " +
                "from  sys.sysconstraints c join sys.systables t on c.tableid = t.tableid join sys.sysschemas " +
                "s on s.schemaid = t.schemaid where s.schemaname = '" + user.toUpperCase() + "' and c.type = 'F'";
    }

    protected String getDropIndicesQuery() {
        return null;
    }

    protected String getDropViewsQuery() {
        checkUser();
        return "select 'drop view \"' || t.tablename || '\"' from sys.systables t join sys.sysviews v on t.tab" +
                "leid = v.tableid join sys.sysschemas s on v.compilationschemaid = s.schemaid where s.schemana" +
                "me = '" + user.toUpperCase() + "'";
    }

    protected String getDropTablesQuery() {
        checkUser();
        return "select 'drop table \"' || t.tablename || '\"' from sys.systables t join sys.sysschemas s on s." +
                "schemaid = t.schemaid where s.schemaname = '" + user.toUpperCase() + "'";
    }

    protected String getDropOneTableQuery(String name) {
        return getDropTablesQuery() + " and t.tablename ='" + name + "'";
    }
}
