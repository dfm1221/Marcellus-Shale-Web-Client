package viewer.setup;

import java.util.List;

/**
 * User: Justin Ford
 * Date: 11/14/12
 * Time: 6:09 PM
 */
public interface SchemaAdapter {
    public List executeQuery(String query);

    public Integer executeUpdate(String query);
}
