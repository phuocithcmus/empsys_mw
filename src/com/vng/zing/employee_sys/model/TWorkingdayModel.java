/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.employee_sys.model;

import com.vng.zing.emp.thrift.EmployeeService;
import com.vng.zing.emp.thrift.dto.Employee;
import com.vng.zing.emp.thrift.dto.ProfileEmp;
import com.vng.zing.emp.thrift.dto.WorkingTime;
import com.vng.zing.employee_sys.common.common;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.workingday.thrift.WorkingService;
import com.vng.zing.workingday.thrift.dto.WorkingDayInfo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;

/**
 *
 * @author cpu11129
 */
public class TWorkingdayModel{

    private static final org.apache.log4j.Logger _Logger = ZLogger.getLogger(TWorkingdayModel.class);
    public static final TWorkingdayModel Instance = new TWorkingdayModel();

    public Employee login(String username, String password) throws TException {
        CallableStatement cStmt;
        try {
            List<Employee> emp = new ArrayList<>();
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_login(?)}");
            cStmt.setString(1, username);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                emp.add(new Employee(
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
            return emp.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public WorkingDayInfo getWorkingDayInfo(int id, String date) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<WorkingDayInfo> getWorkingInfo(int id) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getHourOffOrtherMonth(int id, String date_month) throws TException {
        CallableStatement cStmt;
        try {
            List<Integer> hourOff = new ArrayList<>();
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_HourOffOrtherDay(?, ?)}");
            cStmt.setInt(1, id);
            cStmt.setString(2, date_month);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                hourOff.add(
                        rs1.getInt("working_hour")
                );
            }
            rs1.close();
            common.closeConnection();
            return hourOff.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void clockIn(int id) throws TException {
        CallableStatement cStmt;
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_clockIn(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            common.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clockOut(int id) throws TException {
        CallableStatement cStmt;
        try {
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_clockOut(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            common.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Integer> isChecked(int id) throws TException {
        CallableStatement cStmt;
        try {
            List<Integer> checked = new ArrayList<>();
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_isChecked(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                checked.add(
                        rs1.getInt("inChecked")
                );
                checked.add(
                        rs1.getInt("outChecked")
                );
            }
            rs1.close();
            common.closeConnection();
            return checked;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<String> timeChecked(int id) throws TException {
        CallableStatement cStmt;
        try {
            List<String> timeChecked = new ArrayList<>();
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_get_time_check(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                timeChecked.add(
                        rs1.getString("time_in") == null ? "" : rs1.getString("time_in")
                );
                timeChecked.add(
                        rs1.getString("time_out") == null ? "" : rs1.getString("time_out")
                );
                timeChecked.add(
                        rs1.getString("mark") == null ? "" : rs1.getString("mark")
                );
            }
            rs1.close();
            common.closeConnection();
            return timeChecked;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<WorkingTime> getWorkingTime(int id) throws TException {
        CallableStatement cStmt;
        try {
            List<WorkingTime> workingTime = new ArrayList<>();
            cStmt = common.getConnection().prepareCall("{CALL emp_system_demo.sp_getWorkingtime(?)}");
            cStmt.setInt(1, id);
            cStmt.execute();
            ResultSet rs1 = cStmt.getResultSet();
            while (rs1.next()) {
                workingTime.add(
                        new WorkingTime(
                                rs1.getInt("employeeid"),
                                rs1.getString("emp_name"),
                                rs1.getString("time_in"),
                                rs1.getString("time_out"),
                                rs1.getString("mark_note"),
                                rs1.getString("working_time")
                        )
                );
            }
            rs1.close();
            common.closeConnection();
            return workingTime;
        } catch (SQLException ex) {
            Logger.getLogger(TEmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
