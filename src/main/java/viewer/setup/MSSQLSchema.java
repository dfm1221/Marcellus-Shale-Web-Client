package viewer.setup;



/**
 * Defines operations for the Microsoft SQL Server database.
 */
public class MSSQLSchema extends Schema {
    protected String getDropConstraintsQuery() {
        return "select	'alter table \"' + p.name + '\" drop constraint \"' + o.name + '\"' from sysobjects o, " +
                "sysobjects p where OBJECTPROPERTY(o.id, 'IsForeignKey') = 1 and OBJECTPROPERTY(p.id, 'IsUserTab" +
                "le') = 1 and USER_ID() = p.uid and o.parent_obj = p.id";
    }

    protected String getDropIndicesQuery() {
        return "select 'drop index \"' + o.name + '\".\"' + i.name + '\"' from sysindexes i, sysobjects o whe" +
                "re i.name like 'ix%' and i.id = o.id and OBJECTPROPERTY(o.id, 'IsUserTable') = 1 and USER_ID(" +
                ") = o.uid";
    }

    protected String getDropViewsQuery() {
        return "select 'drop view \"' + name + '\"' from sysobjects where OBJECTPROPERTY(id, 'IsView') = 1 and " +
                "OBJECTPROPERTY(id, 'IsMSShipped') = 0  and USER_ID() = uid";
    }

    protected String getDropTablesQuery() {
        return "select 'drop table \"' + name + '\"' from sysobjects where OBJECTPROPERTY(id, 'IsUserTable') = " +
                "1 and OBJECTPROPERTY(id, 'IsMSShipped') = 0 and USER_ID() = uid";
    }

    protected String getDropOneTableQuery(String name) {
        return getDropTablesQuery() + " and name = '" + name + "'";
    }
}
