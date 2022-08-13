import pradee.MedzeUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaseDetail implements Serializable {
    private Date currentDate;
    private String data;

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public String getCurrentDate() {

        return sfd.format(currentDate);
    }
    //get the current  date as string input after covert in to date and set date
    public void setCurrentDate(String currentD) throws ParseException {
              this.currentDate = sfd.parse(String.valueOf(currentD));
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {

        this.data = data;
    }
    // formatting to print current date and data in separate lines
    @Override
    public String toString() {
        return sfd.format(currentDate) + "\n" + data;

    }
}
