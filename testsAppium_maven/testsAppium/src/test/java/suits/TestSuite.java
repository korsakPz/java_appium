package suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ArticleTests;
import tests.ChangeConditionTests;
import tests.MyyListsTests;
import tests.SearchTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArticleTests.class,
        ChangeConditionTests.class,
        MyyListsTests.class,
        SearchTests.class

})

public class TestSuite {}
