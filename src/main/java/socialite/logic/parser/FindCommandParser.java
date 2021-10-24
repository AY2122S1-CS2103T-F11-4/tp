package socialite.logic.parser;

import java.util.Arrays;

import socialite.commons.core.Messages;
import socialite.logic.commands.FindCommand;
import socialite.logic.parser.exceptions.ParseException;
import socialite.model.person.ContainsKeywordsPredicate;
import socialite.storage.Storage;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args, Storage storage) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_HELP_GUIDE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindCommand(new ContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
