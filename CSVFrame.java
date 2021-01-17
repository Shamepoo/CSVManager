import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;

public class CSVFrame extends JFrame {
    JButton saveButton = new JButton("Save");
    JButton addMemberButton = new JButton("Add member");
    JButton deleteMemberButton = new JButton("Delete Member");
    JButton editMemberButton = new JButton("Edit Member");
    JButton memberAmountButton = new JButton("Member Amount");
    JButton totalIncomeButton = new JButton("Total Income");
    JButton helpButton = new JButton("Help");
    JLabel searchLabel = new JLabel("Search");
    JTextField searchTextField = new JTextField(10);

    private JTable csvTable;
    private JScrollPane scrollPane;
    private CSVInfo<CSVModel> csvInfo;
    private TableRowSorter<DefaultTableModel> sorter;


    public CSVFrame() {
        try {
            renderPanel();
            renderToolBar();
            renderTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void renderToolBar() {

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SaveButton.save(csvTable, csvInfo);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddButton.Add(csvTable, csvInfo);
            }
        });


        deleteMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int delRow = csvTable.getSelectedRow();
                TotalIncomeButton.notcalculatedincome = TotalIncomeButton.NotCalulated(csvTable);
                if (TotalIncomeButton.calculatedincome != TotalIncomeButton.notcalculatedincome) {
                    TotalIncomeButton.calculatedincome += TotalIncomeButton.delete(csvTable, delRow);
                }
                if (delRow < 0) {
                    JOptionPane.showMessageDialog(deleteMemberButton, Tips.NO_MEMBER_SELECTED);
                    return;
                }
                ((DefaultTableModel) csvTable.getModel()).removeRow(delRow);
            }
        });


        editMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int editRow = csvTable.getSelectedRow();

                if (editRow < 0) {
                    JOptionPane.showMessageDialog(editMemberButton, Tips.NO_MEMBER_SELECTED);
                    return;
                }
                EditButton.Edit(csvTable, csvInfo);
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(editMemberButton, Tips.HELP);
                return;
            }
        });

        memberAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(editMemberButton, Tips.AMOUNT_MESSAGE + csvTable.getRowCount());
            }
        });

        totalIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(totalIncomeButton, Tips.TOTAL_INCOME + TotalIncomeButton.Calculated(csvTable));
            }
        });

        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchFunc();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchFunc();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchFunc();
            }
        });


        JToolBar toolBar = new JToolBar() {
            {
                add(saveButton);
                addSeparator();
                add(addMemberButton);
                add(deleteMemberButton);
                addSeparator();
                add(editMemberButton);
                addSeparator();
                add(memberAmountButton);
                add(totalIncomeButton);
                add(helpButton);
                addSeparator();
                add(searchLabel);
                add(searchTextField);
            }
        };
        add(toolBar, BorderLayout.PAGE_START);


    }

    private void searchFunc() {
        String searchText = searchTextField.getText();
        DefaultTableModel model = (DefaultTableModel) csvTable.getModel();
        sorter = new TableRowSorter<>(model);
        csvTable.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(searchText));
    }

    private void renderPanel() {
        Dimension srceenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(srceenSize.width, srceenSize.height);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void renderTable() throws IllegalAccessException {
        initData(Common.PATH);
        renderTableVision(this.csvInfo);
    }

    private void initData(String path) {
        try {
            this.csvInfo = CSVUtil.parseCSVFile(path, CSVModel.class);
            csvInfo.getData()
                    .forEach(e -> e.setAge(DateUtil.calculateAgeByDateOfBirth(e.getDateOfBirth())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void renderTableVision(CSVInfo csvInfo) throws IllegalAccessException {
        this.csvTable = new JTable(csvInfo.getRowNumber(), csvInfo.getColNumber()) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        this.scrollPane = new JScrollPane(this.csvTable);

        JTableHeader th = this.csvTable.getTableHeader();
        th.setPreferredSize(new Dimension(200, 40));
        th.setReorderingAllowed(false);

        this.csvTable.setRowHeight(30);


        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < csvInfo.getRowNumber(); i++) {
            for (int j = 0; j < csvInfo.getColNumber(); j++) {
                Field field = csvInfo.getData().get(i).getClass().getDeclaredFields()[j];
                field.setAccessible(true);
                this.csvTable.setValueAt(field.get(csvInfo.getData().get(i)), i, j);
                if (i == 0) {
                    TableColumn tc = tcm.getColumn(j);
                    tc.setHeaderValue(Common.HEADERS[j]);
                    tc.setWidth(200);
                }


            }
        }

        TableColumn Column6 = csvTable.getColumnModel().getColumn(5);
        Column6.setPreferredWidth(100);
        Column6.setMaxWidth(100);
        Column6.setMinWidth(100);

        TableColumn Column10 = csvTable.getColumnModel().getColumn(9);
        Column10.setPreferredWidth(120);
        Column10.setMaxWidth(120);
        Column10.setMinWidth(120);

        TableColumn Column12 = csvTable.getColumnModel().getColumn(11);
        Column12.setPreferredWidth(140);
        Column12.setMaxWidth(140);
        Column12.setMinWidth(140);

        th.repaint();
        add(scrollPane);
    }


}
