package viewer.types;

/**
 * User: Justin Ford
 * Date: 10/30/12
 * Time: 4:32 PM
 */
/**
 * Interface thats define an enumeration of select options.
 * <T> - The type that defines the enumeration of options
 *
 *  Used by the UI (Spring Forms) to display option labels and values.

 */
public interface OptionType<T> {

    /**
     * @return value associated with the select option - this is what is saved when the user makes a selection
     */
    T getValue();

    /**
     * @return label of the select option - this is what the user sees on the UI when use is making a selection
     */
    String getLabel();
}