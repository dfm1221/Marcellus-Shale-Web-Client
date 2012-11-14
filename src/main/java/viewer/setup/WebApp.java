package viewer.setup;

/**
 * User: Justin Ford
 * Date: 11/14/12
 * Time: 6:05 PM
 */

public class WebApp {


    /**
     * @param args Command         Description
     *             dropSchema      Will remove user defined schema from database.
     */
    public static void main(String[] args) {
        final String command = args[0];
        if ("dropSchema".equalsIgnoreCase(command))
            DbSchemaOperations.dropSchema();
        else if ("createSchema".equalsIgnoreCase(command))
            DbSchemaOperations.createSchema();

    }
}
