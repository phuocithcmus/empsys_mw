#!/bin/sh

xrpcgen-0.9.0 --gen java calc.thrift
xrpcgen-0.9.0 --gen java emp.thrift
xrpcgen-0.9.0 --gen java emp_service.thrift
xrpcgen-0.9.0 --gen java working_day_infor.thrift
xrpcgen-0.9.0 --gen java working_service.thrift

cp gen-java/* ../src/ -rf
rm gen-java -rf

