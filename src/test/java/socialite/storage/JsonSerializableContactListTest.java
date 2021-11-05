package socialite.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import socialite.commons.exceptions.IllegalValueException;
import socialite.commons.util.JsonUtil;
import socialite.model.ContactList;
import socialite.testutil.Assert;
import socialite.testutil.TypicalPersons;

public class JsonSerializableContactListTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableContactListTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsAddressBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableContactList dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableContactList.class).get();
        ContactList contactListFromFile = dataFromFile.toModelType();
        ContactList typicalPersonsContactList = TypicalPersons.getTypicalAddressBook();
        assertEquals(contactListFromFile, typicalPersonsContactList);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableContactList dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableContactList.class).get();
        Assert.assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableContactList dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableContactList.class).get();
        Assert.assertThrows(IllegalValueException.class, JsonSerializableContactList.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toModelType);
    }
}
