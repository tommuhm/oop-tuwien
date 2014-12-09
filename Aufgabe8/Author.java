import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

@Author(name = "Thomas Muhm")
public @interface Author {
	String name();
}
