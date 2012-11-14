package viewer.setup;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 11/14/12
 * Time: 6:07 PM
 */
public class DbSchemaOperations {
    private Schema schema;
    private SchemaAdapter schemaAdapter;
    private String persistenceUnitName;

    protected void dropSchemaLocal() {
        schema.drop(schemaAdapter);
    }

    public static void dropSchema() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"viewer/setup/dbSchemaContext.xml"});
        applicationContext.getBean("dbSchemaOperations", DbSchemaOperations.class).dropSchemaLocal();

    }

    public static void createSchema() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"viewer/setup/dbSchemaContext.xml"});
        applicationContext.getBean("dbSchemaEntityManagerFactory", EntityManagerFactory.class).createEntityManager();
    }

    @Required
    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    @Required
    public void setSchemaAdapter(SchemaAdapter schemaAdapter) {
        this.schemaAdapter = schemaAdapter;
    }

    @Required
    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }
}
