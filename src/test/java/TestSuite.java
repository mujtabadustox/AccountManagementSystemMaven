import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({AccountManagemetSystemMavenTest.class,AccountManagemetSystemMavenTestNegative.class})
@Suite.SuiteClasses({AccountManagemetSystemMavenTest.class,AccountManagemetSystemMavenTestNegative.class})


public class TestSuite {
//Run this to run both Positive and Negative Cases	
}
