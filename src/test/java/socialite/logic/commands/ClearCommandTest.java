package socialite.logic.commands;

import static socialite.logic.commands.CommandTestUtil.assertCommandSuccess;
import static socialite.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import socialite.model.AddressBook;
import socialite.model.Model;
import socialite.model.ModelManager;
import socialite.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.setAddressBook(new AddressBook());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
