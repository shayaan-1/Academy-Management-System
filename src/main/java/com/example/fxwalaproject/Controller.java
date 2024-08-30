package com.example.fxwalaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

//package com.example.fxwalaproject;

import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    DBConnection dbConnection = new DBConnection();
    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void onLogin(ActionEvent event) throws IOException{
        if (username.getText().isBlank()==false && password.getText().isBlank()==false){
            if (username.getText().equals("abm") && password.getText().equals("comsats")){
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Manage Student");
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Wrong Username or Password");
                alert.show();
            }
        }
    }

    //Main menu functions start
    @FXML
    void onExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onManageFaculty(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ManageFaculty.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Student");
        stage.show();
    }

    @FXML
    void onManageStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManageStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Student");
        stage.show();
    }


    //Main menu functions end

    //Manage Student functions start
    @FXML
    void onAddStudent(ActionEvent event) throws  IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Add Student");
        stage.show();
    }

    @FXML//The function returns back to main menu
    void onBack(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Student");
        stage.show();
    }

    @FXML
    void onEditStudent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("EditStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Edit Student");
        stage.show();
    }

    @FXML
    void onRemoveStudent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RemoveStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Remove Student");
        stage.show();
    }

    @FXML
    void onSearchStudent(ActionEvent event) throws  IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SearchStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Search Student");
        stage.show();
    }

    @FXML
    void onViewStudent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Edit Student");
        stage.show();
    }
    //Manage Student functions start

    //Manage Faculty functions start
    @FXML
    void onChangeTeacher(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("EditTeacher.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Student");
        stage.show();
    }


    //Manage Faculty functions end

    //Adding Student functionalities start
    @FXML
    private TextField classText;

    @FXML
    private TextField contactText;

    @FXML
    private TextField nameText;

    @FXML
    private RadioButton paidstatus;

    @FXML
    private TextField rollNumberText;

    @FXML
    private ToggleGroup sectionCheck;
    @FXML
    private RadioButton computerCheckBox;

    @FXML
    private RadioButton bioCheckBox;
    @FXML
    private RadioButton engCheckBox;

    @FXML
    private RadioButton icsCheckBox;

    @FXML
    private RadioButton medCheckBox;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton unpaidstatus;

    @FXML
    void onCancelStudentDetails(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ManageStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Student");
        stage.show();
    }

    @FXML
    void onSubmitStudentDetails(ActionEvent event) throws IOException{
        try{
        int section = 0;
        boolean status = false;
        if (bioCheckBox.isSelected() || medCheckBox.isSelected()){
            computerCheckBox.setSelected(false);
            icsCheckBox.setSelected(false);
            engCheckBox.setSelected(false);
            section = 2;
        }if (computerCheckBox.isSelected() || engCheckBox.isSelected()) {
            bioCheckBox.setSelected(false);
            medCheckBox.setSelected(false);
            icsCheckBox.setSelected(false);
            section = 1;
        } if (icsCheckBox.isSelected()){
            bioCheckBox.setSelected(false);
            medCheckBox.setSelected(false);
            computerCheckBox.setSelected(false);
            engCheckBox.setSelected(false);
            section = 3;
        }
        Classes classes = new Classes(Integer.parseInt(classText.getText()),section);
        Student student = new Student(classes);
        student.addPersonalDetails(nameText.getText(),Integer.parseInt(rollNumberText.getText()),contactText.getText());
        student.setAttendance(new Attendance(0,0));
        if (paidstatus.isSelected()){
            status = true;
        } if (unpaidstatus.isSelected()){
            status = false;
        }
        student.setFeeStatus(status);
        dbConnection.establishConnection();
            dbConnection.insertStudent(student);
            dbConnection.setCoursesForStudent(student, student.getCourses());

            Parent root = FXMLLoader.load(getClass().getResource("ManageStudent.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Manage Student");
            stage.show();
        }catch(SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Student with this roll number exists");
            alert.show();
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter correct roll number");
            alert.show();
        }

    }
    //Adding student functionalities end

    //View Student Details In manage Students start
    @FXML
    private RadioButton vEngCheck;

    @FXML
    private RadioButton vBioCheck;

    @FXML
    private TableColumn<Student, String> attendanceCol = new TableColumn<>();

    @FXML
    private TableColumn<Student, Integer> classCol= new TableColumn<Student, Integer>();

    @FXML
    private TableColumn<Student, String> contactCol = new TableColumn<>();

    @FXML
    private TableColumn<Student, Integer> feeCol = new TableColumn<>();

    @FXML
    private TableColumn<Student, Boolean> feeStatusCol = new TableColumn<>();

    @FXML
    private TableColumn<Student, String> nameCol = new TableColumn<>();

    @FXML
    private TableColumn<Student, Integer> rollNoCol = new TableColumn<>();

    @FXML
    private TableColumn<Student, String> sectionCol = new TableColumn<>();

    @FXML
    private TableView<Student> table = new TableView<>();

    @FXML
    private TextField vClassText;

    @FXML
    private RadioButton vCompCheck;

    @FXML
    private RadioButton vICSCheck;

    @FXML
    private RadioButton vMedCheck;

    @FXML
    private ToggleGroup vSectionCheck;

    ObservableList<Student> list ;//= FXCollections.observableArrayList(new Student(32,"Ali","0302022",12,"ahsa",3000,true,"50%"));


    @FXML
    void onBackButton(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ManageStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Student");
        stage.show();
    }
    @FXML
    void onViewButton(ActionEvent event) {
        table.getItems().clear();
        String section = null; //used for passing in display student parameter
        if (vBioCheck.isSelected())
            section = "Biology";
        if(vCompCheck.isSelected())
            section = "Computer";
        if (vEngCheck.isSelected())
            section = "Pre-Engineering";
        if(vMedCheck.isSelected())
            section = "Pre-Medical";
         if (vICSCheck.isSelected())
            section = "ICS";
        try {
            dbConnection.establishConnection();
            ObservableList<Student> studentList = FXCollections.observableArrayList();
            studentList.addAll(dbConnection.displayStudents(Integer.parseInt(vClassText.getText()), section));
            table.setItems(studentList);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rollNoCol.setCellValueFactory(new PropertyValueFactory<Student,Integer>("rollNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<Student,String>("contact"));
        classCol.setCellValueFactory(new PropertyValueFactory<Student,Integer>("classNumber"));
        sectionCol.setCellValueFactory(new PropertyValueFactory<Student,String>("section"));
        feeCol.setCellValueFactory(new PropertyValueFactory<Student,Integer>("feeAmount"));
        feeStatusCol.setCellValueFactory(new PropertyValueFactory<Student,Boolean>("feeStatus"));
        attendanceCol.setCellValueFactory(new PropertyValueFactory<Student,String>("attendancePercentage"));
        searchCourseNameCol.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
        searchMarksCol.setCellValueFactory(new PropertyValueFactory<Course,Double>("marks"));
        searchGradesCol.setCellValueFactory(new PropertyValueFactory<Course,String>("grade"));
        }
    //View Student Details In manage Students end

    //Search Student In Manage Student Start
    @FXML
    private TableView<Course> coursesTable;
    @FXML
    private TableColumn<Course, String> searchCourseNameCol = new TableColumn<>();
    @FXML
    private TableColumn<Course, String> searchGradesCol = new TableColumn<>();
    @FXML
    private TableColumn<Course, Double> searchMarksCol = new TableColumn<>();
    @FXML
    private TextField searchRollText;
//    public void initialize2() {
//       //    }


    @FXML
    void onSearchButton(ActionEvent event) {
        coursesTable.getItems().clear();
        try {
            dbConnection.establishConnection();
            ObservableList<Course> courseList = FXCollections.observableArrayList();
            Student student = dbConnection.searchStudent(Integer.parseInt(searchRollText.getText()));
            table.getItems().add(student);
            courseList.addAll(student.getCourses());
            coursesTable.setItems(courseList);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    //Search Student In Manage Student end

    //Editing Student Functionalities Start
    @FXML
    private TextField editAttendance;

    @FXML
    private TextField editContact;

    @FXML
    private TextField editFee;

    @FXML
    private TextField editId;

    @FXML
    private TextField editName;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private Label lb3;

    @FXML
    private Label lb4;

    @FXML
    private Label lb5;

    @FXML
    private Label lb6;

    @FXML
    private Label lb7;

    @FXML
    private Label lb8;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TextField txt6;

    @FXML
    private TextField txt7;

    @FXML
    private TextField txt8;

    @FXML
    private Label editStudentLabel;


    ArrayList<TextField> marks = new ArrayList<>();
    ArrayList<Label> labels = new ArrayList<>();

    public void setMarksAndLabels() {
        this.marks.add(txt1);
        this.marks.add(txt2);
        this.marks.add(txt3);
        this.marks.add(txt4);
        this.marks.add(txt5);
        this.marks.add(txt6);
        this.marks.add(txt7);
        this.marks.add(txt8);
        this.labels.add(lb1);
        this.labels.add(lb2);
        this.labels.add(lb3);
        this.labels.add(lb4);
        this.labels.add(lb5);
        this.labels.add(lb6);
        this.labels.add(lb7);
        this.labels.add(lb8);
    }

    ArrayList<Course> courseList = new ArrayList<>();
    @FXML
    void onSearchEdit(ActionEvent event) {
        dbConnection.establishConnection();
        Student student = null;
        try {
            student = dbConnection.searchStudent(Integer.parseInt(editId.getText()));
            editName.setText(student.getName());
            editAttendance.setText(student.getAttendancePercentage());
            editContact.setText(student.getContact());
            editFee.setText(String.valueOf(student.isFeeStatus()));
            ArrayList<Course> courses = new ArrayList<>(Arrays.asList(student.getCourses()));
            setMarksAndLabels();
            for(int i=0; i<courses.size(); i++){
                labels.get(i).setText(courses.get(i).getCourseName());
                marks.get(i).setText(String.valueOf(courses.get(i).getMarks()));
            }
            courseList = courses;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @FXML
    void onEdit(ActionEvent event) throws SQLException {
        Student student = new Student(editName.getText(), editContact.getText(), editAttendance.getText(), Boolean.parseBoolean(editFee.getText()));

        for (int i = 0; i < courseList.size(); i++) {
            if (marks.get(i).getText().isEmpty()) {
                courseList.get(i).setMarks(0.0); // Assign a default value
            } else {
                try {
                    double marksValue = Double.parseDouble(marks.get(i).getText());
                    courseList.get(i).setMarks(marksValue);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        dbConnection.updateData(Integer.parseInt(editId.getText()), student);

        for (Course course : courseList) {
            dbConnection.editGrades(course.getMarks(), Integer.parseInt(editId.getText()), course.getGrade(), course.getCourseName());
        }

        editStudentLabel.setText("Student edited successfully, refresh window");
    }



    //Editing Student Functionalities End

    //Editing Teacher Functionalities start
    @FXML
    private TextField teacherContactText;

    @FXML
    private TextField teacherSalaryText;

    @FXML
    private TextField teacherIDText;

    @FXML
    private TextField teacherNameText;

    @FXML
    private Button editTeacherSearch;
    @FXML
    private Label teacherChangeLabel;
    @FXML
    void onEditTeacherSearch(ActionEvent event) throws SQLException {
        dbConnection.establishConnection();
        Faculty faculty = dbConnection.searchTeacher(Integer.parseInt(teacherIDText.getText()));
        teacherNameText.setText(faculty.getName());
        teacherSalaryText.setText(String.valueOf(faculty.getSalary()));
        teacherContactText.setText(faculty.getContact());

    }

    @FXML
    void onTeacherCancel(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ManageFaculty.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Faculty");
        stage.show();
    }

    @FXML
    void onTeacherChange(ActionEvent event) throws SQLException {
        Faculty teacher = new Faculty(teacherNameText.getText(),teacherContactText.getText(),Double.parseDouble(teacherSalaryText.getText()));
        dbConnection.establishConnection();
        dbConnection.changeFacultyMember(teacher,Integer.parseInt(teacherIDText.getText()));
        teacherChangeLabel.setText("Teacher change successfully, refresh window");
    }
    //Editing Teacher Functionalities End

    //Edit Student Functionalities Start
    private TableColumn<Student, String> editAttendanceCol = new TableColumn<>();
    private TableColumn<Student, Integer> editClassCol= new TableColumn<Student, Integer>();
    private TableColumn<Student, String> editContactCol = new TableColumn<>();
    private TableColumn<Student, Integer> ediFfeeCol = new TableColumn<>();

    private TableColumn<Student, Boolean> editFeeStatusCol = new TableColumn<>();

    private TableColumn<Student, String> editNameCol = new TableColumn<>();

    private TableColumn<Student, Integer> editRollNoCol = new TableColumn<>();

    private TableColumn<Student, String> editSectionCol = new TableColumn<>();

    private TableView<Student> editTable = new TableView<>();


    //Edit Student Functionalities End

    //View Teacher In Manage Faculty Start

    TableView<Faculty> viewTeacherTable = new TableView<>();

    TableColumn<Faculty,String> teacherContactCol = new TableColumn<>("Contact");


    TableColumn<Faculty, String> teacherCourse1Col = new TableColumn<>("Course 1");



    TableColumn<Faculty, String> teacherCourse2Col = new TableColumn<>("Course 2");



    TableColumn<Faculty, Integer> teacherIdCol = new TableColumn<>("Id");


    TableColumn<Faculty, String> teacherNameCol = new TableColumn<>("Name");


    TableColumn<Faculty, Double> teacherPayCol = new TableColumn<>("Salary");


    public void initialize2(){
        viewTeacherTable.setPrefWidth(600); // Set preferred width in pixels
        viewTeacherTable.setPrefHeight(400);
        viewTeacherTable.getColumns().clear(); // Clear existing columns
        teacherContactCol.setCellValueFactory(new PropertyValueFactory<Faculty,String>("contact"));
        teacherCourse1Col.setCellValueFactory(new PropertyValueFactory<Faculty,String>("course1"));
        teacherCourse2Col.setCellValueFactory(new PropertyValueFactory<Faculty,String>("course2"));
        teacherPayCol.setCellValueFactory(new PropertyValueFactory<Faculty,Double>("salary"));
        teacherIdCol.setCellValueFactory(new PropertyValueFactory<Faculty,Integer>("id"));
        teacherNameCol.setCellValueFactory(new PropertyValueFactory<Faculty,String>("name"));
        viewTeacherTable.getColumns().addAll(
                teacherIdCol, teacherNameCol, teacherPayCol,
                teacherContactCol, teacherCourse1Col, teacherCourse2Col
        );
        viewTeacherTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }



    @FXML
    void onViewTeacher(ActionEvent event) throws IOException{
        initialize2();
        AnchorPane pane = new AnchorPane();
        AnchorPane.setTopAnchor(viewTeacherTable, 40.0);
        AnchorPane.setLeftAnchor(viewTeacherTable, 90.0);
        pane.getChildren().add(viewTeacherTable);
        Button backButton = new Button("Back");
        AnchorPane.setBottomAnchor(backButton, 10.0);
        AnchorPane.setRightAnchor(backButton, 105.0);
        pane.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("ManageFaculty.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) backButton.getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Manage Faculty");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        try {
//            viewTeacherTable.getItems().clear();
            dbConnection.establishConnection();
            ObservableList<Faculty> teacherList = FXCollections.observableArrayList();
            teacherList.addAll(dbConnection.displayFaculty());
            viewTeacherTable.setItems(teacherList);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

//        Parent root = FXMLLoader.load(getClass().getResource("ViewTeacher.fxml"));
        Scene scene = new Scene(pane,800,500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Teachers");
        stage.show();

    }
    //View Teacher In Manage Faculty End
    @FXML
    private Label delMsg;
    @FXML
    void onDeleteButton(ActionEvent event) {
        dbConnection.establishConnection();
        try{
            dbConnection.removeStudent(Integer.parseInt(searchRollText.getText()));
            delMsg.setText("Student Deleted");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
