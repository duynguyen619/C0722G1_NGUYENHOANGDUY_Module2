package Case_study_module2.util;

import Case_study_module2.model.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    public int compare(Booking o1, Booking o2) {
        if (o1.getStartDay().compareTo(o2.getEndDay())>0){
            return 1;
        }else if (o1.getStartDay().compareTo(o2.getEndDay())<0){
            return -1;
        }else {
            if (o1.getEndDay().compareTo(o2.getEndDay())>0){
                return 1;
            }else if (o1.getEndDay().compareTo(o2.getEndDay())<0){
                return -1;
            }else {
                return 0;
            }
        }

    }
}
