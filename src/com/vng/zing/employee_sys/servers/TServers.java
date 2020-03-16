/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.employee_sys.servers;

import com.vng.zing.emp.thrift.EmployeeService;
import com.vng.zing.thriftserver.ThriftServers;
import com.vng.zing.employee_sys.handlers.TEmployeeHandler;
import com.vng.zing.employee_sys.handlers.TWorkingDayHandler;
import com.vng.zing.workingday.thrift.WorkingService;
import org.apache.thrift.TMultiplexedProcessor;

/**
 *
 * @author namnq
 */
public class TServers {

	public boolean setupAndStart() {
            ThriftServers servers = new ThriftServers("employee_sys");
            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            processor.registerProcessor("EmployeeService"
                    ,new EmployeeService.Processor(new TEmployeeHandler()));

            processor.registerProcessor("WorkingService"
                    ,new WorkingService.Processor(new TWorkingDayHandler()));
            
            servers.setup(processor);
            return servers.start();
	}
}
