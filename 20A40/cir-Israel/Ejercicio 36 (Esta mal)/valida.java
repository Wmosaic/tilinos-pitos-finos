import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
//import java.io.IOException;
import java.text.DateFormat;

public class valida {
    Scanner t = new Scanner(System.in);

    boolean isDate(String s) {
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == '/' || s.charAt(i) == '-' || s.charAt(i) == '.')
                continue;
            else if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        return true;
    }

    static public Date displayDate(Locale currentLocale, Date f) {
        Date today;
        String dateOut;
        DateFormat dateFormatter;

        dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);
        today = new Date();
        if (f != null) dateOut = dateFormatter.format(f);
        else dateOut = dateFormatter.format(today);
        System.out.print(dateOut);
        return today;
    }

    Date capDate(String prompt) {
        // Permitir al usuario elegir la fecha sugerida por el sistema
        // o cambiarla a su voluntad
        Date today = null;
        int dd, mm, yy = 0;
        String dateIn;

        System.out.print(prompt + "o <enter> para aceptar:");
        // today = displayDate (currentLocale, null);
        // System.out.println ("\b\b\b\b\b\b\b\b");
        dateIn = t.nextLine();
        if ((!dateIn.equals("")) && isDate(dateIn)) {
            dd = Integer.parseInt(dateIn.substring(0, 2));
            mm = Integer.parseInt(dateIn.substring(3, 5));
            if (dateIn.length() == 8)
                yy = Integer.parseInt(dateIn.substring(6, 8));
            if (dateIn.length() == 10)
                yy = Integer.parseInt(dateIn.substring(6, 10)) - 1900;
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, yy);
            calendar.set(Calendar.MONTH, mm - 1);
            calendar.set(Calendar.DAY_OF_MONTH, dd);
            return calendar.getTime();

        }
        return today;
    }

    int capInteger(String s) {
        String tmp;
        do {
            System.out.print(s);
            tmp = t.nextLine();
        } while (!isNum(tmp));
        return Integer.parseInt(tmp);
    }

    double capDouble(String s) {
        String tmp;
        do {
            System.out.print(s);
            tmp = t.nextLine();
        } while (!isNum(tmp));
        return Double.parseDouble(tmp);
    }

    public boolean isNum(String cad) {
        try {
            Double.parseDouble(cad);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("No sea chistoso y tecle correctamente");
            return false;
        }
    }

    int menute(String options) {
        int tipo;
        do
            tipo = capInteger(options);
        while (tipo != 1 && tipo != 2);
        return tipo;
    }
    
}
