package com.zwj.course.service;

import com.zwj.thrift.user.UserService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program microservice
 * @description:
 * @author: wj
 * @create: 2018/11/12 22:00
 */
@Component
public class ServiceProvider {

    @Value("${thrift.user.ip}")
    private String userServerIp;
    @Value("${thrift.user.port}")
    private Integer userServerPort;


    private enum ServiceType {
        USER}


    public UserService.Client  getUserService() {
        return (UserService.Client) getService(userServerIp,userServerPort, ServiceType.USER);
    }




    public TServiceClient getService(String serverIp ,Integer serverPort,ServiceType serviceType) {
        TSocket socket = new TSocket(serverIp,serverPort,3000);
        TTransport transport = new TFastFramedTransport(socket);

        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        TBinaryProtocol protocol = new TBinaryProtocol(transport);

        TServiceClient result = null;
        switch (serviceType) {
            case USER:
                result = new UserService.Client(protocol);
                break;
        }
        return result;
    }

}
