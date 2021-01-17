import javax.swing.*;

public class TotalIncomeButton {

    public static int calculatedincome = 0;
    public static int notcalculatedincome = 0;
    public static int personalIncome;
    private static String membershipType;

    public static int Calculated(JTable csvTable) {

        for (int i = 0; i < csvTable.getRowCount(); i++) {
            membershipType = csvTable.getValueAt(i, 9).toString();
            personalIncome = DateUtil.calculateDurationInCurrentYear(csvTable.getValueAt(i, 10).toString(), csvTable.getValueAt(i, 12).toString());
            if (membershipType.equals("Individual Member")) {
                calculatedincome = calculatedincome + 36 * personalIncome;

            }
            if (membershipType.equals("Family Member")) {
                if (csvTable.getValueAt(i, 15).equals((csvTable.getValueAt(i, 0)))) {
                    calculatedincome = calculatedincome + 60 * personalIncome;
                }
            }
            if (membershipType.equals("Visitor")) {
                calculatedincome += 10;
            }
        }
        return calculatedincome;
    }

    public static int NotCalulated(JTable csvTable) {
        if (calculatedincome != notcalculatedincome) {
            for (int i = 0; i < csvTable.getRowCount(); i++) {
                membershipType = csvTable.getValueAt(i, 9).toString();
                personalIncome = DateUtil.calculateDurationInCurrentYear(csvTable.getValueAt(i, 10).toString(), csvTable.getValueAt(i, 12).toString());
                if (membershipType.equals("Individual Member")) {
                    notcalculatedincome = notcalculatedincome + 36 * personalIncome;

                }
                if (membershipType.equals("Family Member")) {
                    if (csvTable.getValueAt(i, 15).equals((csvTable.getValueAt(i, 0)))) {
                        notcalculatedincome = notcalculatedincome + 60 * personalIncome;
                    }
                }
                if (membershipType.equals("Visitor")) {
                    notcalculatedincome += 10;
                }
            }
        }
        return notcalculatedincome;
    }

    public static int delete(JTable csvTable, int selectedRow) {


        membershipType = csvTable.getValueAt(selectedRow, 9).toString();
        personalIncome = DateUtil.calculateDurationInCurrentYear(csvTable.getValueAt(selectedRow, 10).toString(), csvTable.getValueAt(selectedRow, 12).toString());
        if (membershipType.equals("Individual Member")) {
            return personalIncome;
        }
        if (membershipType.equals("Family Member") && csvTable.getValueAt(selectedRow, 15).equals((csvTable.getValueAt(selectedRow, 0)))) {
            return personalIncome;
        }
        if (membershipType.equals("Visitor")) {
            return 10;
        }


        return 0;
    }
}
