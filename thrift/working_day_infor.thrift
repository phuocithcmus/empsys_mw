namespace java com.vng.zing.workingday.thrift.dto

struct WorkingDayInfo {
    1:required i32 id,
    2: string emp_name,
    3:required string time_in,
    4: string time_out
}
