import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SaveButton {
    public static void save(JTable csvTable, CSVInfo csvInfo) throws IOException, IllegalAccessException {
        List<Object> list = new ArrayList<>(16);
        for (int i = 0; i < csvTable.getRowCount(); i++) {
            CSVModel csvModel = new CSVModel();
            for (int j = 0; j < csvTable.getColumnCount(); j++) {
                Field declaredField = CSVModel.class.getDeclaredFields()[j];
                declaredField.setAccessible(true);
                String value = (String) csvTable.getValueAt(i, j);
                if (value == null) {
                    value = "";
                }
                declaredField.set(csvModel, value);
            }
            list.add(csvModel);

        }
        csvInfo.setData(list);
        CSVUtil.writeCSVFile(csvInfo);
    }
}
