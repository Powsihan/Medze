import pradee.MedzeUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaseDetail implements Serializable {
    private Date currentDate;
    private String data;


    public Date getCurrentDate() {
        return currentDate;
    }
    // get the current  date as string input after covert in to date and set date
    public void setCurrentDate(String currentD) throws ParseException {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        this.currentDate = sfd.parse(String.valueOf(currentD));

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {

        this.data = data;
    }
    //formatting to print current date and data
    @Override
    public String toString() {
        return MedzeUtil.dateViwe(currentDate) + "\n" + data;

    }
}
