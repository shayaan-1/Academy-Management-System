package com.example.fxwalaproject;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    Connection connection = null;

    public Connection establishConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/academy", "root", "comsats");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


    public void insertStudent(Student student) throws SQLException {
        connection = establishConnection();
        String query = "INSERT INTO student (student_id, name, contact, class_id, section, fee, fee_status, attendance) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, student.getRollNo());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getContact());
        preparedStatement.setInt(4, student.getClasses().getClassNumber());
        preparedStatement.setString(5, student.getClasses().getSection());
        preparedStatement.setFloat(6, student.getFee().getAmount());
        preparedStatement.setBoolean(7, student.getFee().isStatus());
        preparedStatement.setString(8, (student.getAttendance().calculatePercentage() + "%"));

        preparedStatement.executeUpdate();

    }

    public ArrayList<Student> displayStudents(int classNumber,String classSection) throws SQLException {
        String query = "SELECT * FROM student where class_id = " + classNumber + " AND section = \"" + classSection + "\"";
        Statement statement = connection.prepareStatement(query);
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(query);

        ArrayList<Student> students = new ArrayList<>();
        students.clear();

        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            String name = resultSet.getString("name");
            String contact = resultSet.getString("contact");
            int classId = resultSet.getInt("class_id");
            String section = resultSet.getString("section");
            int fee = resultSet.getInt("fee");
            boolean feeStatus = resultSet.getBoolean("fee_status");
            String attendance = resultSet.getString("attendance");

            Student student = new Student(studentId,name,contact,classId,section,fee,feeStatus,attendance);
            students.add(student);

        }
        return students;
    }

    public void removeStudent(int rollNUm) throws SQLException {
        deleteCourseInformation(rollNUm);
        int flag = 0;
        String query = "delete from student where student_id = " + rollNUm;
        Statement statement = connection.prepareStatement(query);
        flag = statement.executeUpdate(query);
        if (flag > 0) {
            System.out.println("Student deleted");
        } else {
            System.out.println("Student not found");
        }
    }

    public void updateData(int studentID, Student studentForUpdate) throws SQLException {
        String query = "UPDATE student SET name = ?, attendance = ?, fee_status = ?, contact = ? WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,studentForUpdate.getName());
        statement.setString(2,studentForUpdate.getAttendancePercentage());
        statement.setBoolean(3,studentForUpdate.isFeeStatus());
        statement.setString(4,studentForUpdate.getContact());
        statement.setInt(5, studentID);

        statement.executeUpdate();
    }

    public void setCoursesForStudent(Student student, Course[] courses) throws SQLException {
        for (int i = 0; i < courses.length; i++) {
            String query = "INSERT INTO student_course (student_id, course_id, marks, grade, course_name) VALUES (?, ?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, student.getRollNo());
            statement.setInt(2, courses[i].getCourseId());
            statement.setFloat(3, (float) courses[i].getGrades().getCourseGrades());
            statement.setString(4, courses[i].getGrades().calculateGrades());
            statement.setString(5, courses[i].getCourseName());

            statement.executeUpdate();
        }
    }

    public void deleteCourseInformation(int rollNUm) throws SQLException {
        String query = "delete from student_course where student_id = " + rollNUm;
        Statement statement = connection.prepareStatement(query);
        statement.executeUpdate(query);

    }

    public void changeFacultyMember(Faculty teacher, int teacherID) throws SQLException {
        int flag = 0;
        String query = "update faculty set name = ?, contact = ?, pay = ? where faculty_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, teacher.getName());
        statement.setString(2, teacher.getContact());
        statement.setDouble(3, teacher.getSalary());
        statement.setInt(4, teacherID);
        flag = statement.executeUpdate();
        if (flag == 0) {
            System.out.println("No such teacher exists");
        }
    }

    public ArrayList<Faculty> displayFaculty() throws SQLException {
        ArrayList<Faculty> teachers = new ArrayList<>();
        String query = "SELECT f.faculty_id, f.name AS faculty_name, f.pay, f.contact, c1.course_name AS course_name1, c2.course_name AS course_name2" +
                " FROM faculty f" +
                " LEFT JOIN courses c1 ON f.faculty_id = c1.faculty_id" +
                " LEFT JOIN courses c2 ON f.faculty_id = c2.faculty_id AND c1.course_id <> c2.course_id" +
                " WHERE c1.course_id < c2.course_id OR c2.course_id IS NULL";
        Statement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int teacherID = resultSet.getInt("faculty_id");
            String teacherName = resultSet.getString("faculty_name");
            double pay = resultSet.getDouble("pay");
            String contact = resultSet.getString("contact");
            String course1 = resultSet.getString("course_name1");
            String course2 = resultSet.getString("course_name2");

            Faculty faculty = new Faculty(teacherName,contact,pay,teacherID,course1,course2);
            teachers.add(faculty);
        }
        return teachers;
    }

    public Student searchStudent(int rollNum) throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();

        String query2 = "SELECT sc.student_id, c.course_name, sc.marks, sc.grade " +
                "FROM student_course sc " +
                "JOIN courses c ON sc.course_id = c.course_id " +
                "WHERE sc.student_id = " + rollNum;;
        PreparedStatement statement2 = connection.prepareStatement(query2);
        ResultSet resultSet2 = null;
        resultSet2 = statement2.executeQuery(query2);
        while(resultSet2.next()){
            String courseName = resultSet2.getString(2);
            float marks = resultSet2.getFloat(3);
            String grade = resultSet2.getString(4);
            Course course = new Course(courseName,marks,grade);
            courses.add(course);

        }

        String query = "select * from student where student_id = " + rollNum;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(query);
        Student student = null;

        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            String name = resultSet.getString("name");
            String contact = resultSet.getString("contact");
            int classId = resultSet.getInt("class_id");
            String section = resultSet.getString("section");
            int fee = resultSet.getInt("fee");
            boolean feeStatus = resultSet.getBoolean("fee_status");
            String attendance = resultSet.getString("attendance");

            student = new Student(studentId,name,contact,classId,section,fee,feeStatus,attendance);
            student.setCourses(courses.toArray(new Course[courses.size()]));
        }
        return student;
    }

    public void editGrades(double marks, int rollNum, String grade, String courseName) throws SQLException {
        String query = "UPDATE student_course SET marks = ?, grade = ? WHERE student_id = ? AND course_name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDouble(1, marks);
        statement.setString(2,grade);
        statement.setInt(3,rollNum);
        statement.setString(4,courseName);
        statement.executeUpdate();
    }

    public void studentsInACourse(int courseID) throws SQLException {
        String query = "SELECT c.course_name, sc.student_id, s.name AS student_name, sc.marks, sc.grade " +
                "FROM courses c " +
                "JOIN student_course sc ON c.course_id = sc.course_id " +
                "JOIN student s ON sc.student_id = s.student_id " +
                "WHERE c.course_id = " + courseID;
        Statement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println();

        while(resultSet.next()){
            String courseName = resultSet.getString(1);
            int studentID = resultSet.getInt(2);
            String studentName = resultSet.getString(3);
            double marks =  resultSet.getDouble(4);
            String grade = resultSet.getString(5);

            System.out.println("{Course Name: " +  courseName + ", Student id: " + studentID + ", Student name: " + studentName + ", Marks: " + marks + ", Grade: " + grade + "}");
        }
    }
    public Faculty searchTeacher(int teacherId) throws SQLException {
        String query = "SELECT f.faculty_id, f.name AS faculty_name, f.pay, f.contact, c1.course_name AS course_name1, c2.course_name AS course_name2" +
                " FROM faculty f " +
                " LEFT JOIN courses c1 ON f.faculty_id = c1.faculty_id " +
                " LEFT JOIN courses c2 ON f.faculty_id = c2.faculty_id AND c1.course_id <> c2.course_id " +
                " WHERE (c1.course_id < c2.course_id OR c2.course_id IS NULL)" +
                "  AND f.faculty_id = " + teacherId;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        Faculty faculty = null;
        while(resultSet.next()){
            String name = resultSet.getString("faculty_name");
            String contact = resultSet.getString("contact");
            double pay = resultSet.getDouble("pay");
            faculty = new Faculty(name,contact,pay);
        }
        return faculty;

    }
}

