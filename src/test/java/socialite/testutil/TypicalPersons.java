package socialite.testutil;

import static socialite.logic.commands.CommandTestUtil.VALID_DATE_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_FACEBOOK_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_FACEBOOK_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_INSTAGRAM_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_INSTAGRAM_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_REMARK_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_REMARK_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static socialite.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static socialite.logic.commands.CommandTestUtil.VALID_TELEGRAM_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_TELEGRAM_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_TIKTOK_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_TIKTOK_BOB;
import static socialite.logic.commands.CommandTestUtil.VALID_TWITTER_AMY;
import static socialite.logic.commands.CommandTestUtil.VALID_TWITTER_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import socialite.model.ContactList;
import socialite.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withPhone("94351253").withRemark("She likes aardvarks.").withTags("friends")
            .withFacebook("alice.p").withInstagram("alice.p").withTelegram("alice_pauline")
            .withTikTok("alice.pauline").withTwitter(null).withProfilePic(PersonBuilder.DEFAULT_PROFILE_PIC).build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withPhone("98765432").withRemark("He can't take beer!").withTags("owesMoney", "friends")
            .withFacebook("benson.m").withInstagram("benson.m").withTelegram("benson_meier")
            .withTikTok(null).withTwitter("bensonMeier").withProfilePic(PersonBuilder.DEFAULT_PROFILE_PIC).build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withFacebook("carl.k").withRemark(null).withInstagram("carl.k").withTelegram(null)
            .withTikTok("carl.kurz").withTwitter("carl").withProfilePic(PersonBuilder.DEFAULT_PROFILE_PIC).build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withRemark(null).withTags("friends").withFacebook("daniel.m").withInstagram(null)
            .withTelegram("daniel_meier").withTikTok("daniel.meier").withTwitter("DanielMeier")
            .withProfilePic(PersonBuilder.DEFAULT_PROFILE_PIC)
            .withDate("Wedding Anniversary:2020-02-01").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224").withRemark(null)
            .withFacebook(null).withInstagram("elle.m").withTelegram("elle_meyer").withTikTok("elle.meyer")
            .withTwitter("elle_meyer01").withProfilePic(PersonBuilder.DEFAULT_PROFILE_PIC).build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427").withRemark(null)
            .withFacebook("fiona.k").withInstagram("fiona.k").withTelegram("fiona_kunz")
            .withTikTok("fiona.kunz").withTwitter("fiona_kunz").withProfilePic(PersonBuilder.DEFAULT_PROFILE_PIC)
            .withDate("Birthday:2000-02-02").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withRemark(null).withFacebook("george.b").withInstagram("george.b").withTelegram("george_best")
            .withTikTok("george.best").withTwitter("georgeBest").withProfilePic(PersonBuilder.DEFAULT_PROFILE_PIC)
            .build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withTikTok("hoon.meier").withTwitter("hoon").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withTikTok("ida.mueller").withTwitter("ida_").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withRemark(VALID_REMARK_AMY).withTags(VALID_TAG_FRIEND)
            .withFacebook(VALID_FACEBOOK_AMY).withInstagram(VALID_INSTAGRAM_AMY)
            .withTelegram(VALID_TELEGRAM_AMY).withTikTok(VALID_TIKTOK_AMY).withTwitter(VALID_TWITTER_AMY)
            .withDate(VALID_DATE_AMY).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withRemark(VALID_REMARK_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withFacebook(VALID_FACEBOOK_BOB).withInstagram(VALID_INSTAGRAM_BOB)
            .withTelegram(VALID_TELEGRAM_BOB).withTikTok(VALID_TIKTOK_BOB).withTwitter(VALID_TWITTER_BOB)
            .withDate(VALID_DATE_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code ContactList} with all the typical persons.
     */
    public static ContactList getTypicalContactList() {
        ContactList cl = new ContactList();
        for (Person person : getTypicalPersons()) {
            cl.addPerson(person.copy());
        }
        return cl;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
