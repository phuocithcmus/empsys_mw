namespace java com.vng.zing.emp.thrift

include "emp.thrift"


service EmployeeService {
    list<emp.Employee> getListEmp();
    emp.Employee getEmp(1:required i32 id);
    bool deactiveEmp(1:required i32 id);
    emp.Employee createEmp(1:required emp.Employee emp);
}
