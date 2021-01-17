import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;

public class AddButton {
    public static void Add(JTable csvTable, CSVInfo csvInfo) {
        JLabel memberIDLabel = new JLabel(Common.HEADERS[0]);
        JLabel lastNameLabel = new JLabel(Common.HEADERS[1]);
        JLabel firstNameLabel = new JLabel(Common.HEADERS[2]);
        JLabel dateOfBirthLabel = new JLabel(Common.HEADERS[3]);
        JLabel genderLabel = new JLabel(Common.HEADERS[4]);
        JLabel postAddressLabel = new JLabel(Common.HEADERS[5]);
        JLabel contactTelephoneLabel = new JLabel(Common.HEADERS[6]);
        JLabel healthConditionLabel = new JLabel(Common.HEADERS[7]);
        JLabel allergyInformationLabel = new JLabel(Common.HEADERS[8]);
        JLabel membershipTypeLabel = new JLabel(Common.HEADERS[9]);
        JLabel dateOfStartingMembershipLabel = new JLabel(Common.HEADERS[10]);
        JLabel membershipDurationLabel = new JLabel(Common.HEADERS[11]);
        JLabel dateOfEndingMembershipLabel = new JLabel(Common.HEADERS[12]);
        JLabel amountOfFeePaidLabel = new JLabel(Common.HEADERS[13]);
        JLabel ageLabel = new JLabel(Common.HEADERS[14]);
        JLabel responerIDLabel = new JLabel(Common.HEADERS[15]);


        JTextField memberIDTextField = new JTextField(15);
        JTextField lastNameTextField = new JTextField(15);
        JTextField firstNameTextField = new JTextField(15);
        JTextField dateOfBirthTextField = new JTextField(15);
        JTextField postAddressTextField = new JTextField(15);
        JTextField contactTelephoneTextField = new JTextField(15);
        JTextField healthConditionTextField = new JTextField(15);
        JTextField allergyInformationTextField = new JTextField(15);
        JTextField dateOfStartingMembershipTextField = new JTextField(15);
        JTextField dateOfEndingMembershipTextField = new JTextField(15);
        JTextField amountOfFeePaidTextField = new JTextField(15);
        JTextField ageTextField = new JTextField(15);
        JTextField responerTextField = new JTextField(15);

        JButton addMemberConfirmbutton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");

        memberIDTextField.setEditable(false);
        ageTextField.setEditable(false);
        dateOfEndingMembershipTextField.setEditable(false);
        responerTextField.setEditable(false);

        String randomID = Integer.toString((int) ((Math.random() * 9 + 1) * 100000));

        for (int i = 0; i < csvTable.getRowCount(); i++) {
            if (randomID.equals(csvTable.getValueAt(i, 0))) {
                randomID = Integer.toString((int) (Math.random() * 9 + 1) * 100000);
                i = 0;
            }
        }
        memberIDTextField.setText(randomID);

        String[] membershipString = {"Please Select", "Individual Member", "Family Member", "Visitor"};
        JComboBox<String> memberShipComboBox = new JComboBox<>(membershipString);

        if (memberShipComboBox.getSelectedItem().equals("Family Member") || memberShipComboBox.getSelectedItem().equals("Visitor")) {
            responerTextField.setEditable(true);
        }

        String[] genderString = {"Please Select", "Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderString);

        String[] monthString = {"Please Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
        JComboBox<String> membershipDurationComboBox = new JComboBox<>(monthString);


        JFrame addMemberFrame = new JFrame("Add Member");
        JPanel addMemberPane = new JPanel();


        addMemberFrame.setAlwaysOnTop(true);
        addMemberFrame.setResizable(false);

        addMemberFrame.setSize(500, 550);

        GroupLayout layout = new GroupLayout(addMemberPane);
        addMemberPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(memberIDLabel)
                .addComponent(lastNameLabel)
                .addComponent(firstNameLabel)
                .addComponent(dateOfBirthLabel)
                .addComponent(genderLabel)
                .addComponent(postAddressLabel)
                .addComponent(contactTelephoneLabel)
                .addComponent(healthConditionLabel)
                .addComponent(allergyInformationLabel)
                .addComponent(membershipTypeLabel)
                .addComponent(dateOfStartingMembershipLabel)
                .addComponent(membershipDurationLabel)
                .addComponent(dateOfEndingMembershipLabel)
                .addComponent(amountOfFeePaidLabel)
                .addComponent(ageLabel)
                .addComponent(responerIDLabel)
                .addComponent(addMemberConfirmbutton)
        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(memberIDTextField)
                .addComponent(lastNameTextField)
                .addComponent(firstNameTextField)
                .addComponent(dateOfBirthTextField)
                .addComponent(genderComboBox)
                .addComponent(postAddressTextField)
                .addComponent(contactTelephoneTextField)
                .addComponent(healthConditionTextField)
                .addComponent(allergyInformationTextField)
                .addComponent(memberShipComboBox)
                .addComponent(dateOfStartingMembershipTextField)
                .addComponent(membershipDurationComboBox)
                .addComponent(dateOfEndingMembershipTextField)
                .addComponent(amountOfFeePaidTextField)
                .addComponent(ageTextField)
                .addComponent(responerTextField)
                .addComponent(cancelButton)
        );
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(memberIDLabel).addComponent(memberIDTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(lastNameLabel).addComponent(lastNameTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(firstNameLabel).addComponent(firstNameTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(dateOfBirthLabel).addComponent(dateOfBirthTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(genderLabel).addComponent(genderComboBox));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(postAddressLabel).addComponent(postAddressTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(contactTelephoneLabel).addComponent(contactTelephoneTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(healthConditionLabel).addComponent(healthConditionTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(allergyInformationLabel).addComponent(allergyInformationTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(membershipTypeLabel).addComponent(memberShipComboBox));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(dateOfStartingMembershipLabel).addComponent(dateOfStartingMembershipTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(membershipDurationLabel).addComponent(membershipDurationComboBox));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(dateOfEndingMembershipLabel).addComponent(dateOfEndingMembershipTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(amountOfFeePaidLabel).addComponent(amountOfFeePaidTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(ageLabel).addComponent(ageTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(responerIDLabel).addComponent(responerTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(addMemberConfirmbutton).addComponent(cancelButton));
        layout.setVerticalGroup(vGroup);


        dateOfBirthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (((String) memberShipComboBox.getSelectedItem()).equalsIgnoreCase("Family Member") ||
                        ValidateUtil.isUnder12((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                    responerTextField.setEditable(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (((String) memberShipComboBox.getSelectedItem()).equalsIgnoreCase("Family Member") ||
                        ValidateUtil.isUnder12((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                    responerTextField.setEditable(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (((String) memberShipComboBox.getSelectedItem()).equalsIgnoreCase("Family Member") ||
                        ValidateUtil.isUnder12((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                    responerTextField.setEditable(true);
                }
            }
        });

        dateOfBirthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (DateUtil.isLegal(dateOfBirthTextField.getText())) {
                    ageTextField.setText(DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()));
                }
                if ((memberShipComboBox.getSelectedItem()).equals("Family Member") ||
                        (memberShipComboBox.getSelectedItem()).equals("Visitor")) {

                    if (ValidateUtil.isUnder12((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                        responerTextField.setEditable(true);
                        amountOfFeePaidTextField.setText("£0");
                    } else if ((memberShipComboBox.getSelectedItem()).equals("Visitor")) {
                        responerTextField.setEditable(false);
                        amountOfFeePaidTextField.setText("£10");
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (DateUtil.isLegal(dateOfBirthTextField.getText())) {
                    ageTextField.setText(DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()));
                }
                if ((memberShipComboBox.getSelectedItem()).equals("Family Member") ||
                        (memberShipComboBox.getSelectedItem()).equals("Visitor")) {

                    if (ValidateUtil.isUnder12((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                        responerTextField.setEditable(true);
                        amountOfFeePaidTextField.setText("£0");
                    } else if ((memberShipComboBox.getSelectedItem()).equals("Visitor")) {
                        responerTextField.setEditable(false);
                        amountOfFeePaidTextField.setText("£10");
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (DateUtil.isLegal(dateOfBirthTextField.getText())) {
                    ageTextField.setText(DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()));
                }
                if ((memberShipComboBox.getSelectedItem()).equals("Family Member") ||
                        (memberShipComboBox.getSelectedItem()).equals("Visitor")) {

                    if (ValidateUtil.isUnder12((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                        responerTextField.setEditable(true);
                        amountOfFeePaidTextField.setText("£0");
                    } else if ((memberShipComboBox.getSelectedItem()).equals("Visitor")) {
                        responerTextField.setEditable(false);
                        amountOfFeePaidTextField.setText("£10");
                    }
                }

            }

        });

        memberShipComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((memberShipComboBox.getSelectedItem()).equals("Visitor")) {
                    memberIDTextField.setText("");
                    postAddressTextField.setText("");
                    contactTelephoneTextField.setText("");
                    healthConditionTextField.setText("");
                    allergyInformationTextField.setText("");
                    dateOfStartingMembershipTextField.setText("");

                    memberIDTextField.setEditable(false);
                    postAddressTextField.setEditable(false);
                    contactTelephoneTextField.setEditable(false);
                    healthConditionTextField.setEditable(false);
                    allergyInformationTextField.setEditable(false);
                    dateOfStartingMembershipTextField.setEditable(false);
                    membershipDurationComboBox.setEnabled(false);

                    amountOfFeePaidTextField.setText("£10");
                    if (ValidateUtil.isUnder12((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                        responerTextField.setEditable(true);
                        amountOfFeePaidTextField.setText("£0");
                    }
                }
                if ((memberShipComboBox.getSelectedItem()).equals("Family Member") || (memberShipComboBox.getSelectedItem()).equals("Individual Member")) {
                    String randomID2 = Integer.toString((int) ((Math.random() * 9 + 1) * 100000));

                    for (int i = 0; i < csvTable.getRowCount(); i++) {
                        if (randomID2.equals((String) csvTable.getValueAt(i, 0))) {
                            randomID2 = Integer.toString((int) (Math.random() * 9 + 1) * 100000);
                            i = 0;
                        }
                    }
                    memberIDTextField.setText(randomID2);
                    postAddressTextField.setEditable(true);
                    contactTelephoneTextField.setEditable(true);
                    healthConditionTextField.setEditable(true);
                    allergyInformationTextField.setEditable(true);
                    dateOfStartingMembershipTextField.setEditable(true);
                    membershipDurationComboBox.setEnabled(true);
                    if ((memberShipComboBox.getSelectedItem()).equals("Family Member")) {
                        responerTextField.setEditable(true);
                        if (membershipDurationComboBox.getSelectedIndex() != 0) {
                            amountOfFeePaidTextField.setText("£" + Integer.toString(60 * membershipDurationComboBox.getSelectedIndex()) + "(Pay by Family Holder)");
                        }
                    }
                    if (membershipDurationComboBox.getSelectedIndex() != 0 && (memberShipComboBox.getSelectedItem()).equals("Individual Member")) {
                        amountOfFeePaidTextField.setText("£" + Integer.toString(36 * membershipDurationComboBox.getSelectedIndex()));
                        responerTextField.setEditable(false);
                    }
                }

            }

        });
        dateOfStartingMembershipTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (membershipDurationComboBox.getSelectedIndex() != 0 && DateUtil.isLegal(dateOfStartingMembershipTextField.getText())) {
                    dateOfEndingMembershipTextField.setText(DateUtil.calculateEndDateByStartDate(dateOfStartingMembershipTextField.getText(), membershipDurationComboBox.getSelectedIndex()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (membershipDurationComboBox.getSelectedIndex() != 0 && DateUtil.isLegal(dateOfStartingMembershipTextField.getText())) {
                    dateOfEndingMembershipTextField.setText(DateUtil.calculateEndDateByStartDate(dateOfStartingMembershipTextField.getText(), membershipDurationComboBox.getSelectedIndex()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (membershipDurationComboBox.getSelectedIndex() != 0 && DateUtil.isLegal(dateOfStartingMembershipTextField.getText())) {
                    dateOfEndingMembershipTextField.setText(DateUtil.calculateEndDateByStartDate(dateOfStartingMembershipTextField.getText(), membershipDurationComboBox.getSelectedIndex()));
                }
            }
        });

        membershipDurationComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (membershipDurationComboBox.getSelectedIndex() != 0 && DateUtil.isLegal(dateOfStartingMembershipTextField.getText())) {
                    dateOfEndingMembershipTextField.setText(DateUtil.calculateEndDateByStartDate(dateOfStartingMembershipTextField.getText(), membershipDurationComboBox.getSelectedIndex()));
                }
                if (memberShipComboBox.getSelectedIndex() == 1) {
                    amountOfFeePaidTextField.setText("£" + Integer.toString(36 * membershipDurationComboBox.getSelectedIndex()));
                    amountOfFeePaidTextField.setEditable(false);
                    responerTextField.setEditable(false);
                } else if (memberShipComboBox.getSelectedIndex() == 2) {
                    amountOfFeePaidTextField.setText("£" + Integer.toString(60 * membershipDurationComboBox.getSelectedIndex()) + "(Pay by Family Holder)");
                    amountOfFeePaidTextField.setEditable(false);
                    responerTextField.setEditable(true);
                }

            }
        });


        addMemberConfirmbutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int rowCount = csvTable.getRowCount();
                String memberId = memberIDTextField.getText();
                String lastName = lastNameTextField.getText();
                String firstName = firstNameTextField.getText();
                String gender = (String) genderComboBox.getSelectedItem();
                String dateOfBirth = dateOfBirthTextField.getText();
                String postAddress = postAddressTextField.getText();
                String contactTelephoneNumber = contactTelephoneTextField.getText();
                String healthCondition = healthConditionTextField.getText();
                String allergyInfomation = allergyInformationTextField.getText();
                String membershipType = (String) memberShipComboBox.getSelectedItem();
                String dateOfStartingMembership = dateOfStartingMembershipTextField.getText();
                String membershipDuration = (String) membershipDurationComboBox.getSelectedItem();
                String dateOfEndingMembership = dateOfEndingMembershipTextField.getText();
                String amountOfFeePaid = amountOfFeePaidTextField.getText();
                String age = ageTextField.getText();
                String responser = responerTextField.getText();

                if (ValidateUtil.isNotLegal(lastName, firstName, gender, dateOfBirth, contactTelephoneNumber, membershipType, dateOfStartingMembership, membershipDuration, responser)) {
                    JOptionPane.showMessageDialog(addMemberConfirmbutton, Tips.INFO_ILLEGA);
                    return;
                }

                CSVModel csvModel = new CSVModel();
                csvModel.setId(memberId);
                csvModel.setLastName(lastName);
                csvModel.setFirstName(firstName);
                csvModel.setDateOfBirth(dateOfBirth);
                csvModel.setGender(gender);
                csvModel.setPostAddress(postAddress);
                csvModel.setContactTelephoneNumber(contactTelephoneNumber);
                csvModel.setHealthCondition(healthCondition);
                csvModel.setAllergyInformation(allergyInfomation);
                csvModel.setMembershipType(membershipType);
                csvModel.setDateOfStartingMembership(dateOfStartingMembership);
                csvModel.setMembershipDuration(membershipDuration);
                csvModel.setDateOfEndingMembership(dateOfEndingMembership);
                csvModel.setAmountOfFeePaid(amountOfFeePaid);
                csvModel.setAge(age);
                csvModel.setResponser(responser);

                csvModel.setResponser(responser);

                csvInfo.getData().add(csvModel);
                Field[] declaredFields = CSVModel.class.getDeclaredFields();

                if (!ValidateUtil.isAbove18((String) memberShipComboBox.getSelectedItem(), DateUtil.calculateAgeByDateOfBirth(dateOfBirthTextField.getText()))) {
                    JOptionPane.showMessageDialog(addMemberConfirmbutton, Tips.AGE_LIMIT);
                    return;
                }

                ((DefaultTableModel) csvTable.getModel()).insertRow(rowCount, new String[]{});
                for (int i = 0; i < Common.HEADERS.length; i++) {
                    try {
                        Field field = declaredFields[i];
                        field.setAccessible(true);
                        csvTable.setValueAt(field.get(csvModel), rowCount, i);
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(addMemberConfirmbutton, Tips.ADD_SUCCESS);
                addMemberFrame.dispose();

            }

        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMemberFrame.dispose();
            }
        });
        addMemberFrame.add(addMemberConfirmbutton);
        addMemberFrame.setContentPane(addMemberPane);
        addMemberFrame.setVisible(true);


    }
}
