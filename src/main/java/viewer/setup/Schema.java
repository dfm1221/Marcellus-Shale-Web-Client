package viewer.setup;

import java.util.List;

/**
 * User: Justin Ford
 * Date: 11/14/12
 * Time: 6:08 PM
 */
public abstract class Schema {
    protected String user = "";

    public String getUser() {
        return user;
    }

    public void setUser(String dbUserName) {
        this.user = user;
    }

    protected void checkUser() {
        if (user.isEmpty())
            throw new RuntimeException("Db User Name has not been set");
    }


    /**
     * This query will generate a statement that can be executed, that will generate a list
     * of SQL statements specific to the implementing class for a particular database, that
     * will <b>drop all constraints</b>.
     *
     * @return Query
     */
    abstract protected String getDropConstraintsQuery();

    /**
     * This query will generate a statement that can be executed, that will generate a list
     * of SQL statements specific to the implementing class for a particular database, that
     * will <b>drop all indices</b>.
     *
     * @return Query
     */
    abstract protected String getDropIndicesQuery();

    /**
     * This query will generate a statement that can be executed, that will generate a list
     * of SQL statements specific to the implementing class for a particular database, that
     * will <b>drop all views</b>.
     *
     * @return Query
     */
    abstract protected String getDropViewsQuery();

    /**
     * This query will generate a statement that can be executed, that will generate a list
     * of SQL statements specific to the implementing class for a particular database, that
     * will <b>drop all tables</b>.
     *
     * @return Query
     */
    abstract protected String getDropTablesQuery();

    /**
     * This query will generate a statement that can be executed, that will generate a list
     * of SQL statements specific to the implementing class for a particular database, that
     * will drop one <b>table</b>.
     *
     * @param name Name of the table in database to be dropped.
     * @return Query
     */
    abstract protected String getDropOneTableQuery(String name);

    /**
     * Will drop the schema specified.
     *
     * @param schemaAdapter Schema Adapter will handle executing queries. Must supply an implementation.
     */
    public void drop(final SchemaAdapter schemaAdapter) {
        String[] nestedQueries = new String[]{
                getDropConstraintsQuery(),
                getDropIndicesQuery(),
                getDropViewsQuery(),
                getDropTablesQuery()
        };

        for (String nestedQuery : nestedQueries) {
            List subQueries = schemaAdapter.executeQuery(nestedQuery);
            for (Object expectedQuery : subQueries)
                if (expectedQuery instanceof String)
                    schemaAdapter.executeUpdate((String) expectedQuery);
        }
    }

    /**
     * Will drop a table from the schema specified.
     *
     * @param schemaAdapter Schema Adapter will handle executing queries. Must supply an implementation.
     * @param tableName     Name of table to be dropped.
     */
    public void dropTable(final SchemaAdapter schemaAdapter, String tableName) {
        schemaAdapter.executeQuery(getDropOneTableQuery(tableName));
    }
}
