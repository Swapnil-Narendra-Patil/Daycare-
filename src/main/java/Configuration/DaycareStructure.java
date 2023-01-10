
package Configuration;

import Utils.ConversionUtil;
import models.RatioRule;
import models.Daycare;
import models.Student;
import models.StudentLazySingletonFactory;
import models.Vaccination;
import java.util.ArrayList;
import java.util.List;


public class DaycareStructure {

    public static Daycare captureData() {
        List<String> VaccinationList = ConversionUtil.readingCSVFile("Vaccination.txt");
        
        List<Vaccination> vaccinationListForDaycare = new ArrayList<>();
        for (String vaccineRecord : VaccinationList) {
            vaccinationListForDaycare.add(new Vaccination(vaccineRecord));
        }
        List<String> RatioList = ConversionUtil.readingCSVFile("Ratio.txt");
        List<RatioRule> ratioRules = new ArrayList<>();
        for (String s : RatioList) {
            ratioRules.add(new RatioRule((s)));
        }
        Daycare daycare = new Daycare();
        List<String> TeacherCSVList = ConversionUtil.readingCSVFile("Teachers.txt");
        daycare.setTeacherCSVList(TeacherCSVList);
        for (RatioRule r : ratioRules) {
            daycare.addRatioRule(r);
        }
        List<String> StudentList = ConversionUtil.readingCSVFile("StudentList.txt");
        for (String studentString : StudentList) {
            Student studentObj = StudentLazySingletonFactory.getInstance().getObject(studentString);
            for (Vaccination vObj : vaccinationListForDaycare) {
                if (vObj.getStudentId() == studentObj.getId()) {
                    studentObj.addVax(vObj);
                }
            }
            daycare.addToDaycare(studentObj);
            daycare.addAllStudentObjectsToCSV();
        }
        return daycare;
    }
}
