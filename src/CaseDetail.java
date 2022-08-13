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
      //  SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return sfd.format(currentDate);
    }

    public void setCurrentDate(String currentD) throws ParseException {

      //  SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.currentDate = sfd.parse(String.valueOf(currentD));

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {

        this.data = data;
    }

    @Override
    public String toString() {
        return sfd.format(currentDate) + "\n" + data;

    }
}
