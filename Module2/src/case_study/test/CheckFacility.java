package Case_study_module2.test;

import Case_study_module2.model.facility.Facility;
import Case_study_module2.util.ReadAndWriteCSV;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckFacility {
    private static final String PATH_FILE_VILLA = "src/Case_study_module2/data/Villa.csv";
    private static final String PATH_FILE_ROOM = "src/Case_study_module2/data/Room.csv";
    private static final String PATH_FILE_HOUSE = "src/Case_study_module2/data/House.csv";
    private static final String NAME_REGEX = "^[A-Z](\\w+||\\s||\\w+)+$";
    private static final String ID_NAME_REGEX = "^(SVVL-)\\d{4}$";
    static final Map<Facility, Integer> facilityVillaIntegerMap = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
    private static final Map<Facility, Integer> facilityRoomIntegerMap = ReadAndWriteCSV.readListFacilityRoomToCSV(PATH_FILE_ROOM);
    private static final Map<Facility, Integer> facilityHouseIntegerMap = ReadAndWriteCSV.readListFacilityHouseToCSV(PATH_FILE_HOUSE);
    public static Boolean checkVillaName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityVillaIntegerMap.keySet();
            for (Facility key : keySet) {
                if (name.equals(key.getNameService())) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }
    public static Boolean checkRoomName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityRoomIntegerMap.keySet();
            for (Facility key : keySet) {
                if (name.equals(key.getNameService())) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }
    public static Boolean checkHouseName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityHouseIntegerMap.keySet();
            for (Facility key : keySet) {
                if (name.equals(key.getNameService())) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }
}
