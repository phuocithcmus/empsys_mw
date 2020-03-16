/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.employee_sys.model;

import com.vng.zing.emp.thrift.EmployeeService;
import com.vng.zing.emp.thrift.dto.Department;
import com.vng.zing.emp.thrift.dto.Employee;
import com.vng.zing.emp.thrift.dto.EmployeeWithString;
import com.vng.zing.emp.thrift.dto.ProfileEmp;
import com.vng.zing.emp.thrift.dto.Title;
import com.vng.zing.employee_sys.common.common;
import com.vng.zing.logger.ZLogger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;
import java.time.Instant;

/**
 *
 * @author cpu11129
 */
public class TEmployeeModel {

    private static final org.apache.log4j.Logger _Logger = ZLogger.getLogger(TEmployeeModel.class);
    public static final TEmployeeModel Instance = new TEmployeeModel();

    public List<EmployeeWithString> getListEmp() throws TException {
        CallableStatement cStmt;
        List<EmployeeWithString> emps = new ArrayList<>();
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_getEmpList()}");
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                emps.add(new EmployeeWithString(
                        rs1.getInt("employeeid"),
                        rs1.getString("emp_code"),
                        rs1.getString("emp_name"),
                        rs1.getString("gender"),
                        rs1.getString("dob"),
                        rs1.getString("address"),
                        rs1.getString("phone_number"),
                        rs1.getString("identification_card"),
                        rs1.getString("date_join"),
                        rs1.getString("date_left"),
                        rs1.getString("note"),
                        rs1.getString("emp_mng"),
                        rs1.getString("emp_department"),
                        rs1.getString("emp_title"),
                        rs1.getInt("role")
                ));
            }
            rs1.close();
            common.closeConnection();
            return emps;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<EmployeeWithString>();
    }

    public EmployeeWithString getEmp(int emp_id) throws TException {
        CallableStatement cStmt;
        List<EmployeeWithString> emps = new ArrayList<>();
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_getEmp_by_id(?)}");
            cStmt.setInt(1, emp_id);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                emps.add(new EmployeeWithString(
                        rs1.getInt("employeeid"),
                        rs1.getString("emp_code"),
                        rs1.getString("emp_name"),
                        rs1.getString("gender"),
                        rs1.getString("dob"),
                        rs1.getString("address"),
                        rs1.getString("phone_number"),
                        rs1.getString("identification_card"),
                        rs1.getString("date_join"),
                        rs1.getString("date_left"),
                        rs1.getString("note"),
                        rs1.getString("emp_mng"),
                        rs1.getString("emp_department"),
                        rs1.getString("emp_title"),
                        rs1.getInt("role")
                ));
            }
            rs1.close();
            common.closeConnection();
            return emps.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean deactiveEmp(int id) throws TException {
        CallableStatement cStmt;
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_deactive(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            common.closeConnection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String createEmp(Employee emp) throws TException {
        CallableStatement cStmt;
        List<String> rs = new ArrayList<>();
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_create_emp(?, ?, ?, ?,?, ?,?, ?,?, ?,?, ?,?)}");
            cStmt.setString(1, emp.emp_code);
            cStmt.setString(2, emp.emp_name);
            cStmt.setString(3, emp.gender);
            cStmt.setString(4, emp.dob);
            cStmt.setString(5, emp.address);
            cStmt.setString(6, emp.phone_number);
            cStmt.setString(7, emp.identification_card);
            cStmt.setString(8, Timestamp.from(Instant.now()).toString());
            cStmt.setString(9, emp.note);
            cStmt.setInt(10, emp.emp_mng);
            cStmt.setInt(11, emp.emp_department);
            cStmt.setInt(12, emp.emp_title);
            cStmt.setInt(13, emp.role);

            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                rs.add(rs1.getString("noti"));
            }
            rs1.close();
            common.closeConnection();
            return rs.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FAILED";
    }

    public List<Department> getAllDepartment() throws TException {
        CallableStatement cStmt;
        List<Department> departmentList = new ArrayList<>();
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_getAllDepartment()}");
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                departmentList.add(new Department(
                        rs1.getInt("id"),
                        rs1.getString("department_code"),
                        rs1.getString("department_name"),
                        rs1.getInt("department_mng")
                ));
            }
            rs1.close();
            common.closeConnection();
            return departmentList;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Title> getAllTitle() throws TException {
        CallableStatement cStmt;
        List<Title> titleList = new ArrayList<>();
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_getAllTitle()}");
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                titleList.add(new Title(
                        rs1.getInt("id"),
                        rs1.getString("title_code"),
                        rs1.getString("title_name")
                ));
            }
            rs1.close();
            common.closeConnection();
            return titleList;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Employee> getEmployeeByDept(int id) throws TException {
        CallableStatement cStmt;
        List<Employee> empList = new ArrayList<>();
        try {
            cStmt = common.getConnection().prepareCall("select * from emp_system_demo.employee where emp_department = ? and date_left is null");
            cStmt.setInt(1, id);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                empList.add(new Employee(
                        rs1.getInt("employeeid"),
                        rs1.getString("emp_code"),
                        rs1.getString("emp_name"),
                        rs1.getString("gender"),
                        rs1.getString("dob"),
                        rs1.getString("address"),
                        rs1.getString("phone_number"),
                        rs1.getString("identification_card"),
                        rs1.getString("date_join"),
                        rs1.getString("date_left"),
                        rs1.getString("note"),
                        rs1.getInt("emp_mng"),
                        rs1.getInt("emp_department"),
                        rs1.getInt("emp_title"),
                        rs1.getInt("role")
                ));
            }
            rs1.close();
            common.closeConnection();
            return empList;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ProfileEmp> getProfileEmp(int id) throws TException {
        CallableStatement cStmt;
        List<ProfileEmp> empList = new ArrayList<>();
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_profileEmp(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                empList.add(new ProfileEmp(
                        rs1.getInt("employeeid"),
                        rs1.getString("emp_code"),
                        rs1.getString("emp_name"),
                        rs1.getInt("day"),
                        rs1.getDouble("hour"),
                        rs1.getDouble("houroff")
                ));
            }
            rs1.close();
            common.closeConnection();
            return empList;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean activeEmp(int id) throws TException {
        CallableStatement cStmt;
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_active_emp(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            common.closeConnection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
