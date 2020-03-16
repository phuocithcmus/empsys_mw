namespace java com.vng.zing.workingday.thrift

include "emp.thrift"
include "working_day_infor.thrift"


service WorkingService {
    emp.Employee login(1:required string username, 2:required string password);
    working_day_infor.WorkingDayInfo clockIn(1:required string time_in);
    working_day_infor.WorkingDayInfo clockOut(1:required string time_out);
    working_day_infor.WorkingDayInfo getWorkingDayInfo(1:required i32 id, 2:required string date );
    list<working_day_infor.WorkingDayInfo> getWorkingInfo(1:required i32 id);
}
