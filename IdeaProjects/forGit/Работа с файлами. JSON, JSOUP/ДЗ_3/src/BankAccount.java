import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount
{
    private String type;
    private String accountNumber;
    private String currency;
    private String dateOfOperation;
    private String refer;
    private String describe;
    private String coming;
    private String outgoing;


    public BankAccount(String[] data)
        {
            this.type = data[0];
            this.accountNumber = data[1];
            this.currency = data[2];
            this.dateOfOperation = data[3];
            this.refer = data[4];
            this.describe = data[5];
            this.coming = data[6];
            this.outgoing = data[7];

        }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(String dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public Integer getComing() {
        return Integer.parseInt(coming);
    }


    public Double getOutgoing() {
        return Double.parseDouble(outgoing);
    }


    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

}
