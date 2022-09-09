package lab_2;

/**
 * Class creates an object of type Phone, which contains information about the customer's profile,
 * his account number and the time of local and long-distance conversations
 */
public class Phone {
    private static int count = 0;

    private int ID;
    private String name;
    private String surname;
    private String patronymic;
    private int accountNumber;
    private int timeOfUrbanConversations;
    private int timeOfLongDistanceConversations;

    /**
     * Method that creates the object of type Phone with unique ID
     * @param name - subscriber's name
     * @param surname - subscriber's surname
     * @param patronymic - subscriber's patronymic
     * @param accountNumber - subscriber's account number
     * @param timeOfUrbanConversations - time of local conversations
     * @param timeOfLongDistanceConversations - time of long-distance conversations
     */
    public Phone(String name, String surname, String patronymic, int accountNumber, int timeOfUrbanConversations, int timeOfLongDistanceConversations) {
        this.ID = generateID();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.accountNumber = accountNumber;
        this.timeOfUrbanConversations = timeOfUrbanConversations;
        this.timeOfLongDistanceConversations = timeOfLongDistanceConversations;
    }

    /**
     * Method that generates unique ID for the subscriber
     * based on the number of already created objects
     * @return - value of ID
     */
    private static int generateID(){
        return count++;
    }

    /**
     * Getter to return ID of created object
     * @return - value of object`s ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter to set ID of created object
     * @param ID - value of object`s ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter to return Name of created object
     * @return - string representation of subscriber's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter to set Name of created object
     * @param name - subscriber's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter to return Surname of created object
     * @return - string representation of subscriber's surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter to set Surname of created object
     * @param surname - subscriber's surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Getter to return Patronymic of created object
     * @return - string representation of subscriber's patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Setter to set Patronymic of created object
     * @param patronymic - subscriber's patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Getter to return account number of created object
     * @return - value of account number
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Setter to set AccountNumber of created object
     * @param accountNumber - value of account number
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Getter to return time of urban conversations of created object
     * @return - value time of urban conversations
     */
    public int getTimeOfUrbanConversations() {
        return timeOfUrbanConversations;
    }

    /**
     * Setter to set timeOfUrbanConversations of created object
     * @param timeOfUrbanConversations - value time of urban conversations
     */
    public void setTimeOfUrbanConversations(int timeOfUrbanConversations) {
        this.timeOfUrbanConversations = timeOfUrbanConversations;
    }

    /**
     * Getter to return time of long-distance conversations of created object
     * @return - value time of long-distance conversations
     */
    public int getTimeOfLongDistanceConversations() {
        return timeOfLongDistanceConversations;
    }

    /**
     * Setter to set timeOfLongDistanceConversations of created object
     * @param timeOfLongDistanceConversations - value time of long-distance conversations
     */
    public void setTimeOfLongDistanceConversations(int timeOfLongDistanceConversations) {
        this.timeOfLongDistanceConversations = timeOfLongDistanceConversations;
    }

    /**
     * String representation that shows data about the fields of the created Phone object
     * @return - string representation of Phone object
     */
    @Override
    public String toString() {
        return "Phone{" +
                "ID = " + ID +",\n" +
                "name = " + name +",\n" +
                "surname = " + surname +",\n" +
                "patronymic = " + patronymic +",\n" +
                "accountNumber = " + accountNumber +",\n" +
                "timeOfUrbanConversations = " + timeOfUrbanConversations +",\n" +
                "timeOfLongDistanceConversations = " + timeOfLongDistanceConversations +
                "}\n";
    }
}
