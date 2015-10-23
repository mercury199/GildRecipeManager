package haveric.recipeManager.flags;

import haveric.recipeManager.ErrorReporter;
import haveric.recipeManager.recipes.BaseRecipe;
import haveric.recipeManager.recipes.MultiResultRecipe;

public class FlagIndividualResults extends Flag {
    // Flag definition and documentation
    private static final FlagType TYPE = FlagType.INDIVIDUALRESULTS;
    protected static final String[] A = new String[] {
            "{flag}", };

    protected static final String[] D = new String[] {
        "Allows multi-result recipes to have individual result outcomes, instead of a chance based outcome between all results.",
        "With this flag set, the first valid recipe found will be the one crafted",
        "",
        "A percent chance on a result will cause the recipe to fail the rest of the percent out of 100.",};

    protected static final String[] E = new String[] {
            "{flag}", };

    public FlagIndividualResults() {
    }

    public FlagIndividualResults(FlagIndividualResults flag) {
    }

    @Override
    public FlagIndividualResults clone() {
        super.clone();
        return new FlagIndividualResults(this);
    }

    @Override
    public FlagType getType() {
        return TYPE;
    }

    @Override
    protected boolean onValidate() {
        BaseRecipe recipe = getRecipe();

        if (!(recipe instanceof MultiResultRecipe)) {
            return ErrorReporter.error("Flag " + getType() + " only works with recipes that support multiple results!");
        }

        return true;
    }

    @Override
    protected boolean onParse(String value) {
        return true;
    }

}
