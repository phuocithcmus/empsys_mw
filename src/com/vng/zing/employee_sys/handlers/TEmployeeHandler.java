/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.employee_sys.handlers;

import com.vng.zing.emp.thrift.EmployeeService;
import com.vng.zing.emp.thrift.dto.Department;
import com.vng.zing.emp.thrift.dto.Employee;
import com.vng.zing.emp.thrift.dto.EmployeeWithString;
import com.vng.zing.emp.thrift.dto.ProfileEmp;
import com.vng.zing.emp.thrift.dto.Title;
import com.vng.zing.employee_sys.model.TEmployeeModel;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.stats.Profiler;
import com.vng.zing.stats.ThreadProfiler;
import java.util.List;
import org.apache.thrift.TException;

/**
 *
 * @author cpu11129
 */
public class TEmployeeHandler implements EmployeeService.Iface {

    private static final org.apache.log4j.Logger _Logger = ZLogger.getLogger(TEmployeeHandler.class);

    @Override
    public List<EmployeeWithString> getListEmp() throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.getListEmp", false);
        try {
            return TEmployeeModel.Instance.getListEmp();
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public EmployeeWithString getEmp(int emp_id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.getEmp", false);
        try {
            return TEmployeeModel.Instance.getEmp(emp_id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public boolean deactiveEmp(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.deactiveEmp", false);
        try {
            return TEmployeeModel.Instance.deactiveEmp(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public String createEmp(Employee emp) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.createEmp", false);
        try {
            return TEmployeeModel.Instance.createEmp(emp);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public List<Department> getAllDepartment() throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.getAllDepartment", false);
        try {
            return TEmployeeModel.Instance.getAllDepartment();
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public List<Title> getAllTitle() throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.getAllTitle", false);
        try {
            return TEmployeeModel.Instance.getAllTitle();
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public List<Employee> getEmployeeByDept(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.getEmployeeByDept", false);
        try {
            return TEmployeeModel.Instance.getEmployeeByDept(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public List<ProfileEmp> getProfileEmp(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.getProfileEmp", false);
        try {
            return TEmployeeModel.Instance.getProfileEmp(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public boolean activeEmp(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TEmployeeHandler.getProfileEmp", false);
        try {
            return TEmployeeModel.Instance.activeEmp(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

}
