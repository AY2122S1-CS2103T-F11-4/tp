package socialite.ui;

import socialite.logic.Logic;
import socialite.logic.commands.CommandResult;
import socialite.logic.commands.exceptions.CommandException;
import socialite.logic.parser.exceptions.ParseException;

/**
 * Represents a function that can execute commands.
 */
@FunctionalInterface
public interface CommandExecutor {
    /**
     * Executes the command and returns the result.
     *
     * @see Logic#execute(String)
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;
}
