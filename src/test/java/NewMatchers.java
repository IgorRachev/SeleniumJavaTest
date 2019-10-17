import org.hamcrest.Factory;
import org.hamcrest.core.SubstringMatcher;

public class NewMatchers  extends SubstringMatcher {


    protected NewMatchers(String substring) {
        super(substring);
    }

    @Override
    protected boolean evalSubstringOf(String s) {
        return false;
        //return  String.contains(substring);
    }

    @Override
    protected String relationship() {
        return null;
    }

    @Factory
    public String hasCowInside(){
        return this.substring;
        // new hasInside("COW");
    }
}
