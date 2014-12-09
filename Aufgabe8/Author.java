import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

@Author(name = "Thomas Muhm")
// Author Annotation mit dem Attribute name
public @interface Author {
	@Author(name = "Thomas Muhm")
	String name();
}
