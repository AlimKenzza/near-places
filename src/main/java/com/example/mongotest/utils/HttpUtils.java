package com.example.mongotest.utils;


import com.example.mongotest.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class HttpUtils {
    private final ClientRepository clientRepository;

    public HttpUtils(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private static final String[] IP_HEADERS = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"

            // you can add more matching headers here ...
    };
    public static String getClientIpAddressIfServletRequestExist() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        return request.getRemoteAddr();
    }

//    @SuppressWarnings("ConstantConditions")
//    public String fetchClientIpAddr() {
//        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
//        String ip = Optional.ofNullable(request.getHeader("X-FORWARDED-FOR")).orElse(request.getRemoteAddr());
//        if (ip.equals("0:0:0:0:0:0:0:1")) ip = "236.104.209.170";
//        Assert.isTrue(ip.chars().filter($ -> $ == '.').count() == 3, "Illegal IP: " + ip);
//        Client client = new Client();
//        client.setId(sequenceGeneratorService.generateSequence(Client.SEQUENCE_NAME));
//        client.setClientIpAddress(ip);
//        client.setCreatedAt(Timestamp.from(Instant.now()));
//        client.setTimeSpentMinutes((int) ((Math.random() * (100)) + 0));
//        client.setUrl("https://www.nur.kz/");
//        client.setUrlId(1);
//        clientRepository.save(client);
//        return ip;
//    }
}
