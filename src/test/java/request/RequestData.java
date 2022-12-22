package request;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectWriter;

public class RequestData {

    public String name;
    public String job;
    public String email;
    public String password;


    public static RequestDataBuilder builder() {
        return new RequestDataBuilder();
    }

    public static final class RequestDataBuilder {
        private String name;
        private String job;
        private String email;
        private String password;

        public RequestDataBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RequestDataBuilder withJob(String job) {
            this.job = job;
            return this;
        }

        public RequestDataBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public RequestDataBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public String build() {
            RequestData requestData = new RequestData();
            requestData.name = this.name;
            requestData.job = this.job;
            requestData.email = this.email;
            requestData.password = this.password;
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String request = null;
            try {
                request = ow.writeValueAsString(requestData);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return request;
        }
    }
}
