package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;

public class Utils {
	
	private static final long BREAK_MIN_TIME = 45;
	private static final long JOB_HOURS = 480;

	public static ImageIcon createImageIcon(Class className, String path) {
        java.net.URL imgURL = className.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

	/**
	 * Calculate hours to go
	 * @param in1Str
	 * @param out1Str
	 * @param in2Str
	 * @return
	 * @throws ParseException
	 */
	public static String calculate(String in1Str, String out1Str, String in2Str) throws ParseException {
		
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    Date in1 = sdf.parse(in1Str);
	    Date out1 = sdf.parse(out1Str);
	    Date in2 = sdf.parse(in2Str);
	    long diffbreakTime = 0;
	    
	    long firstDiff = (out1.getTime()-in1.getTime())/ (60 * 1000);
	    long breakTime = (in2.getTime()-out1.getTime())/ (60 * 1000);
	    
	    if(breakTime < BREAK_MIN_TIME) {
	    	diffbreakTime = BREAK_MIN_TIME-breakTime;
	    }
	    
	    long minToGo = JOB_HOURS - firstDiff;
	    
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(in2);
	    cal.add(Calendar.MINUTE, Integer.parseInt(Long.toString(diffbreakTime)));
	    cal.add(Calendar.MINUTE, Integer.parseInt(Long.toString(minToGo)));
	    String newTime = sdf.format(cal.getTime());
		return newTime;
	}

}
