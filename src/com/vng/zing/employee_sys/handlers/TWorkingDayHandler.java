/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.employee_sys.handlers;

import com.vng.zing.emp.thrift.dto.Employee;
import com.vng.zing.emp.thrift.dto.WorkingTime;
import com.vng.zing.employee_sys.model.TEmployeeModel;
import com.vng.zing.employee_sys.model.TWorkingdayModel;
import com.vng.zing.stats.Profiler;
import com.vng.zing.stats.ThreadProfiler;
import com.vng.zing.workingday.thrift.WorkingService;
import com.vng.zing.workingday.thrift.dto.WorkingDayInfo;
import java.util.ArrayList;
import java.util.List;
import org.apache.thrift.TException;

/**
 *
 * @author cpu11129
 */
public class TWorkingDayHandler implements WorkingService.Iface {

    @Override
    public Employee login(String username, String password) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TWorkingDayHandler.login", false);
        try {
            return TWorkingdayModel.Instance.login(username, "");
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public void clockIn(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TWorkingDayHandler.clockIn", false);
        try {
            TWorkingdayModel.Instance.clockIn(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public void clockOut(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TWorkingDayHandler.clockOut", false);
        try {
            TWorkingdayModel.Instance.clockOut(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public WorkingDayInfo getWorkingDayInfo(int id, String date) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WorkingDayInfo> getWorkingInfo(int id) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHourOffOrtherMonth(int id, String date_month) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TWorkingDayHandler.getHourOffOrtherMonth", false);
        try {
            return TWorkingdayModel.Instance.getHourOffOrtherMonth(id, date_month);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public List<Integer> isChecked(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TWorkingDayHandler.isChecked", false);
        try {
            return TWorkingdayModel.Instance.isChecked(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public List<String> timeChecked(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TWorkingDayHandler.timeChecked", false);
        try {
            return TWorkingdayModel.Instance.timeChecked(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

    @Override
    public List<WorkingTime> getWorkingTime(int id) throws TException {
        ThreadProfiler profiler = Profiler.createThreadProfiler("TWorkingDayHandler.getWorkingTime", false);
        try {
            return TWorkingdayModel.Instance.getWorkingTime(id);
        } finally {
            Profiler.closeThreadProfiler();
        }
    }

}
