package socialite.logic.parser;

import static java.util.Objects.requireNonNull;

import socialite.commons.core.Messages;
import socialite.commons.core.index.Index;
import socialite.logic.commands.DeleteCommand;
import socialite.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        requireNonNull(args);
        if (!args.trim().matches("\\d+")) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_HELP_GUIDE));
        }
        Index index = ParserUtil.parseIndex(args);
        return new DeleteCommand(index);
    }

}
