namespace java com.vng.zing.emp.thrift.dto

struct Employee {
    1:required i32 id,
    2:required string emp_code,
    3: string emp_pass,
    4: string emp_name,
    5: string gender,
    6: string dob,
    7: string address,
    8: string phone_number,
    9: string identification_card,
    10:required string date_join,
    11: string date_left,
    12: string note,
    13: i32 emp_mng,
    14: i32 emp_room,
    15: i32 emp_pos,
    16: i32 role
}

