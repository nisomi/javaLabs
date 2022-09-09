package lab_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class creates an array of objects of the Phone class, and has methods that allow you to add a new object to the array,
 * delete an existing one and get information about those whose time of urban conversation exceeds preset,
 * information about subscribers who used long distance communication and
 * information about subscribers whose account number is in the specified range
 */
public class PhoneList {
    private List<Phone> phones;

    /**
     * Constructor
     * @param phones - array of objects
     */
    public PhoneList(List<Phone> phones) {
        this.phones = phones;
    }

    /**
     * Method that allow you to delete an existing object of the Phone class
     * @param phone - object you want to delete
     * @return - true value whether the item was successfully deleted
     */
    public boolean removePhone(Phone phone) {
        return phones.remove(phone);
    }

    /**
     * Method that allow you to add a new object of the Phone class
     * @param phone - object you want to add
     * @return - true value whether the item was successfully added
     */
    public boolean addPhone(Phone phone) {
        return phones.add(phone);
    }

    /**
     * Method that allow you to get information about those subscribers whose time of urban conversation exceeds preset
     * @param urbanConversationTime - time value that subscribers could exceed
     * @return - array of subscribers whose time of urban conversation exceeds preset
     */
    public List<Phone> conv_time_exceeds_preset(int urbanConversationTime) {
        List<Phone> filteredPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if ((phone.getTimeOfUrbanConversations()) >= urbanConversationTime) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * Method that allow you to get information about subscribers who used long distance communication
     * @return - array of subscribers who used long distance communication
     */
    public List<Phone> used_long_dist_comm() {
        List<Phone> filteredPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if ((phone.getTimeOfLongDistanceConversations() > 0)) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * Method that allow you to get information about subscribers whose account number is in the specified range
     * @param init - initial value
     * @param fin - final value
     * @return - array of subscribers whose account number is in this range
     */
    public List<Phone> acc_num_is_in_range(long init, long fin) {
        List<Phone> filteredPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if ((phone.getAccountNumber() >= init) && (phone.getAccountNumber() <= fin)) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * Method that allow you to print information about all subscribers
     */
    public void print_all() {
        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }
}
