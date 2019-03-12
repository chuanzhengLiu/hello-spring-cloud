package fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
@Component
public class WebAdminFeignFallbackProvider  implements FallbackProvider {
    @Override
    public String getRoute() {
        //如果需要所有调用都支持回退，则return "*"或 return null
        return "hello-spring-cloud-web-admin-feign";
    }

    //如果请求服务失败，则返回指定的信息给调用者。
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                HashMap<String, Object> map = new HashMap<>();
                map.put("status",200);
                map.put("message","无法连接，请检查你的网络");
                return new ByteArrayInputStream(mapper.writeValueAsString(map).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                // 和getBody 中的内容一致
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}
